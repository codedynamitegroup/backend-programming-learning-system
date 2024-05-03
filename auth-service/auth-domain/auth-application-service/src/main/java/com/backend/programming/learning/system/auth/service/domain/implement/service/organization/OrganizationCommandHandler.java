package com.backend.programming.learning.system.auth.service.domain.implement.service.organization;

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
import com.backend.programming.learning.system.auth.service.domain.entity.Organization;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationCreatedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationDeletedEvent;
import com.backend.programming.learning.system.auth.service.domain.event.organization.OrganizationUpdatedEvent;
import com.backend.programming.learning.system.auth.service.domain.implement.saga.organization.OrganizationUpdateSagaHelper;
import com.backend.programming.learning.system.auth.service.domain.mapper.OrganizationDataMapper;
import com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.organization.OrganizationOutboxHelper;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
public class OrganizationCommandHandler {

    private final OrganizationCreateHelper organizationCreateHelper;
    private final OrganizationDeleteHelper organizationDeleteHelper;
    private final OrganizationQueryHelper organizationQueryHelper;
    private final OrganizationUpdateHelper organizationUpdateHelper;
    private final OrganizationDataMapper organizationDataMapper;
    private final OrganizationUpdateSagaHelper organizationUpdateSagaHelper;
    private final OrganizationOutboxHelper organizationOutboxHelper;

    public OrganizationCommandHandler(OrganizationCreateHelper organizationCreateHelper, OrganizationDeleteHelper organizationDeleteHelper, OrganizationQueryHelper organizationQueryHelper, OrganizationUpdateHelper organizationUpdateHelper, OrganizationDataMapper organizationDataMapper, OrganizationUpdateSagaHelper organizationUpdateSagaHelper, OrganizationOutboxHelper organizationOutboxHelper) {
        this.organizationCreateHelper = organizationCreateHelper;
        this.organizationDeleteHelper = organizationDeleteHelper;
        this.organizationQueryHelper = organizationQueryHelper;
        this.organizationUpdateHelper = organizationUpdateHelper;
        this.organizationDataMapper = organizationDataMapper;
        this.organizationUpdateSagaHelper = organizationUpdateSagaHelper;
        this.organizationOutboxHelper = organizationOutboxHelper;
    }

    @Transactional
    public CreateOrganizationResponse createOrganization(CreateOrganizationCommand createOrganizationCommand) {
        OrganizationCreatedEvent organizationCreatedEvent = organizationCreateHelper.persistOrganization(createOrganizationCommand);
        log.info("Organization is created with id: {}", organizationCreatedEvent.getOrganization().getId().getValue());

        CreateOrganizationResponse createOrganizationResponse = organizationDataMapper.organizationToCreateOrganizationResponse(organizationCreatedEvent.getOrganization(),
                "Organization created successfully");

        organizationOutboxHelper.saveOrganizationOutboxMessage(
                organizationDataMapper.organizationCreatedEventToOrganizationEventPayload(organizationCreatedEvent),
                CopyState.CREATING,
                OutboxStatus.STARTED,
                organizationUpdateSagaHelper.copyStatusToSagaStatus(CopyState.CREATING),
                UUID.randomUUID());
        return createOrganizationResponse;
    }

    @Transactional(readOnly = true)
    public OrganizationEntityResponse queryOrganizationById(QueryOrganizationByIdCommand queryOrganizationCommand) {
        Organization organization = organizationQueryHelper.queryOrganization(queryOrganizationCommand.getOrganizationId());
        log.info("Organization is queried with id: {}", queryOrganizationCommand.getOrganizationId());
        return organizationDataMapper.organizationToOrganizationEntityResponse(organization);
    }

    @Transactional(readOnly = true)
    public QueryAllOrganizationsResponse queryAllOrganizations(QueryAllOrganizationsCommand queryAllOrganizationsCommand) {
        Page<Organization> organizations = organizationQueryHelper.queryAllOrganizations(queryAllOrganizationsCommand.getPageNo(), queryAllOrganizationsCommand.getPageSize());
        log.info("All organizations are queried");
        return organizationDataMapper.organizationsToQueryAllOrganizationsResponse(organizations);
    }

    @Transactional
    public UpdateOrganizationResponse updateOrganization(UpdateOrganizationCommand updateOrganizationCommand) {
        OrganizationUpdatedEvent organizationUpdatedEvent = organizationUpdateHelper.persistOrganization(updateOrganizationCommand);
        log.info("Organization is updated with id: {}", organizationUpdatedEvent.getOrganization().getId().getValue());
        UpdateOrganizationResponse organizationResponse = organizationDataMapper.organizationToUpdateOrganizationResponse(organizationUpdatedEvent.getOrganization(),
                "Organization updated successfully");
        organizationOutboxHelper.saveOrganizationOutboxMessage(
                organizationDataMapper.organizationUpdatedEventToOrganizationEventPayload(organizationUpdatedEvent),
                CopyState.UPDATING,
                OutboxStatus.STARTED,
                organizationUpdateSagaHelper.copyStatusToSagaStatus(CopyState.UPDATING),
                UUID.randomUUID());
        return organizationResponse;
    }

    @Transactional
    public DeleteOrganizationResponse deleteOrganization(DeleteOrganizationCommand deleteOrganizationCommand) {
        OrganizationDeletedEvent organizationDeletedEvent = organizationDeleteHelper.deleteOrganization(deleteOrganizationCommand);
        log.info("Organization is deleted with id: {}", organizationDeletedEvent.getOrganization().getId().getValue());
        DeleteOrganizationResponse deleteOrganizationResponse = organizationDataMapper.deleteOrganizationResponse(organizationDeletedEvent.getOrganization().getId().getValue(),
                "Organization deleted successfully");
        organizationOutboxHelper.saveOrganizationOutboxMessage(
                organizationDataMapper.organizationDeletedEventToOrganizationEventPayload(organizationDeletedEvent),
                CopyState.DELETING,
                OutboxStatus.STARTED,
                organizationUpdateSagaHelper.copyStatusToSagaStatus(CopyState.DELETING),
                UUID.randomUUID());
        return deleteOrganizationResponse;
    }

}
