package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.user;

import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.user.UserRequestMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.user.UserResponseMessagePublisher;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserOutboxScheduler implements OutboxScheduler {
    private final UserOutboxHelper userOutboxHelper;
    private final UserRequestMessagePublisher userRequestMessagePublisher;

    @Override
    @Transactional
    @Scheduled(fixedRateString = "${course-service.outbox-scheduler-fixed-rate}",
    initialDelayString = "${course-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<UserOutboxMessage>> userOutboxMessages =
                userOutboxHelper.getUserOutboxMessageByOutboxStatus(OutboxStatus.STARTED);
        if (userOutboxMessages.isPresent() && userOutboxMessages.get().size() > 0) {
            List<UserOutboxMessage> outboxMessages = userOutboxMessages.get();
            log.info("Received {} UserOutboxMessage with ids {}, sending to kafka!", outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(userOutboxMessage -> {
                userRequestMessagePublisher.publish(userOutboxMessage, userOutboxHelper::updateOutboxMessage);
            });
            log.info("{} UserOutboxMessage sent to message bus!", outboxMessages.size());
        }
    }
}
