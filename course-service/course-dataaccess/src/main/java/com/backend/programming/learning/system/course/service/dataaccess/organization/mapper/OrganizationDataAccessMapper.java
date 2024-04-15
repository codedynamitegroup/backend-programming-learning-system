package com.backend.programming.learning.system.course.service.dataaccess.organization.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.entity.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationDataAccessMapper {

    public OrganizationEntity organizationToOrganizationEntity(Organization organization) {
        return OrganizationEntity.builder()
                .id(organization.getId().getValue())
                .description(organization.getDescription())
                .name(organization.getName())
                .apiKey(organization.getApiKey())
                .moodleUrl(organization.getMoodleUrl())
                .build();
    }

    public Organization organizationEntityToOrganization(OrganizationEntity organizationEntity) {
        return Organization.builder()
                .id(new OrganizationId(organizationEntity.getId()))
                .description(organizationEntity.getDescription())
                .name(organizationEntity.getName())
                .apiKey(organizationEntity.getApiKey())
                .moodleUrl(organizationEntity.getMoodleUrl())
                .build();
    }
}
