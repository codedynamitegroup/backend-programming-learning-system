package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.code_questions;

import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface CodeQuestionsUpdateResponseMessagePublisher {
    void publish(CodeQuestionsUpdateOutboxMessage codeQuestionsUpdateOutboxMessage,
                 BiConsumer<CodeQuestionsUpdateOutboxMessage, OutboxStatus> outboxCallback);
}
