package com.backend.programming.learning.system.course.service.domain.implement.service.synchronize_state;

import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.implement.service.moodle.MoodleCommandHandler;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.synchronize_state.SynchronizeStateApplicationService;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateRepository;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class SynchronizeStateApplicationServiceImpl implements SynchronizeStateApplicationService {

    private final MoodleCommandHandler moodleCommandHandler;

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
