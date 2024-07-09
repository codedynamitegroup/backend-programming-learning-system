package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.SynchronizeStateScheduler;

import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.synchronize_state.SynchronizeStateApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateRepository;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class SynchronizeStateScheduler {

    private final SynchronizeStateRepository synchronizeStateRepository;
    private final SynchronizeStateApplicationService synchronizeStateApplicationService;

    @Transactional
    @Scheduled(fixedRateString = "${course-service.synchronize-scheduler-fixed-rate}", initialDelayString = "${course-service.synchronize-scheduler-initial-delay}")
    public void processOutboxMessage() {
        log.info("Processing outbox message for synchronize state");
        List<SynchronizeState> synchronizeStateList = synchronizeStateRepository.findByStatus(SynchronizeStatus.PROCESSING);
        if (!synchronizeStateList.isEmpty()) {
            synchronizeStateList.forEach(synchronizeState -> {
                try {
                    log.info("Synchronizing state for organization id: {}", synchronizeState.getOrganization().getId());
                    performSynchronization(synchronizeState);
                } catch (Exception e) {
                    log.error("Error while synchronizing state for organization id: {}", synchronizeState.getOrganization().getId(), e);
                    synchronizeState.setStatus(SynchronizeStatus.FAILED);
                    synchronizeStateRepository.save(synchronizeState);
                }
            });
        }
    }

    public void performSynchronization(SynchronizeState synchronizeState) {
        try {
            if (synchronizeState.getStep().equals(SynchronizeStep.USER)) {
                boolean success = synchronizeStateApplicationService.syncUser(synchronizeState.getOrganization().getId().getValue());
                handleSynchronizationResult(synchronizeState, success, SynchronizeStep.COURSE);
            } else if (synchronizeState.getStep().equals(SynchronizeStep.COURSE)) {
                boolean success = synchronizeStateApplicationService.syncCourse(synchronizeState.getOrganization().getId().getValue());
                handleSynchronizationResult(synchronizeState, success, SynchronizeStep.RESOURCE);
            } else if (synchronizeState.getStep().equals(SynchronizeStep.RESOURCE)) {
                boolean success = synchronizeStateApplicationService.syncResource(synchronizeState.getOrganization().getId().getValue());
                if (success) {
                    setStatus(synchronizeState, SynchronizeStatus.SUCCESS);
                } else {
                    synchronizeState.setSyncCount(synchronizeState.getSyncCount() + 1);
                    if (synchronizeState.getSyncCount() > 5) {
                        setStatus(synchronizeState, SynchronizeStatus.FAILED);
                    } else {
                        synchronizeStateRepository.save(synchronizeState);
                    }
                }
            }
        } catch (Exception e) {
            log.error("Error while synchronizing state for organization id: {}", synchronizeState.getOrganization().getId(), e);
            synchronizeState.setStatus(SynchronizeStatus.FAILED);
            synchronizeStateRepository.save(synchronizeState);
        }
    }

    private void handleSynchronizationResult(SynchronizeState synchronizeState, boolean success, SynchronizeStep nextStep) {
        if (success) {
            SynchronizeState nextSynchronizeState = synchronizeStateRepository.findByOrganizationIdAndSynchronizeStep(synchronizeState.getOrganization().getId().getValue(), nextStep);
            Integer syncCount = synchronizeState.getSyncCount();
            synchronizeState.setSyncCount(syncCount + 1);
            setStatus(synchronizeState, SynchronizeStatus.SUCCESS);
            setStatus(nextSynchronizeState, SynchronizeStatus.PROCESSING);
        } else {
            if (synchronizeState.getSyncCount() == 5) {
                setStatus(synchronizeState, SynchronizeStatus.FAILED);
            } else {
                Integer syncCount = synchronizeState.getSyncCount();
                synchronizeState.setSyncCount(syncCount + 1);
                synchronizeStateRepository.save(synchronizeState);
            }

        }
    }

    public void setStatus(SynchronizeState synchronizeState, SynchronizeStatus status) {
        synchronizeState.setStatus(status);
        synchronizeStateRepository.save(synchronizeState);
    }
}
