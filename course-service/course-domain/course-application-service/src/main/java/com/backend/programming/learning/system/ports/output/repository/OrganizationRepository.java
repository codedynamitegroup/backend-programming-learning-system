package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Organization;

public interface OrganizationRepository {
    Organization saveOrganization(Organization organization);
}
