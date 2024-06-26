package com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user;

import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserOutboxRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.domain.valueobject.UserOutboxServiceType;
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
            String type,
            OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        return userOutboxRepository.findByTypeAndOutboxStatusAndSagaStatus(
                type, outboxStatus, sagaStatus);
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
    public void saveUserOutboxMessage(String type,
                                      UserEventPayload userEventPayload,
                                      ServiceName serviceName,
                                      CopyState state,
                                      OutboxStatus outboxStatus,
                                      SagaStatus sagaStatus,
                                      UUID sagaId) {
        userOutboxRepository.save(UserOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .createdAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)))
                .type(type)
                .payload(createPayload(userEventPayload))
                .copyState(state)
                .outboxStatus(outboxStatus)
                .sagaStatus(sagaStatus)
                .serviceName(serviceName)
                .build());
    }

    private String createPayload(UserEventPayload userEventPayload) {
        try {
            return objectMapper.writeValueAsString(userEventPayload);
        } catch (JsonProcessingException e) {
            log.error("Could not create UserEventPayload object for user id: {}", userEventPayload.getUserId(), e);
            throw new AuthDomainException("Could not create UserEventPayload object for user id: " + userEventPayload.getUserId());
        }
    }

    @Transactional
    public void deleteUserOutboxMessageByOutboxStatusAndSagaStatus(String type, OutboxStatus outboxStatus,
                                                                   SagaStatus... sagaStatus) {
        userOutboxRepository.deleteByTypeAndOutboxStatusAndSagaStatus(type, outboxStatus, sagaStatus);
    }

    @Transactional(readOnly = true)
    public Optional<UserOutboxMessage> findByTypeAndSagaIdAndSagaStatusAndServiceName(String type,
                                                                                                                UUID sagaId,
                                                                                                 SagaStatus sagaStatus,
                                                                                                 ServiceName serviceName) {
        return userOutboxRepository.findByTypeAndSagaIdAndSagaStatusAndServiceName(type, sagaId,
                sagaStatus, serviceName);
    }

    @Transactional
    public void updateOutboxMessage(UserOutboxMessage userOutboxMessage, OutboxStatus outboxStatus) {
        userOutboxMessage.setOutboxStatus(outboxStatus);
        save(userOutboxMessage);
        log.info("User outbox table status is updated as: {}", outboxStatus.name());
    }

    @Transactional(readOnly = true)
    public Optional<UserOutboxMessage> findByTypeAndSagaIdAndCopyStateAndServiceName(String type, UUID sagaId,
                                                                                CopyState copyState,
                                                                                ServiceName serviceName) {
        return userOutboxRepository.findByTypeAndSagaIdAndCopyStateAndServiceName(type, sagaId,
                 copyState, serviceName);
    }
}
