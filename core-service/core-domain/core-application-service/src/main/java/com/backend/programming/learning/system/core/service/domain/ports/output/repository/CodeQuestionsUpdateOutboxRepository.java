package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.Optional;
import java.util.UUID;

public interface CodeQuestionsUpdateOutboxRepository
        extends OutboxResponseRepository<CodeQuestionsUpdateOutboxMessage> {
    Optional<CodeQuestionsUpdateOutboxMessage>
    findByTypeAndSagaIdAndCopyStateAndOutboxStatus(String type,
                                                   UUID sagaId,
                                                   CopyState copyState,
                                                   OutboxStatus outboxStatus);

}
