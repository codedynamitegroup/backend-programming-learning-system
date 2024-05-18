package com.backend.programming.learning.system.core.service.dataaccess.organization.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.OrganizationResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import org.springframework.stereotype.Component;

@Component
public class OrganizationDataAccessMapper {
    public Organization organizationEntityToOrganization(OrganizationEntity organizationEntity) {
        return Organization.builder()
                .id(new OrganizationId(organizationEntity.getId()))
                .name(organizationEntity.getName())
                .description(organizationEntity.getDescription())
                .moodleUrl(organizationEntity.getMoodleUrl())
                .apiKey(organizationEntity.getApiKey())
                .isDeleted(organizationEntity.getIsDeleted())
                .createdAt(organizationEntity.getCreatedAt())
                .updatedAt(organizationEntity.getUpdatedAt())
                .build();
    }

    public OrganizationEntity organizationToOrganizationEntity(Organization organization) {
        return OrganizationEntity.builder()
                .id(organization.getId().getValue())
                .name(organization.getName())
                .description(organization.getDescription())
                .moodleUrl(organization.getMoodleUrl())
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .isDeleted(organization.getDeleted())
                .apiKey(organization.getApiKey())
                .build();
    }

    public Organization organizationEntityToOrganizationHideSensitiveData(OrganizationEntity organizationEntity) {
        return Organization.builder()
                .id(new OrganizationId(organizationEntity.getId()))
                .name(organizationEntity.getName())
                .description(organizationEntity.getDescription())
                .moodleUrl(null)
                .isDeleted(null)
                .createdAt(null)
                .updatedAt(null)
                .build();
    }


    public OrganizationResponseEntity organizationEntityToOrganizationResponseEntity(OrganizationEntity organizationEntity) {
        return OrganizationResponseEntity.builder()
                .id(organizationEntity.getId().toString())
                .name(organizationEntity.getName())
                .description(organizationEntity.getDescription())
                .moodleUrl(organizationEntity.getMoodleUrl())
                .apiKey(organizationEntity.getApiKey())
                .isDeleted(organizationEntity.getIsDeleted())
                .createdAt(organizationEntity.getCreatedAt())
                .updatedAt(organizationEntity.getUpdatedAt())
                .build();
    }
}
