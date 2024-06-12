package com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.user;

import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.UserOutboxRepository;
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

import static com.backend.programming.learning.system.saga.user.SagaConstants.AUTH_TO_ANY_SERVICES_USER_SAGA_NAME;

@Slf4j
@Component
public class UserOutboxHelper {
    private final UserOutboxRepository userOutboxRepository;
    private final ObjectMapper objectMapper;

    public UserOutboxHelper(UserOutboxRepository userOutboxRepository, ObjectMapper objectMapper) {
        this.userOutboxRepository = userOutboxRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional(readOnly = true)
    public Optional<UserOutboxMessage> getUserOutboxMessageBySagaIdAndCopyState(UUID sagaId,
                                                                                CopyState copyState) {
        return userOutboxRepository.findByTypeAndSagaIdAndCopyStateAndOutboxStatus(AUTH_TO_ANY_SERVICES_USER_SAGA_NAME, sagaId,
                copyState, OutboxStatus.COMPLETED);
    }

    @Transactional(readOnly = true)
    public Optional<List<UserOutboxMessage>> getUserOutboxMessageByOutboxStatus(OutboxStatus outboxStatus) {
        return userOutboxRepository.findByTypeAndOutboxStatus(AUTH_TO_ANY_SERVICES_USER_SAGA_NAME, outboxStatus);
    }

    @Transactional
    public void deleteUserOutboxMessageByOutboxStatus(OutboxStatus outboxStatus) {
        userOutboxRepository.deleteByTypeAndOutboxStatus(AUTH_TO_ANY_SERVICES_USER_SAGA_NAME, outboxStatus);
    }

    @Transactional
    public void saveUserOutboxMessage(UserEventPayload userEventPayload,
                                      CopyState copyState,
                                      OutboxStatus outboxStatus,
                                      UUID sagaId) {
        save(UserOutboxMessage.builder()
                .id(UUID.randomUUID())
                .type(AUTH_TO_ANY_SERVICES_USER_SAGA_NAME)
                .sagaId(sagaId)
                .createdAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)))
                .processedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)))
                .payload(createdPayload(userEventPayload))
                .copyState(copyState)
                .outboxStatus(outboxStatus)
                .build());
    }

    @Transactional
    public void updateOutboxMessage(UserOutboxMessage userOutboxMessage, OutboxStatus outboxStatus) {
        userOutboxMessage.setOutboxStatus(outboxStatus);
        save(userOutboxMessage);
        log.info("User outbox table status is updated as: {}", outboxStatus.name());
    }

    private String createdPayload(UserEventPayload userEventPayload) {
        try {
            return objectMapper.writeValueAsString(userEventPayload);
        } catch (JsonProcessingException e) {
            log.error("Could not create UserEventPayload json!", e);
            throw new CodeAssessmentDomainException("Could not create UserEventPayload json!", e);
        }
    }

    private void save(UserOutboxMessage userOutboxMessage) {
        UserOutboxMessage response = userOutboxRepository.save(userOutboxMessage);
        if (response == null) {
            log.error("Could not save UserOutboxMessage!");
            throw new CodeAssessmentDomainException("Could not save UserOutboxMessage!");
        }
        log.info("UserOutboxMessage is saved with id: {}", userOutboxMessage.getId());
    }
}
