package com.backend.programming.learning.system.auth.service.domain.implement.service.role;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.role.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.role.CreateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryAllRolesCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryAllRolesResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryRoleByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.role.UpdateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.role.UpdateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.role.RoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.mapper.RoleDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class RoleCommandHandler {

    private final RoleCreateHelper roleCreateHelper;
    private final RoleDeleteHelper roleDeleteHelper;
    private final RoleDataMapper roleDataMapper;
    private final RoleQueryHelper roleQueryHelper;
    private final RoleUpdateHelper roleUpdateHelper;

    @Transactional
    public CreateRoleResponse createRole(CreateRoleCommand createRoleCommand) {
        Role roleCreated = roleCreateHelper.persistRole(createRoleCommand);
        log.info("Role is created with id: {}", roleCreated.getId().getValue());
        return roleDataMapper.roleToCreateRoleResponse(roleCreated, "Role created successfully");
    }

    @Transactional(readOnly = true)
    public RoleEntityResponse queryRole(QueryRoleByIdCommand queryRoleCommand) {
        Role role = roleQueryHelper.queryRole(queryRoleCommand.getRoleId());
        log.info("Role is queried with id: {}", queryRoleCommand.getRoleId());
        return roleDataMapper.roleToRoleResponse(role);
    }

    @Transactional(readOnly = true)
    public QueryAllRolesResponse queryAllRoles(QueryAllRolesCommand queryAllRolesCommand) {
        Page<Role> roles = roleQueryHelper.queryAllRoles(queryAllRolesCommand.getPageNo(), queryAllRolesCommand.getPageSize());
        log.info("All roles are queried");
        return roleDataMapper.rolesToQueryAllRolesResponse(roles);
    }

    @Transactional
    public UpdateRoleResponse updateRole(UpdateRoleCommand updateRoleCommand) {
        Role roleUpdated = roleUpdateHelper.persistRole(updateRoleCommand);
        log.info("Role is updated with id: {}", roleUpdated.getId().getValue());
        return roleDataMapper.roleToUpdateRoleResponse(roleUpdated, "Role updated successfully");
    }

    @Transactional
    public DeleteRoleResponse deleteRole(DeleteRoleCommand deleteRoleCommand) {
        roleDeleteHelper.deleteRole(deleteRoleCommand);
        log.info("Role is deleted with id: {}", deleteRoleCommand.getRoleId());
        return roleDataMapper.roleToDeleteRoleResponse(deleteRoleCommand.getRoleId(), "Role deleted successfully");
    }
}
