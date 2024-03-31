package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.valueobject.OrganizationId;

import java.util.Optional;

public interface OrganizationRepository {
    Organization save(Organization organization);

    Optional<Organization> findById(OrganizationId organizationId);
}
