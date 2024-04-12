package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.*;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.RoleApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class RoleApplicationServiceImpl implements RoleApplicationService {
    private final RoleCommandHandler roleCommandHandler;

    RoleApplicationServiceImpl(RoleCommandHandler roleCommandHandler) {
        this.roleCommandHandler = roleCommandHandler;
    }

    @Override
    public CreateRoleResponse createRole(CreateRoleCommand createRoleCommand) {
        return roleCommandHandler.createRole(createRoleCommand);
    }

    @Override
    public QueryRoleResponse findRoleById(QueryRoleCommand queryRoleCommand) {
        return roleCommandHandler.queryRole(queryRoleCommand);
    }
}
