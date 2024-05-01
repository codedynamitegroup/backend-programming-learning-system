package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.question;

import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface QuestionRequestMessagePublisher {
    void publish(QuestionOutboxMessage questionOutboxMessage,
                 BiConsumer<QuestionOutboxMessage, OutboxStatus> outboxCallback);
}
