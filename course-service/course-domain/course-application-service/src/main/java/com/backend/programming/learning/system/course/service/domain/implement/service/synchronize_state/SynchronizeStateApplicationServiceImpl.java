package com.backend.programming.learning.system.course.service.domain.implement.service.synchronize_state;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state.QuerySynchronizeStateCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.synchronize_state.QuerySynchronizeStateResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.synchronize_state.SynchronizeStateApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateRepository;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.UUID;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class SynchronizeStateApplicationServiceImpl implements SynchronizeStateApplicationService {

    private final MoodleCommandHandler moodleCommandHandler;
    private final OrganizationRepository organizationRepository;
    private final SynchronizeStateRepository synchronizeStateRepository;
    private final SynchronizeStateCommandHandler synchronizeStateCommandHandler;


    private Organization getOrganization(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganizationById(organizationId);
        if (organization == null) {
            log.error("Organization is not found");
            throw new RuntimeException("Organization is not found");
        }
        log.info("Organization is found");
        return organization.get();
    }
    @Override
    public String syncDataMoodle(UUID organizationId) {
        Organization organization = getOrganization(organizationId);
        for(SynchronizeStep synchronizeStep : SynchronizeStep.values()){
            SynchronizeState synchronizeState = SynchronizeState.builder().build();
            synchronizeState.initializeSynchronizeState();
            if(synchronizeStep.equals(SynchronizeStep.USER)) {
                synchronizeState.setStatus(SynchronizeStatus.PROCESSING);
            }
            else {
                synchronizeState.setStatus(SynchronizeStatus.PENDING);
            }
            synchronizeState.setOrganization(organization);
            synchronizeState.setStep(synchronizeStep);
            synchronizeStateRepository.save(synchronizeState);
        }
        return "Synchronization started";
    }

    @Override
    public QuerySynchronizeStateResponse querySynchronizeByOrganizationIdAndStep(QuerySynchronizeStateCommand querySynchronizeStateCommand) {
        return
                synchronizeStateCommandHandler.querySynchronizeByOrganizationIdAndStep(querySynchronizeStateCommand.getOrganizationId(), querySynchronizeStateCommand.getStep());
    }

    @Override
    public Boolean syncUser(UUID organizationId) {
        try {
            moodleCommandHandler.syncUser(organizationId);
            return true;
        } catch (Exception e) {
            log.error("Error while synchronizing user for organization id: {}", organizationId, e);
            return false;
        }
    }

    @Override
    public Boolean syncCourse(UUID organizationId) {
        try {
            moodleCommandHandler.syncCourse(organizationId);
            return true;
        } catch (Exception e) {
            log.error("Error while synchronizing course for organization id: {}", organizationId, e);
            return false;
        }
    }

    @Override
    public Boolean syncResource(UUID organizationId) {
        try {
            moodleCommandHandler.syncResource(organizationId);
            return true;
        } catch (Exception e) {
            log.error("Error while synchronizing resource for organization id: {}", organizationId, e);
            return false;
        }
    }
}
