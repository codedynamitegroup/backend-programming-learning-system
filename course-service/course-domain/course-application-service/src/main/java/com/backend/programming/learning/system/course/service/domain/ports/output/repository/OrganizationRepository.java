package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization.OrganizationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository {
    Organization saveOrganization(Organization organization);

    Optional<Organization> findOrganizationById(UUID organizationId);

    List<OrganizationResponseEntity> findAllOrganization();


    void deleteOrganizationById(UUID organizationId);

    Optional<Organization> findOrganizationByName(String name);

    Optional<Organization> findOrganizationByMoodleUrl(String moodleUrl);
}
