package com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.question;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class QuestionOutboxCleanerScheduler implements OutboxScheduler {
    private final QuestionOutboxHelper questionOutboxHelper;

    public QuestionOutboxCleanerScheduler(QuestionOutboxHelper questionOutboxHelper) {
        this.questionOutboxHelper = questionOutboxHelper;
    }

    @Override
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
        Optional<List<QuestionOutboxMessage>> questionOutboxMessages = questionOutboxHelper
                .getQuestionOutboxMessagesByOutboxStatus(OutboxStatus.COMPLETED);

        if (questionOutboxMessages.isPresent()) {
            List<QuestionOutboxMessage> questionOutboxMessageList = questionOutboxMessages.get();

            log.info("Received {} question outbox messages for clean up. The payloads: {}",
                    questionOutboxMessageList.size(),
                    questionOutboxMessageList
                            .stream()
                            .map(QuestionOutboxMessage::getPayload)
                            .collect(Collectors.joining("\n")));

            questionOutboxHelper.deleteByOutboxStatus(
                    OutboxStatus.COMPLETED);
            log.info("Cleaned up {} question outbox messages", questionOutboxMessageList.size());
        }
    }
}
