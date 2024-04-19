package com.backend.programming.learning.system.auth.service.domain.implement.role;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryAllRolesByOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryRoleByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryAllRolesByOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.role.RoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.RoleApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Slf4j
@Validated
@Service
class RoleApplicationServiceImpl implements RoleApplicationService {
    private final RoleCommandHandler roleCommandHandler;

    public RoleApplicationServiceImpl(RoleCommandHandler roleCommandHandler) {
        this.roleCommandHandler = roleCommandHandler;
    }


    @Override
    public CreateRoleResponse createRole(CreateRoleCommand createRoleCommand) {
        return roleCommandHandler.createRole(createRoleCommand);
    }

    @Override
    public RoleEntityResponse findRoleById(QueryRoleByIdCommand queryRoleCommand) {
        return roleCommandHandler.queryRole(queryRoleCommand);
    }

    @Override
    public QueryAllRolesByOrganizationResponse findByOrganizationId(QueryAllRolesByOrganizationCommand queryAllRolesCommand) {
        return roleCommandHandler.queryRolesByOrganizationId(queryAllRolesCommand);
    }

    @Override
    public DeleteRoleResponse deleteRoleById(DeleteRoleCommand deleteRoleCommand) {
        return roleCommandHandler.deleteRole(deleteRoleCommand);
    }
}
