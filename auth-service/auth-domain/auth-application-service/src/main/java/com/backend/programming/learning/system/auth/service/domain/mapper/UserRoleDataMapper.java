package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_role.UserRoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
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
                .build();
    }

    public CreateUserRoleResponse userRoleToCreateUserRoleResponse(UserRole userRole, String message) {
        return CreateUserRoleResponse.builder()
                .userRoleId(userRole.getId().getValue())
                .message(message)
                .build();
    }

    public UserRoleEntityResponse userRoleToUserRoleResponse(UserRole userRole) {
        return UserRoleEntityResponse.builder()
                .userRoleId(userRole.getId().getValue())
                .user(userDataMapper.userToUserResponse(userRole.getUser()))
                .role(roleDataMapper.roleToRoleResponse(userRole.getRole()))
                .build();
    }

    public DeleteUserRoleResponse deleteUserRoleResponse(UUID roleId, UUID userId, String message) {
        return DeleteUserRoleResponse.builder()
                .roleId(roleId)
                .userId(userId)
                .message(message)
                .build();
    }
}
