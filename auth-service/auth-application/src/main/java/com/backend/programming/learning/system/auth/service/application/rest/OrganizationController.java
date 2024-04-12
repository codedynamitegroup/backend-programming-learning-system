package com.backend.programming.learning.system.auth.service.application.rest;

import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.create.CreateUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.query.QueryUserResponse;
import com.backend.programming.learning.system.auth.service.domain.ports.input.service.OrganizationApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(createOrganizationResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryOrganizationResponse> getOrganizationById(@PathVariable UUID id) {
        QueryOrganizationResponse queryOrganizationResponse =
                organizationApplicationService.findOrganizationById(QueryOrganizationCommand.builder().organizationId(id).build());
       log.info("Returning organization with email: {}", queryOrganizationResponse.getEmail());
       return  ResponseEntity.ok(queryOrganizationResponse);
    }
}
