package com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_questions_update_outbox;


import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
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
    @Transactional
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
        Optional<List<CodeQuestionsUpdateOutboxMessage>> outboxMessagesResponse =
                outboxHelper.getCodeQuestionsUpdateOutboxMessageByOutboxStatusAndSagaStatus(
                                OutboxStatus.COMPLETED,
                                SagaStatus.SUCCEEDED,
                                SagaStatus.FAILED,SagaStatus.COMPENSATED
                        );
        if (outboxMessagesResponse.isPresent()) {
            List<CodeQuestionsUpdateOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} CodeQuestionsUpdateOutboxMessage for clean-up. The payloads: {}",
                    outboxMessages.size(),
                    outboxMessages.stream().map(CodeQuestionsUpdateOutboxMessage::getPayload)
                            .collect(Collectors.joining("\n")));
            outboxHelper.deleteCodeQuestionsUpdateOutboxMessageByOutboxStatusAndSagaStatus(
                    OutboxStatus.COMPLETED,
                    SagaStatus.SUCCEEDED,
                    SagaStatus.FAILED,
                    SagaStatus.COMPENSATED);
            log.info("{} CodeQuestionsUpdateOutboxMessage deleted!", outboxMessages.size());
        }
    }
}
