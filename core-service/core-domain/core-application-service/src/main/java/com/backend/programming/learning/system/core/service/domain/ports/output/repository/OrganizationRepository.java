package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.domain.entity.Organization;

import java.util.Optional;
import java.util.UUID;

/***********************************
 * Created by TGT on 31/03/2024.
 * Description: Auth repository port
 ************************************/

public interface OrganizationRepository {
    Optional<Organization> findOrganization(UUID organizationId);
}
