package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.OrganizationRole;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationRoleRepository {
    OrganizationRole save(OrganizationRole organizationRole);

    Optional<OrganizationRole> findById(UUID id);

}
