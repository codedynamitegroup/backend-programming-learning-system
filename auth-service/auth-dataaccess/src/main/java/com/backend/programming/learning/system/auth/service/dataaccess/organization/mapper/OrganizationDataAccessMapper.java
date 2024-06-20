package com.backend.programming.learning.system.auth.service.dataaccess.organization.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.user.repository.UserJpaRepository;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;


@Component
public class OrganizationDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public OrganizationDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
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
                .createdBy(userDataAccessMapper.userEntityToUser(organizationEntity.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userEntityToUser(organizationEntity.getUpdatedBy()))
                .isDeleted(organizationEntity.getIsDeleted())
                .isVerified(organizationEntity.getIsVerified())
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
                .createdBy(userDataAccessMapper.userToUserEntity(organization.getCreatedBy()))
                .updatedBy(userDataAccessMapper.userToUserEntity(organization.getUpdatedBy()))
                .isDeleted(organization.getDeleted())
                .isVerified(organization.getVerified())
                .build();
    }
}
