package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class RoleDataMapper {
    public Role createRoleCommandToRole(CreateRoleCommand createRoleCommand) {
        return Role.builder()
                .name(createRoleCommand.getName())
                .organizationId(new OrganizationId(createRoleCommand.getOrganizationId()))
                .description(createRoleCommand.getDescription())
                .createdBy(new UserId(createRoleCommand.getCreatedBy()))
                .updatedBy(new UserId(createRoleCommand.getUpdatedBy()))
                .build();
    }

    public CreateRoleResponse roleToCreateRoleResponse(Role role, String message) {
        return CreateRoleResponse.builder()
                .id(role.getId().getValue())
                .name(role.getName())
                .description(role.getDescription())
                .message(message)
                .build();
    }

    public QueryRoleResponse roleToQueryRoleResponse(Role role) {
        return QueryRoleResponse.builder()
                .id(role.getId().getValue())
                .name(role.getName())
                .description(role.getDescription())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .build();
    }
}
