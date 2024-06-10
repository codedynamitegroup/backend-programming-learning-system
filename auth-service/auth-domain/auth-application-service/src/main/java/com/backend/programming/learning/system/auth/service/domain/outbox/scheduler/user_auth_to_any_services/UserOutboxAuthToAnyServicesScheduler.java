package com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user_auth_to_any_services;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_auth_to_any_services.UserOutboxAuthToAnyServicesMessage;
import com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user.UserRequestAuthToAnyServicesMessagePublisher;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
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
public class UserOutboxAuthToAnyServicesScheduler implements OutboxScheduler {
    private final UserOutboxAuthToAnyServicesHelper userOutboxHelper;
    private final UserRequestAuthToAnyServicesMessagePublisher userResponseMessagePublisher;

    @Override
    @Transactional
    @Scheduled(fixedRateString = "${auth-service.outbox-scheduler-fixed-rate}",
            initialDelayString = "${auth-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<UserOutboxAuthToAnyServicesMessage>> userOutboxMessages =
                userOutboxHelper.getUserOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus.STARTED,
                        SagaStatus.STARTED, SagaStatus.COMPENSATING);
        if (userOutboxMessages.isPresent() && userOutboxMessages.get().size() > 0) {
            List<UserOutboxAuthToAnyServicesMessage> outboxMessages = userOutboxMessages.get();
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
