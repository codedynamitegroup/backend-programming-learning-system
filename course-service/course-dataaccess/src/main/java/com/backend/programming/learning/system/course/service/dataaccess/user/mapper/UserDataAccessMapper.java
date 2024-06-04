package com.backend.programming.learning.system.course.service.dataaccess.user.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.organization.mapper.OrganizationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.entity.RoleMoodleEntity;
import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.mapper.RoleMoodleDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.RoleMoodle;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataAccessMapper {
    private final OrganizationDataAccessMapper organizationDataAccessMapper;

    private final RoleMoodleDataAccessMapper roleMoodleDataAccessMapper;

    public UserDataAccessMapper(OrganizationDataAccessMapper organizationDataAccessMapper, RoleMoodleDataAccessMapper roleMoodleDataAccessMapper) {
        this.organizationDataAccessMapper = organizationDataAccessMapper;
        this.roleMoodleDataAccessMapper = roleMoodleDataAccessMapper;
    }

    public UserEntity userToUserEntity(User user) {
        OrganizationEntity organizationEntity = organizationDataAccessMapper.
                organizationToOrganizationEntity(user.getOrganization());

        RoleMoodleEntity roleMoodleEntity = roleMoodleDataAccessMapper.
                roleMoodleToRoleMoodleEntity(user.getRoleMoodle());

        return UserEntity.builder()
                .id(user.getId().getValue())
                .roleMoodle(roleMoodleEntity)
                .organization(organizationEntity)
                .username(user.getUserName())
                .userIdMoodle(user.getUserIdMoodle())
                .email(user.getEmail())
                .dob(user.getDob())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .avatarUrl(user.getAvatarUrl())
                .lastLogin(user.getLastLogin())
                .isDeleted(user.getDeleted())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public User userEntityToUser(UserEntity userEntity) {
        Organization organization = organizationDataAccessMapper.
                organizationEntityToOrganization(userEntity.getOrganization());

        RoleMoodle roleMoodle = roleMoodleDataAccessMapper.
                roleMoodleEntityToRoleMoodle(userEntity.getRoleMoodle());

        return User.builder()
                .id(new UserId(userEntity.getId()))
                .roleMoodle(roleMoodle)
                .userIdMoodle(userEntity.getUserIdMoodle())
                .organization(organization)
                .username(userEntity.getUsername())
                .name(userEntity.getUsername())
                .email(userEntity.getEmail())
                .dob(userEntity.getDob())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .phone(userEntity.getPhone())
                .address(userEntity.getAddress())
                .avatarUrl(userEntity.getAvatarUrl())
                .lastLogin(userEntity.getLastLogin())
                .isDeleted(userEntity.getIsDeleted())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .build();

    }

    public List<User> userEntityListToUserList(List<UserEntity> all) {
        return
            all.stream()
                .map(this::userEntityToUser)
                .toList();
    }
}
