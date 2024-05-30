package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.question;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface QuestionResponseMessagePublisher {
    void publish(QuestionOutboxMessage questionOutboxMessage,
                 BiConsumer<QuestionOutboxMessage, OutboxStatus> outboxCallback);
}
