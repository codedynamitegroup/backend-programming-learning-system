package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OutboxResponseRepository<T> {
    T save(T outboxMessage);

    Optional<List<T>> findByTypeAndOutboxStatus(String type,
                                                OutboxStatus outboxStatus);
    void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);
}
