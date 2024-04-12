package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.mapper.RoleDataMapper;
import com.backend.programming.learning.system.auth.service.domain.mapper.UserDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RoleCreateCommandHandler {

    private final RoleCreateHelper roleCreateHelper;

    private final RoleDataMapper roleDataMapper;

    public RoleCreateCommandHandler(RoleCreateHelper roleCreateHelper, RoleDataMapper roleDataMapper) {
        this.roleCreateHelper = roleCreateHelper;
        this.roleDataMapper = roleDataMapper;
    }

    public CreateRoleResponse createRole(CreateRoleCommand createRoleCommand) {
        Role roleCreated = roleCreateHelper.persistRole(createRoleCommand);
        log.info("Role is created with id: {}", roleCreated.getId().getValue());
        return roleDataMapper.roleToCreateRoleResponse(roleCreated, "Role created successfully");
    }

}
