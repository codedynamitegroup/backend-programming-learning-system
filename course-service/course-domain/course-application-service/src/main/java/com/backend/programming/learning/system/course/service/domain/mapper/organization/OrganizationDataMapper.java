package com.backend.programming.learning.system.course.service.domain.mapper.organization;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationCreateRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationDeleteRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.organization.OrganizationUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.organization.OrganizationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component

public class OrganizationDataMapper {
    public Organization organizationCreateRequestToOrganization(OrganizationCreateRequest organizationRequest) {
        Instant instant = Instant.now();
        ZoneId zoneId = ZoneId.of("Asia/Ho_Chi_Minh");
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        return Organization.builder()
                .id(new OrganizationId(UUID.fromString(organizationRequest.getId())))
                .name(organizationRequest.getName())
                .description(organizationRequest.getDescription())
                .apiKey(organizationRequest.getApiKey())
                .moodleUrl(organizationRequest.getMoodle_url())
                .createdAt(zonedDateTime)
                .updatedAt(zonedDateTime)
                .build();

    }

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

    public Organization organizationDeleteRequestToOrganization(OrganizationDeleteRequest organizationRequest) {
        return Organization.builder()
                .id(new OrganizationId(UUID.fromString(organizationRequest.getId())))
                .build();
    }

    public Organization organizationUpdateRequestToOrganization(OrganizationUpdateRequest organizationUpdateRequest) {
        return Organization.builder()
                .id(new OrganizationId(UUID.fromString(organizationUpdateRequest.getId())))
                .name(organizationUpdateRequest.getName())
                .description(organizationUpdateRequest.getDescription())
                .updatedAt(organizationUpdateRequest.getUpdatedAt().atZone(ZoneId.of("UTC")))
                .build();
    }
}
