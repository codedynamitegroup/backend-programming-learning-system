package com.backend.programming.learning.system.core.service.domain.outbox.scheduler.code_questions;

import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdateOutboxMessage;
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
public class CodeQuestionsUpdateOutboxCleanerScheduler implements OutboxScheduler {

    private final CodeQuestionsUpdateOutboxHelper outboxHelper;

    public CodeQuestionsUpdateOutboxCleanerScheduler(CodeQuestionsUpdateOutboxHelper outboxHelper) {
        this.outboxHelper = outboxHelper;
    }

    @Override
    @Scheduled(cron = "@midnight")
    @Transactional
    public void processOutboxMessage() {
        Optional<List<CodeQuestionsUpdateOutboxMessage>> outboxMessagesResponse =
                outboxHelper.getCodeQuestionsUpdateOutboxMessageByOutboxStatus(OutboxStatus.COMPLETED);

        if (outboxMessagesResponse.isPresent()) {
            List<CodeQuestionsUpdateOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} CodeQuestionsUpdateOutboxMessage for clean-up. The payloads: {}",
                    outboxMessages.size(),
                    outboxMessages.stream().map(CodeQuestionsUpdateOutboxMessage::getPayload)
                            .collect(Collectors.joining("\n")));
            outboxHelper.deleteCodeQuestionsUpdateOutboxMessageByOutboxStatus( OutboxStatus.COMPLETED);
            log.info("{} OrderPaymentOutboxMessage deleted!", outboxMessages.size());
        }
    }
}
