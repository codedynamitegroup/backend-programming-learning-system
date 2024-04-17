package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Organization;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository {
    Organization saveOrganization(Organization organization);

    Optional<Organization> findOrganization(UUID organizationId);
}
