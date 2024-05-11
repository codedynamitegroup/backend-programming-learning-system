package com.backend.programming.learning.system.auth.service.application.rest;

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
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.RoleApplicationService;
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
@RequestMapping(value = "/auth/roles", produces = "application/vnd.api.v1+json")
public class RoleController {

    private final RoleApplicationService roleApplicationService;

    public RoleController(RoleApplicationService roleApplicationService) {
        this.roleApplicationService = roleApplicationService;
    }

    @PostMapping
    @Operation(summary = "Create role.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateRoleResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateRoleResponse> createRole(@RequestBody CreateRoleCommand createRoleCommand) {
        log.info("Creating role with name: {}", createRoleCommand.getName());
        CreateRoleResponse createRoleResponse = roleApplicationService.createRole(createRoleCommand);
        log.info("Role created with email: {}", createRoleResponse.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(createRoleResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get role by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = RoleEntityResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<RoleEntityResponse> getRoleById(@PathVariable UUID id) {
        RoleEntityResponse queryRoleResponse =
               roleApplicationService.findRoleById(QueryRoleByIdCommand.builder().roleId(id).build());
       log.info("Returning role with id: {}", queryRoleResponse.getRoleId());
       return  ResponseEntity.ok(queryRoleResponse);
    }

    @GetMapping
    @Operation(summary = "Get all roles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = RoleEntityResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllRolesResponse> getAllRoles(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        QueryAllRolesResponse queryAllRolesResponse =
                roleApplicationService.findAllRoles(QueryAllRolesCommand.builder()
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .build()
                );
        log.info("Returning all roles");
        return ResponseEntity.ok(queryAllRolesResponse);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update role by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateRoleResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateRoleResponse> updateRoleById(@PathVariable UUID id, @RequestBody UpdateRoleCommand updateRoleCommand) {
        log.info("Updating role with id: {}", id);
        UpdateRoleResponse updateRoleResponse = roleApplicationService.updateRole(UpdateRoleCommand.builder()
                .roleId(id)
                .name(updateRoleCommand.getName())
                .description(updateRoleCommand.getDescription())
                .updatedBy(updateRoleCommand.getUpdatedBy())
                .build());
        log.info("Role updated with id: {}", id);
        return ResponseEntity.ok(updateRoleResponse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete role by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteRoleResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteRoleResponse> deleteRoleById(@PathVariable UUID id) {
        log.info("Deleting role with id: {}", id);
        DeleteRoleResponse deleteRoleResponse =
                roleApplicationService.deleteRoleById(DeleteRoleCommand.builder().roleId(id).build());
        log.info("Role deleted with id: {}", id);
        return ResponseEntity.ok(deleteRoleResponse);
    }
}
