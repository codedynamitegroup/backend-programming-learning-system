package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.UserRole;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Component
public class UserRoleDataMapper {

    public UserRole createUserRoleCommandToUserRole(CreateUserRoleCommand createUserRoleCommand) {
        return UserRole.builder()
                .roleId(new RoleId(createUserRoleCommand.getRoleId()))
                .userId(new UserId(createUserRoleCommand.getUserId()))
                .name(createUserRoleCommand.getName())
                .createdBy(new UserId(createUserRoleCommand.getCreatedBy()))
                .updatedBy(new UserId(createUserRoleCommand.getUpdatedBy()))
                .build();
    }

    public CreateUserRoleResponse userRoleToCreateUserRoleResponse(UserRole userRole, String message) {
        return CreateUserRoleResponse.builder()
                .id(userRole.getId().getValue())
                .name(userRole.getName())
                .createdAt(userRole.getCreatedAt())
                .message(message)
                .build();
    }

    public QueryUserRoleResponse userRoleToQueryUserRoleResponse(UserRole userRole) {
        return QueryUserRoleResponse.builder()
                .id(userRole.getId().getValue())
                .name(userRole.getName())
                .createdAt(userRole.getCreatedAt())
                .build();
    }
}
