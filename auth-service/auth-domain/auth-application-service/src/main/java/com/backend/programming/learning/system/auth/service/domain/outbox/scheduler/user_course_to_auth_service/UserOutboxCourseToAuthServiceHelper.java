package com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user_course_to_auth_service;

import com.backend.programming.learning.system.auth.service.domain.exception.AuthDomainException;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_course_to_auth_service.UserEventCourseToAuthServicePayload;
import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_course_to_auth_service.UserOutboxCourseToAuthServiceMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserOutboxCourseToAuthServiceRepository;
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

import static com.backend.programming.learning.system.saga.user.SagaConstants.USER_SAGA_NAME;

@Slf4j
@Component
public class UserOutboxCourseToAuthServiceHelper {
    private final UserOutboxCourseToAuthServiceRepository userOutboxRepository;
    private final ObjectMapper objectMapper;

    public UserOutboxCourseToAuthServiceHelper(UserOutboxCourseToAuthServiceRepository userOutboxRepository, ObjectMapper objectMapper) {
        this.userOutboxRepository = userOutboxRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional(readOnly = true)
    public Optional<List<UserOutboxCourseToAuthServiceMessage>> getUserOutboxMessageByOutboxStatusAndSagaStatus(
            OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        return userOutboxRepository.findByTypeAndOutboxStatusAndSagaStatus(
                USER_SAGA_NAME, outboxStatus, sagaStatus);
    }

    @Transactional(readOnly = true)
    public Optional<UserOutboxCourseToAuthServiceMessage> getUserOutboxMessageBySagaIdAndServiceNameAndSagaStatus(
            UUID sagaId, SagaStatus... sagaStatus) {
        return userOutboxRepository.findByTypeAndSagaIdAndSagaStatus(
                USER_SAGA_NAME, sagaId, sagaStatus);
    }

    @Transactional
    public void save(UserOutboxCourseToAuthServiceMessage userOutboxMessage) {
        UserOutboxCourseToAuthServiceMessage response = userOutboxRepository.save(userOutboxMessage);
        if (response == null) {
            log.error("Could not save UserOutboxMessage with outbox id: {}", userOutboxMessage.getId());
            throw new AuthDomainException("Could not save UserOutboxMessage with outbox id: " + userOutboxMessage.getId());
        }
        log.info("UserOutboxMessage saved with outbox id: {}", userOutboxMessage.getId());
    }

    @Transactional
    public void saveUserOutboxMessage(UserEventCourseToAuthServicePayload userEventPayload,
                                      ServiceName serviceName,
                                      CopyState state,
                                      OutboxStatus outboxStatus,
                                      SagaStatus sagaStatus,
                                      UUID sagaId) {
        userOutboxRepository.save(UserOutboxCourseToAuthServiceMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .createdAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)))
                .type(USER_SAGA_NAME)
                .payload(createPayload(userEventPayload))
                .copyState(state)
                .outboxStatus(outboxStatus)
                .sagaStatus(sagaStatus)
                .build());
    }

    private String createPayload(UserEventCourseToAuthServicePayload userEventPayload) {
        try {
            return objectMapper.writeValueAsString(userEventPayload);
        } catch (JsonProcessingException e) {
            log.error("Could not create UserEventPayload object for user id: {}", userEventPayload.getUserId(), e);
            throw new AuthDomainException("Could not create UserEventPayload object for user id: " + userEventPayload.getUserId());
        }
    }

    @Transactional
    public void deleteUserOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus outboxStatus,
                                                                   SagaStatus... sagaStatus) {
        userOutboxRepository.deleteByTypeAndOutboxStatusAndSagaStatus(USER_SAGA_NAME, outboxStatus, sagaStatus);
    }

    @Transactional
    public void updateOutboxMessage(UserOutboxCourseToAuthServiceMessage userOutboxMessage, OutboxStatus outboxStatus) {
        userOutboxMessage.setOutboxStatus(outboxStatus);
        save(userOutboxMessage);
        log.info("User outbox table status is updated as: {}", outboxStatus.name());
    }
}
