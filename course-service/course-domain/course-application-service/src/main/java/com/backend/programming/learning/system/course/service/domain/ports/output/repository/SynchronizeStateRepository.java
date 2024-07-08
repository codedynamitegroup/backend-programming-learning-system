package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeState;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;

import java.util.List;
import java.util.UUID;

public interface SynchronizeStateRepository {
    SynchronizeState save(SynchronizeState synchronizeState);

    List<SynchronizeState> findAllByOrganizationId(UUID organizationId);

    SynchronizeState findByOrganizationIdAndSynchronizeStep(UUID organizationId, SynchronizeStep synchronizeStep);

    List<SynchronizeState> findByStatus(SynchronizeStatus status);

}
