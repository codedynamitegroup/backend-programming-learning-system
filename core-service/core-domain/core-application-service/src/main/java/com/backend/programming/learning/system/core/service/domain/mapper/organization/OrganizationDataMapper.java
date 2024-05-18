package com.backend.programming.learning.system.core.service.domain.mapper.organization;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.organization.OrganizationRequest;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.OrganizationResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.event.organization.OrganizationEvent;
import com.backend.programming.learning.system.core.service.domain.outbox.model.organization.OrganizationEventPayload;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class OrganizationDataMapper {
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

    public OrganizationResponseEntity organizationToOrganizationResponseEntity(Organization organization) {
        ZonedDateTime createdAt = organization.getCreatedAt() != null ? organization.getCreatedAt().toInstant().atZone(ZoneId.of(DomainConstants.UTC)) : null;
        ZonedDateTime updatedAt = organization.getUpdatedAt() != null ? organization.getUpdatedAt().toInstant().atZone(ZoneId.of(DomainConstants.UTC)) : null;
        return OrganizationResponseEntity.builder()
                .id(organization.getId().getValue().toString())
                .name(organization.getName())
                .description(organization.getDescription())
                .moodleUrl(organization.getMoodleUrl())
                .apiKey(organization.getApiKey())
                .isDeleted(organization.getDeleted())
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
