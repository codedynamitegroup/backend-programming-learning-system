package com.backend.programming.learning.system.course.service.domain.mapper.organization;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationRequest;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization.OrganizationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.event.organization.OrganizationEvent;
import com.backend.programming.learning.system.course.service.domain.outbox.model.organization.OrganizationEventPayload;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component

public class OrganizationDataMapper {
    public Organization createOrganizationCommandToOrganization(CreateOrganizationCommand createOrganizationCommand) {
        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.of("Asia/Ho_Chi_Minh");
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        return Organization.builder()
                .name(createOrganizationCommand.getName())
                .description(createOrganizationCommand.getDescription())
                .apiKey(createOrganizationCommand.getApiKey())
                .moodleUrl(createOrganizationCommand.getMoodleUrl())
                .createdAt(zonedDateTime)
                .updatedAt(zonedDateTime)
                .build();
    }

    public CreateOrganizationResponse organizationToCreateOrganizationResponse(Organization organization, String message) {
        return CreateOrganizationResponse.builder()
                .organizationId(organization.getId().getValue())
                .name(organization.getName())
                .message(message)
                .build();
    }

    public OrganizationResponseEntity organizationToOrganizationResponseEntity(Organization organization) {
        return OrganizationResponseEntity.builder()
                .organizationId(organization.getId().getValue())
                .name(organization.getName())
                .description(organization.getDescription())
                .apiKey(organization.getApiKey())
                .moodleUrl(organization.getMoodleUrl())
                .build();
    }

    public Organization organizationCreatedRequestToOrganization(OrganizationRequest organizationRequest) {
        return Organization.builder()
                .id(new OrganizationId(UUID.fromString(organizationRequest.getOrganizationId())))
                .name(organizationRequest.getName())
                .description(organizationRequest.getDescription())
                .createdAt(organizationRequest.getCreatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .updatedAt(organizationRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .isDeleted(organizationRequest.getIsDeleted())
                .build();
    }

    public Organization organizationUpdatedRequestToOrganization(OrganizationRequest organizationRequest) {
        return Organization.builder()
                .id(new OrganizationId(UUID.fromString(organizationRequest.getOrganizationId())))
                .name(organizationRequest.getName())
                .description(organizationRequest.getDescription())
                .moodleUrl(organizationRequest.getMoodleUrl())
                .apiKey(organizationRequest.getApiKey())
                .updatedAt(organizationRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.UTC)))
                .isDeleted(organizationRequest.getIsDeleted())
                .build();
    }

    public Organization organizationDeletedRequestToOrganization(OrganizationRequest organizationRequest) {
        return Organization.builder()
                .id(new OrganizationId(UUID.fromString(organizationRequest.getOrganizationId())))
                .isDeleted(organizationRequest.getIsDeleted())
                .build();
    }

    public OrganizationEventPayload organizationEventToOrganizationEventPayload(OrganizationEvent organizationEvent, CopyState copyState) {
        return OrganizationEventPayload.builder()
                .organizationId(organizationEvent.getOrganization().getId().getValue().toString())
                .copyState(copyState.name())
                .failureMessages(organizationEvent.getFailureMessages())
                .build();
    }
}
