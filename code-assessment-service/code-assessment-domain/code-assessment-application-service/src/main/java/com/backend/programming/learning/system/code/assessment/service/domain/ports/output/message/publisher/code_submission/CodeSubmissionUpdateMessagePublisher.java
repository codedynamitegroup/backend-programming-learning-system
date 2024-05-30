package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.code_submission;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdateOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface CodeSubmissionUpdateMessagePublisher {
    void publish(CodeSubmissionUpdateOutboxMessage codeSubmissionUpdateOutboxMessage,
                 BiConsumer<CodeSubmissionUpdateOutboxMessage, OutboxStatus> outboxCallback);
}
