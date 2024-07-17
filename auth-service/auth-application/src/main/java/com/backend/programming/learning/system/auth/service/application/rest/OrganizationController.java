package com.backend.programming.learning.system.auth.service.application.rest;

import com.backend.programming.learning.system.auth.service.application.utils.JwtUtils;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryOrganizationByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization.UpdateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.OrganizationApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/auth/organizations", produces = "application/vnd.api.v1+json")
public class OrganizationController {
    private final OrganizationApplicationService organizationApplicationService;
    private final JwtUtils jwtUtils;

    public OrganizationController(OrganizationApplicationService organizationApplicationService, JwtUtils jwtUtils) {
        this.organizationApplicationService = organizationApplicationService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping
    @Operation(summary = "Create organization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateOrganizationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<?> createOrganization(
            @RequestBody CreateOrganizationCommand createOrganizationCommand,
            @RequestHeader(value = "Access-Token", required = false) String accessToken) {
        String email = jwtUtils.getEmailFromJwtString(accessToken);
        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid access token"));
        }
        log.info("Creating organization with email: {}", createOrganizationCommand.getEmail());
        CreateOrganizationResponse createOrganizationResponse = organizationApplicationService.createOrganization(
                CreateOrganizationCommand.builder()
                        .email(createOrganizationCommand.getEmail())
                        .description(createOrganizationCommand.getDescription())
                        .name(createOrganizationCommand.getName())
                        .phone(createOrganizationCommand.getPhone())
                        .address(createOrganizationCommand.getAddress())
                        .createdBy(email)
                        .build()
        );
        log.info("Organization created with email: {}", createOrganizationResponse.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(createOrganizationResponse);
    }

    @PostMapping("/contact-us")
    @Operation(summary = "Create organization by contact us.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateOrganizationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<?> createOrganizationByContactUs(
            @RequestBody CreateOrganizationCommand createOrganizationCommand) {
        log.info("Creating organization by contact us with email: {}", createOrganizationCommand.getEmail());
        CreateOrganizationResponse createOrganizationResponse = organizationApplicationService.createOrganization(
                CreateOrganizationCommand.builder()
                        .email(createOrganizationCommand.getEmail())
                        .description(createOrganizationCommand.getDescription())
                        .name(createOrganizationCommand.getName())
                        .phone(createOrganizationCommand.getPhone())
                        .address(createOrganizationCommand.getAddress())
                        .build()
        );
        log.info("Organization created with email: {}", createOrganizationResponse.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(createOrganizationResponse);
    }

    @GetMapping
    @Operation(summary = "Get all organizations.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllOrganizationsResponse.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllOrganizationsResponse> getAllOrganizations(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String searchName
    ) {
        QueryAllOrganizationsResponse allOrganizations = organizationApplicationService.findAllOrganizations(
                QueryAllOrganizationsCommand.builder()
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .searchName(searchName)
                        .build()
        );
        log.info("Returning all organizations");
        return ResponseEntity.ok(allOrganizations);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get organization by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = OrganizationEntityResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<OrganizationEntityResponse> getOrganizationById(@PathVariable UUID id) {
        OrganizationEntityResponse queryOrganizationResponse =
                organizationApplicationService.findOrganizationById(QueryOrganizationByIdCommand.builder().organizationId(id).build());
       log.info("Returning organization with id: {}", queryOrganizationResponse.getOrganizationId());
       return  ResponseEntity.ok(queryOrganizationResponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update organization by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateOrganizationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<?> updateOrganizationById(
            @PathVariable UUID id,
            @RequestBody UpdateOrganizationCommand updateOrganizationCommand,
            @RequestHeader(value = "Access-Token", required = false) String accessToken
    ) {
        String email = jwtUtils.getEmailFromJwtString(accessToken);
        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid access token"));
        }
        log.info("Updating organization with id: {}", id);
        UpdateOrganizationResponse updateOrganizationResponse = organizationApplicationService.updateOrganization(
                UpdateOrganizationCommand.builder()
                        .organizationId(id)
                        .email(updateOrganizationCommand.getEmail())
                        .name(updateOrganizationCommand.getName())
                        .description(updateOrganizationCommand.getDescription())
                        .phone(updateOrganizationCommand.getPhone())
                        .address(updateOrganizationCommand.getAddress())
                        .apiKey(updateOrganizationCommand.getApiKey())
                        .moodleUrl(updateOrganizationCommand.getMoodleUrl())
                        .updatedBy(email)
                        .isDeleted(updateOrganizationCommand.getIsDeleted())
                        .build()
        );
        log.info("Organization updated with id: {}", id);
        return ResponseEntity.ok(updateOrganizationResponse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete organization by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteOrganizationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteOrganizationResponse> deleteOrganizationById(@PathVariable UUID id) {
        log.info("Deleting organization with id: {}", id);
        DeleteOrganizationResponse deleteOrganizationResponse =
                organizationApplicationService.deleteOrganizationById(DeleteOrganizationCommand.builder().organizationId(id).build());
        log.info("Organization deleted with id: {}", id);
        return ResponseEntity.ok(deleteOrganizationResponse);
    }
}
