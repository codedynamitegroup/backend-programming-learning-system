package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.code_submission_sender;

import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionSenderOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.code_submission_sender.CodeSubmissionSenderMessagePublisher;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class CodeSubmissionSenderOutboxScheduler implements OutboxScheduler {
    private final CodeSubmissionSenderMessagePublisher publisher;
    private final CodeSubmissionSenderOutboxHelper outboxHelper;
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Scheduled(fixedDelayString = "${course-service.outbox-scheduler-fixed-rate}",
            initialDelayString = "${course-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<CodeSubmissionSenderOutboxMessage>> outboxMessages = outboxHelper
                .getMessagesByOutboxStatus(OutboxStatus.STARTED);

        if (outboxMessages.isPresent() && !outboxMessages.get().isEmpty()) {
            List<CodeSubmissionSenderOutboxMessage> outboxMessageList = outboxMessages.get();

            log.info("Received {} code submission sender outbox messages with ids: {}, sending to message bus", outboxMessageList.size(),
                    outboxMessageList
                            .stream()
                            .map(CodeSubmissionSenderOutboxMessage::getId)
                            .collect(Collectors.toList()));

            // publish each submission outbox message to message bus
            outboxMessageList.forEach(outboxMessage -> publisher.publish(outboxMessage, this::updateOutboxStatus));

            log.info("{} question outbox messages have been sent to message bus", outboxMessageList.size());
        }
    }

    private void updateOutboxStatus(CodeSubmissionSenderOutboxMessage outboxMessage, OutboxStatus outboxStatus) {
        outboxMessage.setOutboxStatus(outboxStatus);
        outboxMessage.setProcessedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        outboxHelper.saveOutboxMessage(outboxMessage);

        log.info("code submission sender outbox message with id: {} has been updated with status: {}", outboxMessage.getId(), outboxStatus);
    }
}
