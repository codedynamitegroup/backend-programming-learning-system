package com.backend.programming.learning.system.auth.service.dataaccess.organization.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;


@Component
public class OrganizationDataAccessMapper {
    private final UserJpaRepository userJpaRepository;

    public OrganizationDataAccessMapper(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

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
                .createdBy(new UserId(organizationEntity.getCreatedBy().getId()))
                .updatedBy(new UserId(organizationEntity.getUpdatedBy().getId()))
                .isDeleted(organizationEntity.getIsDeleted())
                .build();
    }

    public OrganizationEntity organizationToOrganizationEntity(Organization organization) {
        UserEntity createdBy = userJpaRepository.findById(organization.getCreatedBy().getValue())
                .orElseThrow(() -> new RuntimeException("User with id: " + organization.getCreatedBy().getValue() + " could not be found!"));
        UserEntity updatedBy = userJpaRepository.findById(organization.getUpdatedBy().getValue())
                .orElseThrow(() -> new RuntimeException("User with id: " + organization.getUpdatedBy().getValue() + " could not be found!"));
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
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .isDeleted(organization.getDeleted())
                .build();
    }
}
