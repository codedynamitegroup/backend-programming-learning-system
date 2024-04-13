package com.backend.programming.learning.system.auth.service.application.rest;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.delete.DeleteUserRoleResponse;
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

    @GetMapping("/getByRoleIdAndUserId")
    public ResponseEntity<QueryUserRoleResponse> getUserRoleByRoleIdAndUserId(
            @RequestParam(required = true, name = "roleId") UUID roleId,
            @RequestParam(required = true, name = "userId") UUID userId)
    {
        QueryUserRoleResponse queryUserRoleResponse =
                userRoleApplicationService.findUserRoleByRoleIdAndUserId(QueryUserRoleCommand.builder()
                        .roleId(roleId)
                        .userId(userId)
                        .build());
       log.info("Returning user role with role id: {} and user id: {}",
               roleId, userId);
       return ResponseEntity.ok(queryUserRoleResponse);
    }

    @DeleteMapping("/deleteByRoleIdAndUserId")
    public ResponseEntity<DeleteUserRoleResponse> deleteUserRoleByRoleIdAndUserId(
            @RequestParam(required = true, name = "roleId") UUID roleId,
            @RequestParam(required = true, name = "userId") UUID userId
    ) {
        log.info("Deleting user role with role id: {} and user id: {}",
                roleId, userId);
        DeleteUserRoleResponse deleteUserRoleResponse = userRoleApplicationService.deleteUserRoleByRoleIdAndUserId(
                DeleteUserRoleCommand.builder()
                        .roleId(roleId)
                        .userId(userId)
                        .build()
        );
        log.info("User role deleted with role id: {} and user id: {}",
                roleId, userId);
        return ResponseEntity.ok(deleteUserRoleResponse);
    }
}
