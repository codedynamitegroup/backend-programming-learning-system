package com.backend.programming.learning.system.core.service.domain.outbox.scheduler.code_questions;


import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.code_questions.CodeQuestionsUpdateResponseMessagePublisher;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CodeQuestionsUpdateOutboxScheduler implements OutboxScheduler {
    private final CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper;
    private final CodeQuestionsUpdateResponseMessagePublisher codeQuestionsUpdateMessagePublisher;

    public CodeQuestionsUpdateOutboxScheduler(
            CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper,
            CodeQuestionsUpdateResponseMessagePublisher codeQuestionsUpdateMessagePublisher) {
        this.codeQuestionsUpdateOutboxHelper = codeQuestionsUpdateOutboxHelper;
        this.codeQuestionsUpdateMessagePublisher = codeQuestionsUpdateMessagePublisher;
    }

    @Override
    @Transactional
    @Scheduled(fixedDelayString = "${core-service.outbox-scheduler-fixed-rate}",
                initialDelayString = "${core-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<CodeQuestionsUpdateOutboxMessage>> outboxMessagesResponse =
        codeQuestionsUpdateOutboxHelper
                .getCodeQuestionsUpdateOutboxMessageByOutboxStatus(OutboxStatus.STARTED);

        if (outboxMessagesResponse.isPresent() && outboxMessagesResponse.get().size() > 0) {
            List<CodeQuestionsUpdateOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} CodeQuestionsUpdateOutboxMessage with ids: {}, sending to message bus!",
                    outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(outboxMessage ->
                    codeQuestionsUpdateMessagePublisher.publish(outboxMessage, this::updateOutboxStatus));
            log.info("{} CodeQuestionsUpdateOutboxMessage sent to message bus!", outboxMessages.size());
        }
    }
    private void updateOutboxStatus(CodeQuestionsUpdateOutboxMessage outboxMessage, OutboxStatus outboxStatus) {
        outboxMessage.setOutboxStatus(outboxStatus);
        codeQuestionsUpdateOutboxHelper.save(outboxMessage);
        log.info("OrderPaymentOutboxMessage is updated with outbox status: {}", outboxStatus.name());
    }
}
