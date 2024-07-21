package com.backend.programming.learning.system.course.service.dataaccess.synchronize_state_detail.repository;

import com.backend.programming.learning.system.course.service.dataaccess.synchronize_state_detail.entity.SynchronizeStateDetailEntity;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import com.backend.programming.learning.system.domain.valueobject.TypeSynchronizeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SynchronizeStateDetailJpaRepostiory extends JpaRepository<SynchronizeStateDetailEntity, UUID> {

    List<SynchronizeStateDetailEntity> findSynchronizeStateDetailByOrganizationIdAndStatus(UUID organizationId, TypeSynchronizeStatus status);

    List<SynchronizeStateDetailEntity> findSynchronizeStateDetailByStatus(TypeSynchronizeStatus status);
}
