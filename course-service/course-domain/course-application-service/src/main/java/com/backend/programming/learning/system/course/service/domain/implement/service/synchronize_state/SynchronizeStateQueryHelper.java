package com.backend.programming.learning.system.course.service.domain.implement.service.synchronize_state;

import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SynchronizeStateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SynchronizeStateQueryHelper {
    private final SynchronizeStateRepository synchronizeStateRepository;

    public SynchronizeState querySynchronizeStateByOrganizationIdAndStep(UUID organizationId, String step) {
        return synchronizeStateRepository.findSynchronizeStateByOrganizationIdAndStep(organizationId, step);
    }

    public List<SynchronizeState> querySynchronizeStateByOrganizationId(UUID organizationId) {
        return synchronizeStateRepository.findAllByOrganizationId(organizationId);
    }
}
