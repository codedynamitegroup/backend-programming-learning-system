package com.backend.programming.learning.system.core.service.domain.implement.message.listener.organization;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.organization.OrganizationRequest;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.user.UserRequest;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.event.organization.*;
import com.backend.programming.learning.system.core.service.domain.event.user.*;
import com.backend.programming.learning.system.core.service.domain.mapper.organization.OrganizationDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.organization.OrganizationOutboxHelper;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.organization.OrganizationResponseMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrganizationRequestHelper {
    private final OrganizationDataMapper organizationDataMapper;
    private final OrganizationRepository organizationRepository;
    private final CoreDomainService coreDomainService;
    private final OrganizationOutboxHelper organizationOutboxHelper;
    private final OrganizationResponseMessagePublisher organizationResponseMessagePublisher;

    public OrganizationRequestHelper(OrganizationDataMapper organizationDataMapper, OrganizationRepository organizationRepository, CoreDomainService coreDomainService, OrganizationOutboxHelper organizationOutboxHelper, OrganizationResponseMessagePublisher organizationResponseMessagePublisher) {
        this.organizationDataMapper = organizationDataMapper;
        this.organizationRepository = organizationRepository;
        this.coreDomainService = coreDomainService;
        this.organizationOutboxHelper = organizationOutboxHelper;
        this.organizationResponseMessagePublisher = organizationResponseMessagePublisher;
    }

    @Transactional
    public void createdOrganization(OrganizationRequest organizationRequest) {
        if (publishOutboxMessageProcessedForUser(organizationRequest, CopyState.CREATED)) {
            log.info("An outbox message with saga id: {} is already saved to database", organizationRequest.getSagaId());
            return;
        }

        Organization organization = organizationDataMapper.organizationCreatedRequestToOrganization(organizationRequest);
        List<String> failureMessages = new ArrayList<>();

        //Save organization
        Organization organizationSaved = organizationRepository.save(organization);
        if (organizationSaved == null) {
            log.error("Could not create organization with id: {}", organization.getId().getValue().toString());
            failureMessages.add("Could not create organization with id: " + organization.getId().getValue().toString());
            OrganizationCreatedFailEvent organizationCreatedFailEvent = coreDomainService.createdOrganizationFail(organization, failureMessages);
            organizationOutboxHelper.saveOrganizationOutboxMessage(organizationDataMapper.organizationEventToOrganizationEventPayload(
                    organizationCreatedFailEvent, CopyState.CREATE_FAILED),
                    CopyState.CREATE_FAILED,
                    OutboxStatus.STARTED,
                    UUID.fromString(organizationRequest.getSagaId()));
            return;
        }

        log.info("Organization is created with id: {}", organizationSaved.getId().getValue());
        OrganizationCreatedSuccessEvent organizationCreatedSuccessEvent = coreDomainService.createdOrganizationSuccess(organization);

        organizationOutboxHelper.saveOrganizationOutboxMessage(organizationDataMapper.organizationEventToOrganizationEventPayload(
                organizationCreatedSuccessEvent, CopyState.CREATED),
                CopyState.CREATED,
                OutboxStatus.STARTED,
                UUID.fromString(organizationRequest.getSagaId()));
    }

    @Transactional
    public void deletedOrganization(OrganizationRequest organizationRequest) {
        if (publishOutboxMessageProcessedForUser(organizationRequest, CopyState.DELETED)) {
            log.info("An outbox message with saga id: {} is already saved to database", organizationRequest.getSagaId());
            return;
        }

        Organization organization = organizationDataMapper.organizationDeletedRequestToOrganization(organizationRequest);
        Optional<Organization> organizationFound = organizationRepository.findOrganization(organization.getId().getValue());
        List<String> failureMessages = new ArrayList<>();
        //Find organization with id
        if (organizationFound.isEmpty()) {
            log.error("Not found organization with id: {}", organization.getId().getValue());
            failureMessages.add("Not found organization with id: " + organization.getId().getValue());
            OrganizationDeletedFailEvent organizationDeletedFailEvent = coreDomainService.deletedOrganizationFail(
                    organization, failureMessages);
            organizationOutboxHelper.saveOrganizationOutboxMessage(organizationDataMapper.organizationEventToOrganizationEventPayload(
                    organizationDeletedFailEvent, CopyState.DELETE_FAILED),
                    CopyState.DELETE_FAILED,
                    OutboxStatus.STARTED,
                    UUID.fromString(organizationRequest.getSagaId()));
            return;
        }

        //Deleting organization
        Organization organizationDeleted = organizationFound.get();

        organizationDeleted.setDeleted(organization.getDeleted());

        //Save organization
        Organization organizationSaved = organizationRepository.save(organizationDeleted);
        if (organizationSaved == null) {
            log.error("Could not delete organization with id: {}", organization.getId().getValue());
            return;
        }
        log.info("Organization is deleted with id: {}", organizationSaved.getId().getValue());

        OrganizationDeletedSuccessEvent organizationDeletedSuccessEvent = coreDomainService.deletedOrganizationSuccess(organization);

        organizationOutboxHelper.saveOrganizationOutboxMessage(organizationDataMapper.organizationEventToOrganizationEventPayload(
                organizationDeletedSuccessEvent, CopyState.DELETED),
                CopyState.DELETED,
                OutboxStatus.STARTED,
                UUID.fromString(organizationRequest.getSagaId()));
    }

    @Transactional
    public void updatedOrganization(OrganizationRequest organizationRequest) {
        if (publishOutboxMessageProcessedForUser(organizationRequest, CopyState.UPDATED)) {
            log.info("An outbox message with saga id: {} is already saved to database", organizationRequest.getSagaId());
            return;
        }

        Organization organization = organizationDataMapper.organizationUpdatedRequestToOrganization(organizationRequest);
        Optional<Organization> organizationFound = organizationRepository.findOrganization(organization.getId().getValue());
        List<String> failureMessages = new ArrayList<>();

        //Not found organization with id
        if (organizationFound.isEmpty()) {
            log.error("Not found organization with id: {}", organization.getId().getValue());
            failureMessages.add("Not found organization with id: " + organization.getId().getValue());
            OrganizationUpdatedFailEvent organizationUpdatedFailEvent = coreDomainService.updatedOrganizationFail(
                    organization, failureMessages);
            organizationOutboxHelper.saveOrganizationOutboxMessage(organizationDataMapper.organizationEventToOrganizationEventPayload(
                    organizationUpdatedFailEvent, CopyState.UPDATE_FAILED),
                    CopyState.UPDATE_FAILED,
                    OutboxStatus.STARTED,
                    UUID.fromString(organizationRequest.getSagaId()));
            return;
        }

        //Update organization
        Organization organizationUpdated = organizationFound.get();

        organizationUpdated.setUpdatedAt(organizationUpdated.getUpdatedAt());

        if (organizationRequest.getName() != null) {
            organizationUpdated.setName(organization.getName());
        }
        if (organizationRequest.getDescription() != null) {
            organizationUpdated.setDescription(organization.getDescription());
        }
        if (organizationRequest.getApiKey() != null) {
            organizationUpdated.setApiKey(organization.getApiKey());
        }
        if (organizationRequest.getMoodleUrl() != null) {
            organizationUpdated.setMoodleUrl(organization.getMoodleUrl());
        }

        //Save organization
        Organization organizationSaved = organizationRepository.save(organizationUpdated);
        if (organizationSaved == null) {
            log.error("Could not update organization with id: {}", organization.getId().getValue());
            failureMessages.add("Could not update organization with id: " + organization.getId().getValue());
            OrganizationUpdatedFailEvent organizationUpdatedFailEvent = coreDomainService.updatedOrganizationFail(
                    organization, failureMessages);
            organizationOutboxHelper.saveOrganizationOutboxMessage(organizationDataMapper.organizationEventToOrganizationEventPayload(
                    organizationUpdatedFailEvent, CopyState.UPDATE_FAILED),
                    CopyState.UPDATE_FAILED,
                    OutboxStatus.STARTED,
                    UUID.fromString(organizationRequest.getSagaId()));
            return;
        }

        log.info("Organization is updated with id: {}", organizationSaved.getId().getValue());
        OrganizationUpdatedSuccessEvent organizationUpdatedSuccessEvent = coreDomainService.updatedOrganizationSuccess(organization);

        organizationOutboxHelper.saveOrganizationOutboxMessage(organizationDataMapper.organizationEventToOrganizationEventPayload(
                organizationUpdatedSuccessEvent, CopyState.UPDATED),
                CopyState.UPDATED,
                OutboxStatus.STARTED,
                UUID.fromString(organizationRequest.getSagaId()));
    }

    private boolean publishOutboxMessageProcessedForUser(OrganizationRequest organizationRequest, CopyState copyState) {
        Optional<OrganizationOutboxMessage> outboxMessage =
                organizationOutboxHelper.getOrganizationOutboxMessageBySagaIdAndCopyState(
                        UUID.fromString(organizationRequest.getSagaId()), copyState);
        if (outboxMessage.isPresent()) {
            organizationResponseMessagePublisher.publish(outboxMessage.get(), organizationOutboxHelper::updateOutboxMessage);
            return true;
        }
        return false;
    }
}
