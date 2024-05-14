package com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserResponseMessagePublisher;
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
    private final UserResponseMessagePublisher userResponseMessagePublisher;

    @Override
    @Transactional
    @Scheduled(fixedRateString = "${auth-service.outbox-scheduler-fixed-rate}",
            initialDelayString = "${auth-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<UserOutboxMessage>> userOutboxMessages =
                userOutboxHelper.getUserOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus.STARTED);
        if (userOutboxMessages.isPresent() && userOutboxMessages.get().size() > 0) {
            List<UserOutboxMessage> outboxMessages = userOutboxMessages.get();
            log.info("Received {} UserOutboxMessage with ids {}, sending to kafka!", outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(userOutboxMessage -> {
                userResponseMessagePublisher.publish(userOutboxMessage, userOutboxHelper::updateOutboxMessage);
            });
            log.info("{} UserOutboxMessage sent to message bus!", outboxMessages.size());
        }
    }
}
