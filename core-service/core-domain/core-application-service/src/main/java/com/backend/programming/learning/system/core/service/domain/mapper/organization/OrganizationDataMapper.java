package com.backend.programming.learning.system.core.service.domain.mapper.organization;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.organization.OrganizationRequest;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.event.organization.OrganizationEvent;
import com.backend.programming.learning.system.core.service.domain.event.user.UserEvent;
import com.backend.programming.learning.system.core.service.domain.outbox.model.organization.OrganizationEventPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.UUID;

@Component
public class OrganizationDataMapper {
    public Organization organizationCreatedRequestToOrganization(OrganizationRequest organizationRequest) {
        return Organization.builder()
                .id(new OrganizationId(UUID.fromString(organizationRequest.getOrganizationId())))
                .name(organizationRequest.getName())
                .description(organizationRequest.getDescription())
                .createdAt(organizationRequest.getCreatedAt().atZone(ZoneId.of(DomainConstants.ASIA_HCM)))
                .updatedAt(organizationRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.ASIA_HCM)))
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
                .updatedAt(organizationRequest.getUpdatedAt().atZone(ZoneId.of(DomainConstants.ASIA_HCM)))
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
