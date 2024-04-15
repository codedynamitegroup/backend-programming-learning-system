package com.backend.programming.learning.system.course.service.dataaccess.call_organization.repository;

import com.backend.programming.learning.system.course.service.dataaccess.call_organization.entity.CallOrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CallOrganizationJpaRepository extends JpaRepository<CallOrganizationEntity, UUID> {
    Optional<CallOrganizationEntity> findById(UUID id);
}
