package com.backend.programming.learning.system.auth.service.application.rest;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.RoleApplicationService;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<QueryRoleResponse> getRoleById(@PathVariable UUID id) {
        QueryRoleResponse queryRoleResponse =
               roleApplicationService.findRoleById(QueryRoleCommand.builder().roleId(id).build());
       log.info("Returning user with name: {}", queryRoleResponse.getName());
       return  ResponseEntity.ok(queryRoleResponse);
    }
}
