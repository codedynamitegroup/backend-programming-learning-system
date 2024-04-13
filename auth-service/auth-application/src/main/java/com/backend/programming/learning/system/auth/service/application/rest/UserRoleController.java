package com.backend.programming.learning.system.auth.service.application.rest;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserRoleApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/auth/user-roles", produces = "application/vnd.api.v1+json")
public class UserRoleController {
    private final UserRoleApplicationService userRoleApplicationService;

    public UserRoleController(UserRoleApplicationService userRoleApplicationService) {
        this.userRoleApplicationService = userRoleApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateUserRoleResponse> createUserRole(@RequestBody CreateUserRoleCommand createUserRoleCommand) {
        log.info("Creating user role with role id: {} and user id: {}",
                createUserRoleCommand.getRoleId(), createUserRoleCommand.getUserId());
        CreateUserRoleResponse createUserRoleResponse = userRoleApplicationService.createUserRole(createUserRoleCommand);
        log.info("User role created with role id: {} and user id: {}",
                createUserRoleCommand.getRoleId(), createUserRoleCommand.getUserId());
        return ResponseEntity.ok(createUserRoleResponse);
    }

    @PostMapping("/query")
    public ResponseEntity<QueryUserRoleResponse> getUserRoleByRoleIdAndUserId(@RequestBody QueryUserRoleCommand queryUserRoleCommand) {
        QueryUserRoleResponse queryUserRoleResponse =
                userRoleApplicationService.findUserRoleByRoleIdAndUserId(queryUserRoleCommand);
       log.info("Returning user role with role id: {} and user id: {}",
               queryUserRoleCommand.getRoleId(), queryUserRoleCommand.getUserId());
       return ResponseEntity.ok(queryUserRoleResponse);
    }
}
