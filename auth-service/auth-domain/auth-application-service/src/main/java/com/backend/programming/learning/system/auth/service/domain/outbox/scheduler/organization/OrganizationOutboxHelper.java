package com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.organization;

import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationEventPayload;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.OrganizationOutboxRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
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
    public Optional<List<OrganizationOutboxMessage>> getOrganizationOutboxMessageByOutboxStatusAndSagaStatus(
            OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        return organizationOutboxRepository.findByTypeAndOutboxStatusAndSagaStatus(ORGANIZATION_SAGA_NAME, outboxStatus, sagaStatus);
    }

    @Transactional(readOnly = true)
    public Optional<OrganizationOutboxMessage> getOrganizationOutboxMessageBySagaIdAndSagaStatus(UUID sagaId, SagaStatus... sagaStatus) {
        return organizationOutboxRepository.findByTypeAndSagaIdAndSagaStatus(ORGANIZATION_SAGA_NAME, sagaId, sagaStatus);
    }

    @Transactional
    public void save(OrganizationOutboxMessage organizationOutboxMessage) {
        OrganizationOutboxMessage response = organizationOutboxRepository.save(organizationOutboxMessage);
        if (response == null) {
            log.error("Could not save OrganizationOutboxMessage with outbox id: {}", organizationOutboxMessage.getId());
            throw new AuthDomainException("Could not save OrganizationOutboxMessage with outbox id: " + organizationOutboxMessage.getId());
        }
        log.info("OrganizationOutboxMessage saved with outbox id: {}", organizationOutboxMessage.getId());
    }

    @Transactional
    public void saveOrganizationOutboxMessage(OrganizationEventPayload organizationEventPayload,
                                              CopyState state, OutboxStatus outboxStatus, SagaStatus sagaStatus, UUID sagaId) {
        organizationOutboxRepository.save(OrganizationOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .createdAt(ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)))
                .type(ORGANIZATION_SAGA_NAME)
                .payload(createPayload(organizationEventPayload))
                .copyState(state)
                .outboxStatus(outboxStatus)
                .sagaStatus(sagaStatus)
                .build());
    }

    private String createPayload(OrganizationEventPayload organizationEventPayload) {
        try {
            return objectMapper.writeValueAsString(organizationEventPayload);
        } catch (JsonProcessingException e) {
            log.error("Could not create OrganizationEventPayload object for organization id: {}", organizationEventPayload.getOrganizationId(), e);
            throw new AuthDomainException("Could not create OrganizationEventPayload object for organization id: " + organizationEventPayload.getOrganizationId());
        }
    }

    @Transactional
    public void deleteOrganizationOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus outboxStatus,
                                                                   SagaStatus... sagaStatus) {
        organizationOutboxRepository.deleteByTypeAndOutboxStatusAndSagaStatus(ORGANIZATION_SAGA_NAME, outboxStatus, sagaStatus);
    }
}
