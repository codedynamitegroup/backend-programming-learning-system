package com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_submission_update_outbox;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdateOutboxMessage;
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
public class CodeSubmissionUpdateOutboxCleanerScheduler implements OutboxScheduler {
    final CodeSubmissionUpdateOutboxHelper outboxHelper;

    public CodeSubmissionUpdateOutboxCleanerScheduler(CodeSubmissionUpdateOutboxHelper outboxHelper) {
        this.outboxHelper = outboxHelper;
    }

    @Override
    @Transactional
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
        Optional<List<CodeSubmissionUpdateOutboxMessage>> outboxMessagesResponse =
                outboxHelper.getCodeSubmissionUpdateOutboxMessageByOutboxStatusAndSagaStatus(
                        OutboxStatus.COMPLETED,
                        SagaStatus.SUCCEEDED,
                        SagaStatus.FAILED,SagaStatus.COMPENSATED
                );
        if (outboxMessagesResponse.isPresent()) {
            List<CodeSubmissionUpdateOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} CodeSubmissionUpdateOutboxMessage for clean-up. The payloads: {}",
                    outboxMessages.size(),
                    outboxMessages.stream().map(CodeSubmissionUpdateOutboxMessage::getPayload)
                            .collect(Collectors.joining("\n")));
            outboxHelper.deleteCodeSubmissionUpdateOutboxMessageByOutboxStatusAndSagaStatus(
                    OutboxStatus.COMPLETED,
                    SagaStatus.SUCCEEDED,
                    SagaStatus.FAILED,
                    SagaStatus.COMPENSATED);
            log.info("{} CodeSubmissionUpdateOutboxMessage deleted!", outboxMessages.size());
        }
    }
}
