package com.backend.programming.learning.system.auth.service.domain.implement.role;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.role.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.role.CreateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.role.DeleteRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryAllRolesByOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryRoleByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.role.QueryAllRolesByOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.role.UpdateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.role.UpdateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.role.RoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.mapper.RoleDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class RoleCommandHandler {

    private final RoleCreateHelper roleCreateHelper;
    private final RoleDeleteHelper roleDeleteHelper;
    private final RoleDataMapper roleDataMapper;
    private final RoleQueryHelper roleQueryHelper;
    private final RoleUpdateHelper roleUpdateHelper;

    public RoleCommandHandler(RoleCreateHelper roleCreateHelper, RoleDeleteHelper roleDeleteHelper, RoleDataMapper roleDataMapper, RoleQueryHelper roleQueryHelper, RoleUpdateHelper roleUpdateHelper) {
        this.roleCreateHelper = roleCreateHelper;
        this.roleDeleteHelper = roleDeleteHelper;
        this.roleDataMapper = roleDataMapper;
        this.roleQueryHelper = roleQueryHelper;
        this.roleUpdateHelper = roleUpdateHelper;
    }

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
    public QueryAllRolesByOrganizationResponse queryRolesByOrganizationId(QueryAllRolesByOrganizationCommand queryAllRolesCommand) {
        Page<Role> roles = roleQueryHelper.queryAllRolesByOrganizationId(queryAllRolesCommand.getOrganizationId(),
                queryAllRolesCommand.getPageNo(), queryAllRolesCommand.getPageSize());
        log.info("All roles are queried");
        return roleDataMapper.rolesToQueryAllRolesByOrganizationResponse(roles);
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
