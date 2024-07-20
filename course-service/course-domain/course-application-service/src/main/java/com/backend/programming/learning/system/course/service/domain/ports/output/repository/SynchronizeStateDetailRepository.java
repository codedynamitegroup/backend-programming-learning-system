package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.SynchronizeStateDetail;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;

import java.util.List;
import java.util.UUID;

public interface SynchronizeStateDetailRepository {

    SynchronizeStateDetail save(SynchronizeStateDetail synchronizeStateDetail);

    List<SynchronizeStateDetail> findSynchronizeStateDetailByOrganizationIdAndStatus(UUID organizationId, TypeSynchronizeStatus status);

    List<SynchronizeStateDetail> findSynchronizeStateDetailByStatus(TypeSynchronizeStatus synchronizeStatus);


    void delete(SynchronizeStateDetail synchronizeStateDetail);
}
