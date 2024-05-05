package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuestionOutboxRepository {
    QuestionOutboxMessage save(QuestionOutboxMessage questionOutboxMessage);
    Optional<List<QuestionOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(String type,
                                                                                 OutboxStatus outboxStatus,
                                                                                 SagaStatus... sagaStatus);

    Optional<QuestionOutboxMessage> findByTypeAndSagaIdAndCopyStateAndSagaStatus(String type,
                                                                     UUID sagaId,
                                                                     CopyState copyState,
                                                                     SagaStatus... sagaStatus);
    void deleteByTypeAndOutboxStatusAndSagaStatus(String type,
                                                  OutboxStatus outboxStatus,
                                                  SagaStatus... sagaStatus);
}
