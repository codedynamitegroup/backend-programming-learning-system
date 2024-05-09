package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.organization;

import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.outbox.model.organization.OrganizationEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationOutboxRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.backend.programming.learning.system.saga.organization.SagaConstants.ORGANIZATION_SAGA_NAME;

@Slf4j
@Component
public class OrganizationOutboxHelper {
    private final OrganizationOutboxRepository organizationOutboxRepository;
    private final ObjectMapper objectMapper;

    public OrganizationOutboxHelper(OrganizationOutboxRepository organizationOutboxRepository, ObjectMapper objectMapper) {
        this.organizationOutboxRepository = organizationOutboxRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional(readOnly = true)
    public Optional<OrganizationOutboxMessage> getOrganizationOutboxMessageBySagaIdAndCopyState(UUID sagaId,
                                                                                                CopyState copyState) {
        return organizationOutboxRepository.findByTypeAndSagaIdAndCopyStateAndOutboxStatus(ORGANIZATION_SAGA_NAME, sagaId,
                copyState, OutboxStatus.COMPLETED);
    }

    @Transactional(readOnly = true)
    public Optional<List<OrganizationOutboxMessage>> getOrganizationOutboxMessageByOutboxStatus(OutboxStatus outboxStatus) {
        return organizationOutboxRepository.findByTypeAndOutboxStatus(ORGANIZATION_SAGA_NAME, outboxStatus);
    }

    @Transactional
    public void deleteOrganizationOutboxMessageByOutboxStatus(OutboxStatus outboxStatus) {
        organizationOutboxRepository.deleteByTypeAndOutboxStatus(ORGANIZATION_SAGA_NAME, outboxStatus);
    }

    @Transactional
    public void saveOrganizationOutboxMessage(OrganizationEventPayload organizationEventPayload,
                                              CopyState copyState,
                                              OutboxStatus outboxStatus,
                                              UUID sagaId) {
        save(OrganizationOutboxMessage.builder()
                .id(UUID.randomUUID())
                .type(ORGANIZATION_SAGA_NAME)
                .sagaId(sagaId)
                .createdAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)))
                .processedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)))
                .payload(createdPayload(organizationEventPayload))
                .copyState(copyState)
                .outboxStatus(outboxStatus)
                .build());
    }

    @Transactional
    public void updateOutboxMessage(OrganizationOutboxMessage organizationOutboxMessage, OutboxStatus outboxStatus) {
        organizationOutboxMessage.setOutboxStatus(outboxStatus);
        save(organizationOutboxMessage);
        log.info("User outbox table status is updated as: {}", outboxStatus.name());
    }

    private String createdPayload(OrganizationEventPayload organizationEventPayload) {
        try {
            return objectMapper.writeValueAsString(organizationEventPayload);
        } catch (JsonProcessingException e) {
            log.error("Could not create OrganizationEventPayload json!", e);
            throw new CourseDomainException("Could not create OrganizationEventPayload json!", e);
        }
    }

    private void save(OrganizationOutboxMessage organizationOutboxMessage) {
        OrganizationOutboxMessage response = organizationOutboxRepository.save(organizationOutboxMessage);
        if (response == null) {
            log.error("Could not save OrganizationOutboxMessage!");
            throw new CourseDomainException("Could not save OrganizationOutboxMessage!");
        }
        log.info("OrganizationOutboxMessage is saved with id: {}", organizationOutboxMessage.getId());
    }
}
