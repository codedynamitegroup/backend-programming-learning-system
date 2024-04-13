package com.backend.programming.learning.system.auth.service.domain.ports.input.service;

import com.backend.programming.learning.system.auth.service.domain.dto.create.*;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryRoleByOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryRoleResponse;

import javax.validation.Valid;
import java.util.List;

public interface RoleApplicationService {
    CreateRoleResponse createRole(@Valid CreateRoleCommand createRoleCommand);
    QueryRoleResponse findRoleById(@Valid QueryRoleCommand queryRoleCommand);
    List<QueryRoleResponse> findByOrganizationId(@Valid QueryRoleByOrganizationCommand queryAllRolesCommand);
    DeleteRoleResponse deleteRoleById(@Valid DeleteRoleCommand deleteRoleCommand);
}
