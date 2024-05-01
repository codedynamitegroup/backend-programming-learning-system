package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContestUserUpdateOutboxRepository {
    ContestUserUpdateOutboxMessage save(ContestUserUpdateOutboxMessage contestUserUpdateOutboxMessage);

    Optional<List<ContestUserUpdateOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(
            String type,
            OutboxStatus outboxStatus,
            SagaStatus... sagaStatus);

    Optional<ContestUserUpdateOutboxMessage> findByTypeAndSagaIdAndSagaStatus(
            String type,
            UUID sagaId,
            SagaStatus... sagaStatus);

    void deleteByTypeAndOutboxStatusAndSagaStatus(
            String type,
            OutboxStatus outboxStatus,
            SagaStatus... sagaStatus);
}
