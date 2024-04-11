package com.backend.programming.learning.system.auth.service.domain.ports.output.repository;

import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.valueobject.OrganizationId;

import java.util.Optional;

public interface OrganizationRepository {
    Optional<Organization> findById(OrganizationId organizationId);
}
