package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OutboxRepository<T> {
    T save(T outboxMessage);

    Optional<List<T>> findByTypeAndOutboxStatusAndSagaStatus(String type,
                                                             OutboxStatus outboxStatus,
                                                             SagaStatus... sagaStatus);
    Optional<T> findByTypeAndSagaIdAndSagaStatus(String type,
                                                 UUID sagaId,
                                                 SagaStatus... sagaStatus);
    void deleteByTypeAndOutboxStatusAndSagaStatus(String type,
                                                  OutboxStatus outboxStatus,
                                                  SagaStatus... sagaStatus);
}
