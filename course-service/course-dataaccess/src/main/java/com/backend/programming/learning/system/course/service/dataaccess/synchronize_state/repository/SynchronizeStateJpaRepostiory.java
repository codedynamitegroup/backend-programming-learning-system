package com.backend.programming.learning.system.course.service.dataaccess.synchronize_state.repository;

import com.backend.programming.learning.system.course.service.dataaccess.synchronize_state.entity.SynchronizeStateEntity;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStatus;
import com.backend.programming.learning.system.domain.valueobject.SynchronizeStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SynchronizeStateJpaRepostiory extends JpaRepository<SynchronizeStateEntity, UUID> {

    List<SynchronizeStateEntity> findAllByOrganizationId(UUID organizationId);

    SynchronizeStateEntity findByOrganizationIdAndStep(UUID organizationId, SynchronizeStep step);

    List<SynchronizeStateEntity> findByStatus(SynchronizeStatus status);
}
