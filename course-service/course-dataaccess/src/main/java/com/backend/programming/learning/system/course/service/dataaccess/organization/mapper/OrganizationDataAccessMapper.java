package com.backend.programming.learning.system.course.service.dataaccess.organization.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization.OrganizationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrganizationDataAccessMapper {

    public OrganizationResponseEntity organizationEntityToOrganizationResponseEntity(OrganizationEntity organizationEntity) {
        return OrganizationResponseEntity.builder()
                .organizationId(organizationEntity.getId())
                .description(organizationEntity.getDescription())
                .name(organizationEntity.getName())
                .apiKey(organizationEntity.getApiKey())
                .moodleUrl(organizationEntity.getMoodleUrl())
                .build();
    }

    public List<OrganizationResponseEntity> organizationEntityListToOrganizationList(List<OrganizationEntity> organizationEntityList) {
    return organizationEntityList.stream().map(this::organizationEntityToOrganizationResponseEntity).toList();
    }

    public OrganizationEntity organizationToOrganizationEntity(Organization organization) {
        return OrganizationEntity.builder()
                .id(organization.getId().getValue())
                .name(organization.getName())
                .description(organization.getDescription())
                .apiKey(organization.getApiKey())
                .moodleUrl(organization.getMoodleUrl())
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .isDeleted(organization.getDeleted())
                .build();
    }

    public OrganizationEntity organizationToOrganizationEntityHideSensitiveData(Organization organization) {
        return OrganizationEntity.builder()
                .id(organization.getId().getValue())
                .name(organization.getName())
                .description(organization.getDescription())
                .apiKey(null)
                .moodleUrl(null)
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .build();
    }

    public Organization organizationEntityToOrganization(OrganizationEntity organization) {
        return Organization.builder()
                .id(new OrganizationId(organization.getId()))
                .name(organization.getName())
                .description(organization.getDescription())
                .apiKey(organization.getApiKey())
                .moodleUrl(organization.getMoodleUrl())
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .isDeleted(organization.getIsDeleted())
                .build();
    }
}

