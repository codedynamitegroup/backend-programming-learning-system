package com.backend.programming.learning.system.auth.service.domain.scheduler.user;

import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserOutboxRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.backend.programming.learning.system.saga.auth.SagaConstants.AUTH_SAGA_NAME;

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
    public Optional<List<UserOutboxMessage>> getUserOutboxMessageByOutboxStatusAndSagaStatus(
            OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        return userOutboxRepository.findByTypeAndOutboxStatusAndSagaStatus(AUTH_SAGA_NAME, outboxStatus, sagaStatus);
    }

    @Transactional(readOnly = true)
    public Optional<UserOutboxMessage> getUserOutboxMessageBySagaIdAndSagaStatus(UUID sagaId, SagaStatus... sagaStatus) {
        return userOutboxRepository.findByTypeAndSagaIdAndSagaStatus(AUTH_SAGA_NAME, sagaId, sagaStatus);
    }

    @Transactional
    public void save(UserOutboxMessage userOutboxMessage) {
        UserOutboxMessage response = userOutboxRepository.save(userOutboxMessage);
        if (response == null) {
            log.error("Could not save UserOutboxMessage with outbox id: {}", userOutboxMessage.getId());
            throw new AuthDomainException("Could not save UserOutboxMessage with outbox id: " + userOutboxMessage.getId());
        }
        log.info("UserOutboxMessage saved with outbox id: {}", userOutboxMessage.getId());
    }

    @Transactional
    public void saveUserOutboxMessage(UserEventPayload userCreatedEventPayload,
                                             CopyState state, OutboxStatus outboxStatus, SagaStatus sagaStatus, UUID sagaId) {
        userOutboxRepository.save(UserOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .createdAt(userCreatedEventPayload.getCreatedAt())
                .type(AUTH_SAGA_NAME)
                .payload(createPayload(userCreatedEventPayload))
                .copyState(state)
                .outboxStatus(outboxStatus)
                .sagaStatus(sagaStatus)
                .build());
    }

    private String createPayload(UserEventPayload userCreatedEventPayload) {
        try {
            return objectMapper.writeValueAsString(userCreatedEventPayload);
        } catch (JsonProcessingException e) {
            log.error("Could not create UserCreatedEventPayload object for user id: {}", userCreatedEventPayload.getUserId(), e);
            throw new AuthDomainException("Could not create UserCreatedEventPayload object for user id: " + userCreatedEventPayload.getUserId());
        }
    }

    @Transactional
    public void deleteUserOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus outboxStatus,
                                                                   SagaStatus... sagaStatus) {
        userOutboxRepository.deleteByTypeAndOutboxStatusAndSagaStatus(AUTH_SAGA_NAME, outboxStatus, sagaStatus);
    }
}
