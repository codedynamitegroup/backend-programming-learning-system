package com.backend.programming.learning.system.core.service.domain.outbox.scheduler.contest_user;

import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateEventPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserUpdateOutboxRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;
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

import static com.backend.programming.learning.system.saga.contest_user.SagaConstants.CONTEST_USER_SAGA_NAME;

@Slf4j
@Component
public class ContestUserUpdateOutboxHelper {
    private final ContestUserUpdateOutboxRepository contestUserUpdateOutboxRepository;
    private final ObjectMapper objectMapper;

    public ContestUserUpdateOutboxHelper(ContestUserUpdateOutboxRepository contestUserUpdateOutboxRepository,
                                         ObjectMapper objectMapper) {
        this.contestUserUpdateOutboxRepository = contestUserUpdateOutboxRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional(readOnly = true)
    public Optional<List<ContestUserUpdateOutboxMessage>> getContestUserUpdateOutboxMessageByOutboxStatusAndSagaStatus(
            OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        return contestUserUpdateOutboxRepository.findByTypeAndOutboxStatusAndSagaStatus(
                CONTEST_USER_SAGA_NAME, outboxStatus, sagaStatus);
    }

    @Transactional(readOnly = true)
    public Optional<ContestUserUpdateOutboxMessage> getContestUserUpdateOutboxMessageBySagaIdAndSagaStatus(
            UUID sagaId,
            SagaStatus... sagaStatus) {
        return contestUserUpdateOutboxRepository.findByTypeAndSagaIdAndSagaStatus(CONTEST_USER_SAGA_NAME, sagaId, sagaStatus);
    }

    @Transactional
    public void save(ContestUserUpdateOutboxMessage contestUserUpdateOutboxMessage) {
        ContestUserUpdateOutboxMessage response = contestUserUpdateOutboxRepository.save(contestUserUpdateOutboxMessage);
        if (response == null) {
            log.error("Could not save ContestUserUpdateOutboxMessage with outbox id: {}",
                    contestUserUpdateOutboxMessage.getId());
            throw new CoreDomainException("Could not save ContestUserUpdateOutboxMessage with outbox id: " +
                    contestUserUpdateOutboxMessage.getId());
        }
        log.info("ContestUserUpdateOutboxMessage saved with outbox id: {}", contestUserUpdateOutboxMessage.getId());
    }

    @Transactional
    public void saveContestUserUpdateOutboxMessage(
            ContestUserUpdateEventPayload contestUserUpdateEventPayload,
            UpdateState updateCalendarEventState,
            SagaStatus sagaStatus,
            OutboxStatus outboxStatus,
            UUID sagaId) {
        save(ContestUserUpdateOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .createdAt(contestUserUpdateEventPayload.getCreatedAt())
                .type(CONTEST_USER_SAGA_NAME)
                .payload(createPayload(contestUserUpdateEventPayload))
                .updateCalendarEventState(updateCalendarEventState)
                .sagaStatus(sagaStatus)
                .outboxStatus(outboxStatus)
                .build());
    }

    @Transactional
    public void deleteContestUserUpdateOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus outboxStatus,
                                                                      SagaStatus... sagaStatus) {
        contestUserUpdateOutboxRepository.deleteByTypeAndOutboxStatusAndSagaStatus(
                CONTEST_USER_SAGA_NAME, outboxStatus, sagaStatus);
    }

    private String createPayload(ContestUserUpdateEventPayload contestUserUpdateEventPayload) {
        try {
            return objectMapper.writeValueAsString(contestUserUpdateEventPayload);
        } catch (JsonProcessingException e) {
            log.error("Could not create ContestUserUpdateEventPayload object for contest id: {} and user id: {}",
                    contestUserUpdateEventPayload.getContestId(),
                    contestUserUpdateEventPayload.getUserId(),
                    e);
            throw new CoreDomainException("Could not create ContestUserUpdateEventPayload object for contest id: " +
                    contestUserUpdateEventPayload.getContestId() +
                    " and user id: " + contestUserUpdateEventPayload.getUserId(), e);
        }
    }

}
