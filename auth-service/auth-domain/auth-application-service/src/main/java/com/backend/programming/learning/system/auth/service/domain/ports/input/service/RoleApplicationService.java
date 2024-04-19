package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryAllRolesByOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryRoleByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryAllRolesByOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.role.RoleEntityResponse;

import javax.validation.Valid;
import java.util.List;

public interface RoleApplicationService {
    CreateRoleResponse createRole(@Valid CreateRoleCommand createRoleCommand);
    RoleEntityResponse findRoleById(@Valid QueryRoleByIdCommand queryRoleCommand);
    QueryAllRolesByOrganizationResponse findByOrganizationId(@Valid QueryAllRolesByOrganizationCommand queryAllRolesCommand);
    DeleteRoleResponse deleteRoleById(@Valid DeleteRoleCommand deleteRoleCommand);
}
