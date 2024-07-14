package com.backend.programming.learning.system.auth.service.application.rest.organization;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.organization.DeleteOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.organization.DeleteOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.organization.QueryAllOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.organization.QueryOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.SyncOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.UpdateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization.OrganizationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.organization.OrganizationApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/organization", produces = "application/vnd.api.v1+json")
public class OrganizationController {
    private final OrganizationApplicationService organizationApplicationService;

    @PostMapping
    @Operation(summary = "Create organization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateOrganizationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateOrganizationResponse> createOrganization(
            @RequestBody CreateOrganizationCommand createOrganizationCommand
    ) {
        log.info("Creating organization");
        CreateOrganizationResponse response = organizationApplicationService.createOrganization(createOrganizationCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{organizationId}")
    @Operation(summary = "Query organization by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = OrganizationResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<OrganizationResponseEntity> queryOrganizationById(
            @PathVariable UUID organizationId
    ) {
        log.info("Querying organization by id");
        OrganizationResponseEntity response = organizationApplicationService.queryOrganizationById(new QueryOrganizationCommand(organizationId));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Query all organizations.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllOrganizationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllOrganizationResponse> queryAllOrganization() {
        log.info("Querying all organizations");
        return ResponseEntity.ok(organizationApplicationService.queryAllOrganization());
    }

    @DeleteMapping("/{organizationId}")
    @Operation(summary = "Delete organization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteOrganizationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteOrganizationResponse> deleteOrganization(
            @PathVariable UUID organizationId
    ) {
        log.info("Deleting organization");
        DeleteOrganizationResponse response = organizationApplicationService.deleteOrganization(new DeleteOrganizationCommand(organizationId));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{organizationId}")
    @Operation(summary = "Update organization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateOrganizationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateOrganizationResponse> updateOrganization(
            @PathVariable UUID organizationId,
            @RequestBody UpdateOrganizationCommand updateOrganizationCommand
    ) {
        log.info("Updating organization");
        UpdateOrganizationResponse response = organizationApplicationService.
                updateOrganization(organizationId, updateOrganizationCommand);
        return  ResponseEntity.ok(response);
    }

}
