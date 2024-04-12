package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.*;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.AuthApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class AuthApplicationServiceImpl implements AuthApplicationService {
    private final UserCreateCommandHandler userCreateCommandHandler;
    private final OrganizationCreateCommandHandler organizationCreateCommandHandler;
    private final RoleCreateCommandHandler roleCreateCommandHandler;

    private final UserQueryCommandHandler userQueryCommandHandler;

    AuthApplicationServiceImpl(UserCreateCommandHandler userCreateCommandHandler, OrganizationCreateCommandHandler organizationCreateCommandHandler, RoleCreateCommandHandler roleCreateCommandHandler, UserQueryCommandHandler userQueryCommandHandler) {
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.organizationCreateCommandHandler = organizationCreateCommandHandler;
        this.roleCreateCommandHandler = roleCreateCommandHandler;
        this.userQueryCommandHandler = userQueryCommandHandler;
    }

    @Override
    public CreateUserResponse createUser(CreateUserCommand createUserCommand) {
        return userCreateCommandHandler.createUser(createUserCommand);
    }

    @Override
    public CreateOrganizationResponse createOrganization(CreateOrganizationCommand createOrganizationCommand) {
        return organizationCreateCommandHandler.createOrganization(createOrganizationCommand);
    }

    @Override
    public CreateRoleResponse createRole(CreateRoleCommand createRoleCommand) {
        return roleCreateCommandHandler.createRole(createRoleCommand);
    }

    @Override
    public QueryUserResponse findUserById(QueryUserCommand queryUserCommand) {
        return userQueryCommandHandler.queryUser(queryUserCommand);
    }
}
