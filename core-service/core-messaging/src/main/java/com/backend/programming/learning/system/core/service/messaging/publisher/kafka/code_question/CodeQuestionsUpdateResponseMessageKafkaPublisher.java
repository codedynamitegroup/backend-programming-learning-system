package com.backend.programming.learning.system.core.service.messaging.publisher.kafka.code_question;

import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.code_questions.CodeQuestionsUpdateResponseMessagePublisher;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class CodeQuestionsUpdateResponseMessageKafkaPublisher implements CodeQuestionsUpdateResponseMessagePublisher {
    @Override
    public void publish(CodeQuestionsUpdateOutboxMessage codeQuestionsUpdateOutboxMessage,
                        BiConsumer<CodeQuestionsUpdateOutboxMessage, OutboxStatus> outboxCallback) {


    }
}
