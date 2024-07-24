package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.SynchronizeStateScheduler;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.notification.NotificationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.synchronize_state.SynchronizeStateApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.socket.emitter.message.NotificationMessageEmitter;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Component
public class SynchronizeStateScheduler {

    private final SynchronizeStateRepository synchronizeStateRepository;
    private final SynchronizeStateApplicationService synchronizeStateApplicationService;
    private final UserRepository userRepository;
    private final NotificationMessageEmitter<NotificationResponseEntity> notificationMessageEmitter;
    private final UserDataMapper userDataMapper;

    @Transactional
    @Scheduled(fixedRateString = "${course-service.synchronize-scheduler-fixed-rate}", initialDelayString = "${course-service.synchronize-scheduler-initial-delay}")
    public void processOutboxMessage() {
        log.info("Processing outbox message for synchronize state");
        List<SynchronizeState> synchronizeStateList = synchronizeStateRepository.findByStatus(SynchronizeStatus.PROCESSING);
        if (!synchronizeStateList.isEmpty()) {
            synchronizeStateList.forEach(this::processSingleState);
        }
    }

    private void processSingleState(SynchronizeState synchronizeState) {
        try {
            log.info("Synchronizing state for organization id: {}", synchronizeState.getOrganization().getId());
            performSynchronization(synchronizeState);
        } catch (Exception e) {
            log.error("Error while synchronizing state for organization id: {}", synchronizeState.getOrganization().getId(), e);
            updateStateStatus(synchronizeState, SynchronizeStatus.FAILED);
            sendNotification(synchronizeState, "SYNC_FAILED");
        }
    }

    private void performSynchronization(SynchronizeState synchronizeState) {
        switch (synchronizeState.getStep()) {
            case USER:
                handleUserSync(synchronizeState);
                break;
            case COURSE:
                handleCourseSync(synchronizeState);
                break;
            case RESOURCE:
                handleResourceSync(synchronizeState);
                break;
        }
    }

    private void handleUserSync(SynchronizeState synchronizeState) {
        if (synchronizeStateApplicationService.syncUser(synchronizeState.getOrganization().getId().getValue())) {
            handleSyncSuccess(synchronizeState, SynchronizeStep.COURSE, "USER_SYNC_COMPLETED");
        } else {
            handleSyncFailure(synchronizeState, "USER_SYNC_FAILED");
        }
    }

    private void handleCourseSync(SynchronizeState synchronizeState) {
        if (synchronizeStateApplicationService.syncCourse(synchronizeState.getOrganization().getId().getValue())) {
            handleSyncSuccess(synchronizeState, SynchronizeStep.RESOURCE, "COURSE_SYNC_COMPLETED");
        } else {
            handleSyncFailure(synchronizeState, "COURSE_SYNC_FAILED");
        }
    }

    private void handleResourceSync(SynchronizeState synchronizeState) {
        if (synchronizeStateApplicationService.syncResource(synchronizeState.getOrganization().getId().getValue())) {
            updateStateStatus(synchronizeState, SynchronizeStatus.SUCCESS);
            sendNotification(synchronizeState, "RESOURCE_SYNC_COMPLETED");
        } else {
            retrySync(synchronizeState);
        }
    }

    private void handleSyncSuccess(SynchronizeState synchronizeState, SynchronizeStep nextStep, String notificationSubject) {
        updateStateStatus(synchronizeState, SynchronizeStatus.SUCCESS);
        SynchronizeState nextSynchronizeState = synchronizeStateRepository.findByOrganizationIdAndSynchronizeStep(synchronizeState.getOrganization().getId().getValue(), nextStep);
        if (nextSynchronizeState != null) {
            updateStateStatus(nextSynchronizeState, SynchronizeStatus.PROCESSING);
        }
        sendNotification(synchronizeState, notificationSubject);
    }

    private void handleSyncFailure(SynchronizeState synchronizeState, String notificationSubject) {
        if (synchronizeState.getSyncCount() >= 5) {
            updateStateStatus(synchronizeState, SynchronizeStatus.FAILED);
            sendNotification(synchronizeState, notificationSubject);
        } else {
            synchronizeState.setSyncCount(synchronizeState.getSyncCount() + 1);
            synchronizeStateRepository.save(synchronizeState);
        }
    }

    private void retrySync(SynchronizeState synchronizeState) {
        synchronizeState.setSyncCount(synchronizeState.getSyncCount() + 1);
        if (synchronizeState.getSyncCount() > 5) {
            updateStateStatus(synchronizeState, SynchronizeStatus.FAILED);
            sendNotification(synchronizeState, "RESOURCE_SYNC_FAILED");
        } else {
            synchronizeStateRepository.save(synchronizeState);
        }
    }

    private void updateStateStatus(SynchronizeState synchronizeState, SynchronizeStatus status) {
        synchronizeState.setStatus(status);
        synchronizeStateRepository.save(synchronizeState);
    }

    private void sendNotification(SynchronizeState synchronizeState, String subject) {
        UserResponseEntity userResponseEntity = userDataMapper.userToUserResponseEntity(synchronizeState.getUser());
        NotificationResponseEntity notification = createNotification(userResponseEntity, subject);
        String room = "email_" + synchronizeState.getUser().getEmail();
        notificationMessageEmitter.emit(room, "course_step_sync_completed", notification);
    }

    private NotificationResponseEntity createNotification(UserResponseEntity user, String subject) {
        return NotificationResponseEntity.builder()
                .notificationId(UUID.randomUUID())
                .userFrom(user)
                .userTo(user)
                .subject(subject)
                .component(NotificationComponentType.SYNC)
                .eventType(NotificationEventType.COURSE)
                .isRead(false)
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")).toString())
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")).toString())
                .build();
    }
}
