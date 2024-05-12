package com.backend.programming.learning.system.course.service.dataaccess.organization_role.repository;

import com.backend.programming.learning.system.course.service.dataaccess.organization_role.entity.OrganizationRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrganizationRoleJpaRepository extends JpaRepository<OrganizationRoleEntity, UUID>{
    Optional<OrganizationRoleEntity> findById(UUID id);

}
