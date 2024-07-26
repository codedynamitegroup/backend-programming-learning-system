package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.user;

import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.outbox.UserOutboxRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
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
    public Optional<UserOutboxMessage> getUserOutboxMessageBySagaIdAndCopyState(String type, UUID sagaId,
                                                                                CopyState copyState) {
        return userOutboxRepository.findByTypeAndSagaIdAndCopyStateAndOutboxStatus(type, sagaId,
                copyState, OutboxStatus.COMPLETED);
    }

    @Transactional(readOnly = true)
    public Optional<UserOutboxMessage> findByTypeAndSagaIdAndSagaStatus(String type,
                                                                                      UUID sagaId,
                                                                                      SagaStatus sagaStatus) {
        return userOutboxRepository.findByTypeAndSagaIdAndSagaStatus(type, sagaId, sagaStatus);
    }

    @Transactional(readOnly = true)
    public Optional<List<UserOutboxMessage>> getUserOutboxMessageByOutboxStatus(String type, OutboxStatus outboxStatus) {
        return userOutboxRepository.findByTypeAndOutboxStatus(type, outboxStatus);
    }

    @Transactional
    public void deleteUserOutboxMessageByOutboxStatus(String type, OutboxStatus outboxStatus) {
        userOutboxRepository.deleteByTypeAndOutboxStatus(type, outboxStatus);
    }

    @Transactional
    public void saveUserOutboxMessage(String type,
            UserEventPayload userEventPayload,
                                      CopyState copyState,
                                      OutboxStatus outboxStatus,
                                      SagaStatus sagaStatus,
                                      UUID sagaId) {
        save(UserOutboxMessage.builder()
                .id(UUID.randomUUID())
                .type(type)
                .sagaId(sagaId)
                .createdAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)))
                .processedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)))
                .payload(createdPayload(userEventPayload))
                .copyState(copyState)
                .sagaStatus(sagaStatus)
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
            throw new CourseDomainException("Could not create UserEventPayload json!", e);
        }
    }

    public void save(UserOutboxMessage userOutboxMessage) {
        UserOutboxMessage response = userOutboxRepository.save(userOutboxMessage);
        if (response == null) {
            log.error("Could not save UserOutboxMessage!");
            throw new CourseDomainException("Could not save UserOutboxMessage!");
        }
        log.info("UserOutboxMessage is saved with id: {}", userOutboxMessage.getId());
    }
}
