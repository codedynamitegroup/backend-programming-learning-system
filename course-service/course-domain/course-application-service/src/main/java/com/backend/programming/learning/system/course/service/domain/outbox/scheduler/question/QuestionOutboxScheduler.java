package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.question;

import com.backend.programming.learning.system.course.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.QuestionResponseMessagePublisher;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class QuestionOutboxScheduler implements OutboxScheduler {
    private final QuestionOutboxHelper questionOutboxHelper;
    private final QuestionResponseMessagePublisher questionResponseMessagePublisher;

    public QuestionOutboxScheduler(QuestionOutboxHelper questionOutboxHelper,
                                   QuestionResponseMessagePublisher questionResponseMessagePublisher) {
        this.questionOutboxHelper = questionOutboxHelper;
        this.questionResponseMessagePublisher = questionResponseMessagePublisher;
    }

    @Override
    @Transactional
    @Scheduled(fixedDelayString = "${course-service.outbox-scheduler-fixed-rate}",
            initialDelayString = "${course-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<QuestionOutboxMessage>> questionOutboxMessages = questionOutboxHelper
                .getQuestionOutboxMessagesByOutboxStatus(OutboxStatus.STARTED);

        if (questionOutboxMessages.isPresent() && !questionOutboxMessages.get().isEmpty()) {
            List<QuestionOutboxMessage> questionOutboxMessageList = questionOutboxMessages.get();

            log.info("Received {} question outbox messages with ids: {}, sending to message bus", questionOutboxMessageList.size(),
                    questionOutboxMessageList
                            .stream()
                            .map(QuestionOutboxMessage::getId)
                            .collect(Collectors.toList()));

            // publish each question outbox message to message bus
            questionOutboxMessageList.forEach(questionOutboxMessage -> questionResponseMessagePublisher.publish(questionOutboxMessage, this::updateOutboxStatus));

            log.info("{} question outbox messages have been sent to message bus", questionOutboxMessageList.size());
        }
    }

    private void updateOutboxStatus(QuestionOutboxMessage questionOutboxMessage, OutboxStatus outboxStatus) {
        questionOutboxMessage.setOutboxStatus(outboxStatus);
        questionOutboxHelper.saveQuestionOutboxMessage(questionOutboxMessage);

        log.info("Question outbox message with id: {} has been updated with status: {}", questionOutboxMessage.getId(), outboxStatus);
    }
}
