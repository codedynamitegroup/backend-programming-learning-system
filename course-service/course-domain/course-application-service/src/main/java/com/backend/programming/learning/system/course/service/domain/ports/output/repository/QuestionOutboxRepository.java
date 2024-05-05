package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuestionOutboxRepository {
    QuestionOutboxMessage save(QuestionOutboxMessage questionOutboxMessage);
    Optional<List<QuestionOutboxMessage>> findByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);
    Optional<QuestionOutboxMessage> findByTypeAndSagaId(String type, UUID sagaId);
    void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus);
}
