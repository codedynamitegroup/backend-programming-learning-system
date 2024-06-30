package com.backend.programming.learning.system.auth.service.domain.mapper;

import com.backend.programming.learning.system.auth.service.domain.dto.method.create.organization.CreateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.create.organization.CreateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.delete.organization.DeleteOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.organization.QueryAllOrganizationsResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization.UpdateOrganizationCommand;
import com.backend.programming.learning.system.auth.service.domain.dto.method.update.organization.UpdateOrganizationResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.organization.OrganizationEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationEventPayload;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Component
public class OrganizationDataMapper {
    private final UserDataMapper userDataMapper;

    public OrganizationDataMapper(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public Organization createOrganizationCommandToOrganization(CreateOrganizationCommand createOrganizationCommand) {
        return Organization.builder()
                .email(createOrganizationCommand.getEmail())
                .description(createOrganizationCommand.getDescription())
                .name(createOrganizationCommand.getName())
                .phone(createOrganizationCommand.getPhone())
                .address(createOrganizationCommand.getAddress())
                .build();
    }

    public CreateOrganizationResponse organizationToCreateOrganizationResponse(Organization organization, String message) {
        return CreateOrganizationResponse.builder()
                .organizationId(organization.getId().getValue())
                .email(organization.getEmail())
                .name(organization.getName())
                .message(message)
                .build();
    }

    public OrganizationEventPayload organizationCreatedEventToOrganizationEventPayload(OrganizationCreatedEvent organizationCreatedEvent) {
        Organization organization = organizationCreatedEvent.getOrganization();
        return OrganizationEventPayload.builder()
                .organizationId(organization.getId().getValue().toString())
                .email(organization.getEmail())
                .description(organization.getDescription())
                .name(organization.getName())
                .phone(organization.getPhone())
                .address(organization.getAddress())
                .createdAt(organization.getCreatedAt())
                .createdBy(organization.getCreatedBy() == null ? null : organization.getCreatedBy().getId().getValue().toString())
                .updatedAt(organization.getUpdatedAt())
                .updatedBy(organization.getUpdatedBy() == null ? null : organization.getUpdatedBy().getId().getValue().toString())
                .isDeleted(organization.getDeleted())
                .copyState(CopyState.CREATING.name())
                .build();
    }

    public OrganizationEntityResponse organizationToOrganizationEntityResponse(Organization organization) {
        return OrganizationEntityResponse.builder()
                .organizationId(organization.getId().getValue())
                .createdBy(organization.getCreatedBy() == null ? null : userDataMapper.userToUserResponse(organization.getCreatedBy()))
                .updatedBy(organization.getUpdatedBy() == null ? null : userDataMapper.userToUserResponse(organization.getUpdatedBy()))
                .email(organization.getEmail())
                .description(organization.getDescription())
                .name(organization.getName())
                .phone(organization.getPhone())
                .address(organization.getAddress())
                .apiKey(organization.getApiKey())
                .moodleUrl(organization.getMoodleUrl())
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .isDeleted(organization.getDeleted())
                .build();
    }

    public QueryAllOrganizationsResponse organizationsToQueryAllOrganizationsResponse(Page<Organization> organizations) {
        List<OrganizationEntityResponse> organizationEntityResponses = organizations
                .map(this::organizationToOrganizationEntityResponse).getContent();
        return QueryAllOrganizationsResponse.builder()
                .organizations(organizationEntityResponses)
                .currentPage(organizations.getNumber())
                .totalPages(organizations.getTotalPages())
                .totalItems(organizations.getTotalElements())
                .build();
    }


    public DeleteOrganizationResponse deleteOrganizationResponse(UUID organizationId, String message) {
        return DeleteOrganizationResponse.builder()
                .organizationId(organizationId)
                .message(message)
                .build();
    }

    public OrganizationEventPayload organizationDeletedEventToOrganizationEventPayload(OrganizationDeletedEvent organizationDeletedEvent) {
        Organization organization = organizationDeletedEvent.getOrganization();
        return OrganizationEventPayload.builder()
                .organizationId(organization.getId().getValue().toString())
                .isDeleted(organization.getDeleted())
                .copyState(CopyState.DELETING.name())
                .build();
    }

    public UpdateOrganizationResponse organizationToUpdateOrganizationResponse(Organization organizationUpdated, String message) {
        return UpdateOrganizationResponse.builder()
                .organizationId(organizationUpdated.getId().getValue())
                .message(message)
                .build();
    }

    public OrganizationEventPayload organizationUpdatedEventToOrganizationEventPayload(OrganizationUpdatedEvent organizationUpdatedEvent) {
        Organization organization = organizationUpdatedEvent.getOrganization();
        return OrganizationEventPayload.builder()
                .organizationId(organization.getId().getValue().toString())
                .description(organization.getDescription())
                .name(organization.getName())
                .email(organization.getEmail())
                .phone(organization.getPhone())
                .address(organization.getAddress())
                .apiKey(organization.getApiKey())
                .moodleUrl(organization.getMoodleUrl())
                .updatedAt(organization.getUpdatedAt())
                .updatedBy(organization.getUpdatedBy().getId().getValue().toString())
                .isDeleted(organization.getDeleted())
                .copyState(CopyState.UPDATING.name())
                .build();
    }
}
