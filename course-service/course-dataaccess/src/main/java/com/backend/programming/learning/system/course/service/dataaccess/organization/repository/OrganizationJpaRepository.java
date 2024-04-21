package com.backend.programming.learning.system.course.service.dataaccess.organization.repository;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrganizationJpaRepository extends JpaRepository<OrganizationEntity, UUID> {
    Optional<OrganizationEntity> findById(UUID organizationId);

    List<OrganizationEntity> findAll();
}
