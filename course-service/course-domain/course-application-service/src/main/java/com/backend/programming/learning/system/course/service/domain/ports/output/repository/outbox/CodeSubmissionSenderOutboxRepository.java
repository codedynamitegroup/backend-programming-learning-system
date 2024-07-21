package com.backend.programming.learning.system.course.service.domain.ports.output.repository.outbox;

import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionSenderOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.List;
import java.util.Optional;

public interface CodeSubmissionSenderOutboxRepository {
    void save(CodeSubmissionSenderOutboxMessage message);

    Optional<List<CodeSubmissionSenderOutboxMessage>> findByOutboxStatus(OutboxStatus outboxStatus);

    void deleteByOutboxStatus(OutboxStatus outboxStatus);
}
