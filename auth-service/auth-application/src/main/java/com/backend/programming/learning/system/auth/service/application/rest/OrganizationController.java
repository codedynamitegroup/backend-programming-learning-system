package com.backend.programming.learning.system.auth.service.application.rest;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryOrganizationByIdCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.OrganizationApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/auth/organizations", produces = "application/vnd.api.v1+json")
public class OrganizationController {

    private final OrganizationApplicationService organizationApplicationService;

    public OrganizationController(OrganizationApplicationService organizationApplicationService) {
        this.organizationApplicationService = organizationApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateOrganizationResponse> createOrganization(@RequestBody CreateOrganizationCommand createOrganizationCommand) {
        log.info("Creating organization with email: {}", createOrganizationCommand.getEmail());
        CreateOrganizationResponse createOrganizationResponse = organizationApplicationService.createOrganization(createOrganizationCommand);
        log.info("Organization created with email: {}", createOrganizationResponse.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(createOrganizationResponse);
    }

    @GetMapping
    public ResponseEntity<QueryAllOrganizationsResponse> getAllOrganizations(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        QueryAllOrganizationsResponse allOrganizations = organizationApplicationService.findAllOrganizations(
                QueryAllOrganizationsCommand.builder()
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .build()
        );
        log.info("Returning all organizations");
        return ResponseEntity.ok(allOrganizations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationEntityResponse> getOrganizationById(@PathVariable UUID id) {
        OrganizationEntityResponse queryOrganizationResponse =
                organizationApplicationService.findOrganizationById(QueryOrganizationByIdCommand.builder().organizationId(id).build());
       log.info("Returning organization with id: {}", queryOrganizationResponse.getOrganizationId());
       return  ResponseEntity.ok(queryOrganizationResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrganizationResponse> deleteOrganizationById(@PathVariable UUID id) {
        log.info("Deleting organization with id: {}", id);
        DeleteOrganizationResponse deleteOrganizationResponse =
                organizationApplicationService.deleteOrganizationById(DeleteOrganizationCommand.builder().organizationId(id).build());
        log.info("Organization deleted with id: {}", id);
        return ResponseEntity.ok(deleteOrganizationResponse);
    }
}
