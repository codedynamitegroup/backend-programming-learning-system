package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository {
    Organization save(Organization organization);
    Optional<Organization> findById(OrganizationId organizationId);

    List<Organization> findAll();
}
