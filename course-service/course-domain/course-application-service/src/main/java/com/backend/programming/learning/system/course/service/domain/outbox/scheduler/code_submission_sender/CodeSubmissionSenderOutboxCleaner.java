package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.code_submission_sender;

import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionSenderOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class CodeSubmissionSenderOutboxCleaner implements OutboxScheduler {
    private final CodeSubmissionSenderOutboxHelper outboxHelper;

    @Override
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
        Optional<List<CodeSubmissionSenderOutboxMessage>> outboxMessages = outboxHelper
                .getMessagesByOutboxStatus(OutboxStatus.COMPLETED);

        if (outboxMessages.isPresent() && !outboxMessages.get().isEmpty()) {
            List<CodeSubmissionSenderOutboxMessage> outboxMessageList = outboxMessages.get();

            log.info("Received {} code submission sender outbox messages for clean up. The payloads: {}",
                    outboxMessageList.size(),
                    outboxMessageList
                            .stream()
                            .map(CodeSubmissionSenderOutboxMessage::getPayload)
                            .collect(Collectors.joining("\n")));

            outboxHelper.deleteByOutboxStatus(OutboxStatus.COMPLETED);
            log.info("Cleaned up {} code submission sender outbox messages", outboxMessageList.size());
        }
    }
}
