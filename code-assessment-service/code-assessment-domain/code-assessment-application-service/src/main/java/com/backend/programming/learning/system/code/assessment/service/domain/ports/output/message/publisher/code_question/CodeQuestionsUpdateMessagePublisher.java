package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface CodeQuestionsUpdateMessagePublisher {

    void publish(CodeQuestionsUpdateOutboxMessage codeQuestionsUpdateOutboxMessage,
                 BiConsumer<CodeQuestionsUpdateOutboxMessage, OutboxStatus> outboxCallback);
}
