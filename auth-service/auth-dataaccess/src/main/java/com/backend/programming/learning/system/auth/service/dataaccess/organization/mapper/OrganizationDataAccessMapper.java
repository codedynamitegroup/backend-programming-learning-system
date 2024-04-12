package com.backend.programming.learning.system.auth.service.dataaccess.organization.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import org.springframework.stereotype.Component;


@Component
public class OrganizationDataAccessMapper {
    public Organization organizationEntityToOrganization(OrganizationEntity organizationEntity) {
        return Organization.builder()
                .id(new OrganizationId(organizationEntity.getId()))
                .name(organizationEntity.getName())
                .description(organizationEntity.getDescription())
                .email(organizationEntity.getEmail())
                .phone(organizationEntity.getPhone())
                .address(organizationEntity.getAddress())
                .apiKey(organizationEntity.getApiKey())
                .moodleUrl(organizationEntity.getMoodleUrl())
                .createdAt(organizationEntity.getCreatedAt())
                .updatedAt(organizationEntity.getUpdatedAt())
                .isDeleted(organizationEntity.getIsDeleted())
                .build();
    }

    public OrganizationEntity organizationToOrganizationEntity(Organization organization) {
        return OrganizationEntity.builder()
                .id(organization.getId().getValue())
                .name(organization.getName())
                .description(organization.getDescription())
                .email(organization.getEmail())
                .phone(organization.getPhone())
                .address(organization.getAddress())
                .apiKey(organization.getApiKey())
                .moodleUrl(organization.getMoodleUrl())
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .isDeleted(organization.getDeleted())
                .build();
    }
}
