package com.backend.programming.learning.system.auth.service.application.rest;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.user_role.CreateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.user_role.DeleteUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user_role.QueryUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user.UpdateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user_role.UpdateUserRoleCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.user_role.UpdateUserRoleResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user_role.UserRoleEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.UserRoleApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    @Operation(summary = "Create user role.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateUserRoleResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateUserRoleResponse> createUserRole(@RequestBody CreateUserRoleCommand createUserRoleCommand) {
        log.info("Creating user role with role id: {} and user id: {}",
                createUserRoleCommand.getRoleId(), createUserRoleCommand.getUserId());
        CreateUserRoleResponse createUserRoleResponse = userRoleApplicationService.createUserRole(createUserRoleCommand);
        log.info("User role created with role id: {} and user id: {}",
                createUserRoleCommand.getRoleId(), createUserRoleCommand.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserRoleResponse);
    }

    @GetMapping("/getByRoleIdAndUserId")
    @Operation(summary = "Get user role by role id and user id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UserRoleEntityResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UserRoleEntityResponse> getUserRoleByRoleIdAndUserId(
            @RequestParam(required = true, name = "roleId") UUID roleId,
            @RequestParam(required = true, name = "userId") UUID userId)
    {
        UserRoleEntityResponse userRole =
                userRoleApplicationService.findUserRoleByRoleIdAndUserId(QueryUserRoleCommand.builder()
                        .roleId(roleId)
                        .userId(userId)
                        .build());
       log.info("Returning user role with role id: {} and user id: {}",
               roleId, userId);
       return ResponseEntity.ok(userRole);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user role by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateUserRoleResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateUserRoleResponse> updateUserRoleById(@PathVariable UUID id,
                                                                     @RequestBody UpdateUserRoleCommand updateUserRoleCommand) {
        log.info("Updating user role with id: {}", id);
        UpdateUserRoleResponse updateUserRoleResponse = userRoleApplicationService.updateUserRole(UpdateUserRoleCommand.builder()
                .userRoleId(id)
                .name(updateUserRoleCommand.getName())
                .isActive(updateUserRoleCommand.getIsActive())
                .updatedBy(updateUserRoleCommand.getUpdatedBy())
                .build());
        log.info("User role updated with id: {}", id);
        return ResponseEntity.ok(updateUserRoleResponse);
    }


    @DeleteMapping("/deleteByRoleIdAndUserId")
    @Operation(summary = "Delete user role by role id and user id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteUserRoleResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
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
