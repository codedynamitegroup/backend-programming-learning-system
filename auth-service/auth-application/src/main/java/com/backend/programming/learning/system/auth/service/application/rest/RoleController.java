package com.backend.programming.learning.system.auth.service.application.rest;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.*;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.RoleApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
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
        return ResponseEntity.ok(createRoleResponse);
    }

    @GetMapping("/organization/{id}")
    public ResponseEntity<List<QueryRoleResponse>> getRolesByOrganizationId(@PathVariable UUID id) {
        log.info("Getting roles by organization id: {}", id);
        List<QueryRoleResponse> roles = roleApplicationService
                .findByOrganizationId(QueryRoleByOrganizationCommand.builder().organizationId(id).build());
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryRoleResponse> getRoleById(@PathVariable UUID id) {
        QueryRoleResponse queryRoleResponse =
               roleApplicationService.findRoleById(QueryRoleCommand.builder().roleId(id).build());
       log.info("Returning user with name: {}", queryRoleResponse.getName());
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
