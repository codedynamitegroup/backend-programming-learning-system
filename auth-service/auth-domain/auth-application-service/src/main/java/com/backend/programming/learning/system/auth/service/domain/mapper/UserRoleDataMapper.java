package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.role.RoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_role.UserRoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class UserRoleDataMapper {
    private final UserDataMapper userDataMapper;
    private final RoleDataMapper roleDataMapper;

    public UserRoleDataMapper(UserDataMapper userDataMapper, RoleDataMapper roleDataMapper) {
        this.userDataMapper = userDataMapper;
        this.roleDataMapper = roleDataMapper;
    }

    public UserRole createUserRoleCommandToUserRole(CreateUserRoleCommand createUserRoleCommand) {
        return UserRole.builder()
                .role(Role.builder()
                        .id(new RoleId(createUserRoleCommand.getRoleId()))
                        .build())
                .user(User.builder()
                        .id(new UserId(createUserRoleCommand.getUserId()))
                        .build())
                .name(createUserRoleCommand.getName())
                .createdBy(User.builder()
                        .id(new UserId(createUserRoleCommand.getCreatedBy()))
                        .build())
                .updatedBy(User.builder()
                        .id(new UserId(createUserRoleCommand.getUpdatedBy()))
                        .build())
                .build();
    }

    public CreateUserRoleResponse userRoleToCreateUserRoleResponse(UserRole userRole, String message) {
        return CreateUserRoleResponse.builder()
                .id(userRole.getId().getValue())
                .name(userRole.getName())
                .message(message)
                .build();
    }

    public UserRoleEntityResponse userRoleToUserRoleResponse(UserRole userRole) {
        return UserRoleEntityResponse.builder()
                .userRoleId(userRole.getId().getValue())
                .user(userDataMapper.userToUserResponse(userRole.getUser()))
                .role(roleDataMapper.roleToRoleResponse(userRole.getRole()))
                .createdBy(userDataMapper.userToUserResponse(userRole.getCreatedBy()))
                .updatedBy(userDataMapper.userToUserResponse(userRole.getUpdatedBy()))
                .isActive(userRole.isActive())
                .name(userRole.getName())
                .createdAt(userRole.getCreatedAt())
                .updatedAt(userRole.getUpdatedAt())
                .build();
    }
}
