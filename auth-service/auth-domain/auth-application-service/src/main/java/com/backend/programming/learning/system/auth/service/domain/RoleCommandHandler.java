package com.backend.programming.learning.system.auth.service.domain;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryRoleByOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.mapper.RoleDataMapper;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.RoleRepository;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RoleCommandHandler {

    private final RoleCreateHelper roleCreateHelper;
    private final RoleDeleteHelper roleDeleteHelper;
    private final RoleDataMapper roleDataMapper;
    private final RoleRepository roleRepository;

    public RoleCommandHandler(RoleCreateHelper roleCreateHelper, RoleDeleteHelper roleDeleteHelper, RoleDataMapper roleDataMapper, RoleRepository roleRepository) {
        this.roleCreateHelper = roleCreateHelper;
        this.roleDeleteHelper = roleDeleteHelper;
        this.roleDataMapper = roleDataMapper;
        this.roleRepository = roleRepository;
    }

    public CreateRoleResponse createRole(CreateRoleCommand createRoleCommand) {
        Role roleCreated = roleCreateHelper.persistRole(createRoleCommand);
        log.info("Role is created with id: {}", roleCreated.getId().getValue());
        return roleDataMapper.roleToCreateRoleResponse(roleCreated, "Role created successfully");
    }

    @Transactional(readOnly = true)
    public QueryRoleResponse queryRole(QueryRoleCommand queryRoleCommand) {
        Optional<Role> roleResult =
                roleRepository.findById(new RoleId(queryRoleCommand.getRoleId()));
        if (roleResult.isEmpty()) {
            log.warn("Could not find role with id: {}", queryRoleCommand.getRoleId());
            throw new AuthNotFoundException("Could not find user with user id: " +
                    queryRoleCommand.getRoleId());
        }
        return roleDataMapper.roleToQueryRoleResponse(roleResult.get());
    }

    @Transactional(readOnly = true)
    public List<QueryRoleResponse> queryRolesByOrganizationId(QueryRoleByOrganizationCommand queryAllRolesCommand) {
        return roleRepository.findByOrganizationId(new OrganizationId(queryAllRolesCommand.getOrganizationId())).stream()
                .map(roleDataMapper::roleToQueryRoleResponse)
                .toList();
    }

    public DeleteRoleResponse deleteRole(DeleteRoleCommand deleteRoleCommand) {
        roleDeleteHelper.deleteRole(deleteRoleCommand);
        log.info("Role is deleted with id: {}", deleteRoleCommand.getRoleId());
        return DeleteRoleResponse.builder()
                .message("Role deleted successfully")
                .build();
    }
}
