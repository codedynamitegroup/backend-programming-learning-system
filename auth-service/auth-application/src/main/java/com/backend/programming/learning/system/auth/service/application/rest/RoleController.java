package com.backend.programming.learning.system.auth.service.application.rest;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/auth/roles", produces = "application/vnd.api.v1+json")
public class RoleController {

    private final RoleApplicationService roleApplicationService;

    public RoleController(RoleApplicationService roleApplicationService) {
        this.roleApplicationService = roleApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateRoleResponse> createRole(@RequestBody CreateRoleCommand createRoleCommand) {
        log.info("Creating role with name: {}", createRoleCommand.getName());
        CreateRoleResponse createRoleResponse = roleApplicationService.createRole(createRoleCommand);
        log.info("Role created with email: {}", createRoleResponse.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(createRoleResponse);
    }

    @GetMapping("/organization/{id}")
    public ResponseEntity<QueryAllRolesByOrganizationResponse> getRolesByOrganizationId(
            @PathVariable UUID id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("Getting roles by organization id: {}", id);
        QueryAllRolesByOrganizationResponse roles = roleApplicationService
                .findByOrganizationId(QueryAllRolesByOrganizationCommand.builder()
                        .organizationId(id)
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .build());
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleEntityResponse> getRoleById(@PathVariable UUID id) {
        RoleEntityResponse queryRoleResponse =
               roleApplicationService.findRoleById(QueryRoleByIdCommand.builder().roleId(id).build());
       log.info("Returning role with id: {}", queryRoleResponse.getRoleId());
       return  ResponseEntity.ok(queryRoleResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRoleResponse> deleteRoleById(@PathVariable UUID id) {
        log.info("Deleting role with id: {}", id);
        DeleteRoleResponse deleteRoleResponse =
                roleApplicationService.deleteRoleById(DeleteRoleCommand.builder().roleId(id).build());
        log.info("Role deleted with id: {}", id);
        return ResponseEntity.ok(deleteRoleResponse);
    }
}
