package com.backend.programming.learning.system.auth.service.dataaccess.user.mapper;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.role.mapper.RoleDataAccessMapper;
import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserDataAccessMapper {
    private final RoleDataAccessMapper roleDataAccessMapper;

    public UserDataAccessMapper(RoleDataAccessMapper roleDataAccessMapper) {
        this.roleDataAccessMapper = roleDataAccessMapper;
    }

    public Organization organizationEntityToOrganization(OrganizationEntity organizationEntity) {
        return Organization.builder()
                .id(new OrganizationId(organizationEntity.getId()))
                .name(organizationEntity.getName())
                .description(organizationEntity.getDescription())
                .email(organizationEntity.getEmail())
                .phone(organizationEntity.getPhone())
                .address(organizationEntity.getAddress())
                .apiKey(null)
                .moodleUrl(null)
                .createdAt(organizationEntity.getCreatedAt())
                .updatedAt(organizationEntity.getUpdatedAt())
                .createdBy(null)
                .updatedBy(null)
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
                .apiKey(null)
                .moodleUrl(null)
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .createdBy(null)
                .updatedBy(null)
                .isDeleted(organization.getDeleted())
                .build();
    }

    public User userEntityToUser(UserEntity userEntity) {
        return User.builder()
                .id(new UserId(userEntity.getId()))
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .address(userEntity.getAddress())
                .dob(userEntity.getDob())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .phone(userEntity.getPhone())
                .avatarUrl(userEntity.getAvatarUrl())
                .lastLogin(userEntity.getLastLogin())
                .refreshToken(userEntity.getRefreshToken())
                .isLinkedWithGoogle(userEntity.getIsLinkedWithGoogle())
                .isLinkedWithMicrosoft(userEntity.getIsLinkedWithMicrosoft())
                .isDeleted(userEntity.getIsDeleted())
                .otp(userEntity.getOtp())
                .organization(userEntity.getOrganization() != null ? organizationEntityToOrganization(userEntity.getOrganization()) : null)
                .roles(userEntity.getRoles().stream().map(roleDataAccessMapper::roleEntityToRole).collect(Collectors.toSet()))
                .otpExpireAt(userEntity.getOtpExpireAt())
                .build();
    }

    public UserEntity userToUserEntity(User user) {
        return UserEntity.builder()
                .id(user.getId().getValue())
                .email(user.getEmail())
                .username(user.getUsername())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .address(user.getAddress())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .avatarUrl(user.getAvatarUrl())
                .lastLogin(user.getLastLogin())
                .refreshToken(user.getRefreshToken())
                .isLinkedWithGoogle(user.getLinkedWithGoogle())
                .isLinkedWithMicrosoft(user.getLinkedWithMicrosoft())
                .isDeleted(user.getDeleted())
                .otp(user.getOtp())
                .organization(user.getOrganization() != null ? organizationToOrganizationEntity(user.getOrganization()) : null)
                .roles(user.getRoles().stream().map(roleDataAccessMapper::roleToRoleEntity).collect(Collectors.toSet()))
                .otpExpireAt(user.getOtpExpireAt())
                .build();
    }
}
