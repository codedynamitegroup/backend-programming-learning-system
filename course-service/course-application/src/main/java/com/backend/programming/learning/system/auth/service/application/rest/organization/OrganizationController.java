package com.backend.programming.learning.system.auth.service.application.rest.organization;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.organization.DeleteOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.organization.DeleteOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.organization.QueryAllOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.organization.QueryOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.organization.UpdateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization.OrganizationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.organization.OrganizationApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/organization/organization", produces = "application/vnd.api.v1+json")
public class OrganizationController {
    private final OrganizationApplicationService organizationApplicationService;

    @PostMapping
    public ResponseEntity<CreateOrganizationResponse> createOrganization(
            @RequestBody CreateOrganizationCommand createOrganizationCommand
    ) {
        log.info("Creating organization");
        CreateOrganizationResponse response = organizationApplicationService.createOrganization(createOrganizationCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{organizationId}")
    public ResponseEntity<OrganizationResponseEntity> queryOrganizationById(
            @PathVariable UUID organizationId
    ) {
        log.info("Querying organization by id");
        OrganizationResponseEntity response = organizationApplicationService.queryOrganizationById(new QueryOrganizationCommand(organizationId));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<QueryAllOrganizationResponse> queryAllOrganization() {
        log.info("Querying all organizations");
        return ResponseEntity.ok(organizationApplicationService.queryAllOrganization());
    }

    @DeleteMapping("/{organizationId}")
    public ResponseEntity<DeleteOrganizationResponse> deleteOrganization(
            @PathVariable UUID organizationId
    ) {
        log.info("Deleting organization");
        DeleteOrganizationResponse response = organizationApplicationService.deleteOrganization(new DeleteOrganizationCommand(organizationId));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{organizationId}")
    public ResponseEntity<UpdateOrganizationResponse> updateOrganization(
            @PathVariable UUID organizationId,
            @RequestBody UpdateOrganizationCommand updateOrganizationCommand
    ) {
        log.info("Updating organization");
        UpdateOrganizationResponse response = organizationApplicationService.
                updateOrganization(updateOrganizationCommand
                        .builder()
                        .organizationId(organizationId)
                        .name(updateOrganizationCommand.getName())
                        .description(updateOrganizationCommand.getDescription())
                        .apiKey(updateOrganizationCommand.getApiKey())
                        .moodleUrl(updateOrganizationCommand.getMoodleUrl())
                        .build());
        return  ResponseEntity.ok(response);
    }
}
