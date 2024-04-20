package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user_role.UpdateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user_role.UpdateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_role.UserRoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.auth.service.domain.valueobject.UserRoleId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

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
                .name(createUserRoleCommand.getName())
                .build();
    }

    public CreateUserRoleResponse userRoleToCreateUserRoleResponse(UserRole userRole, String message) {
        return CreateUserRoleResponse.builder()
                .userRoleId(userRole.getId().getValue())
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

    public UserRole updateUserRoleCommandToUserRole(UpdateUserRoleCommand updateUserRoleCommand) {
        return UserRole.builder()
                .id(new UserRoleId(updateUserRoleCommand.getUserRoleId()))
                .name(updateUserRoleCommand.getName())
                .isActive(updateUserRoleCommand.getIsActive())
                .build();
    }

    public DeleteUserRoleResponse deleteUserRoleResponse(UUID roleId, UUID userId, String message) {
        return DeleteUserRoleResponse.builder()
                .roleId(roleId)
                .userId(userId)
                .message(message)
                .build();
    }

    public UpdateUserRoleResponse userRoleToUpdateUserRoleResponse(UserRole userRoleUpdated, String message) {
        return UpdateUserRoleResponse.builder()
                .userRoleId(userRoleUpdated.getId().getValue())
                .message(message)
                .build();
    }
}
