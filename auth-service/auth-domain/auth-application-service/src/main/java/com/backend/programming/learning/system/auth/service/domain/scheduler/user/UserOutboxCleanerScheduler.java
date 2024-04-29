package com.backend.programming.learning.system.auth.service.domain.scheduler.user;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserOutboxCleanerScheduler implements OutboxScheduler {
    private final UserOutboxHelper userOutboxHelper;

    public UserOutboxCleanerScheduler(UserOutboxHelper userOutboxHelper) {
        this.userOutboxHelper = userOutboxHelper;
    }

    @Override
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
        Optional<List<UserOutboxMessage>> userOutboxMessagesResponse = userOutboxHelper
                .getUserOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus.COMPLETED,
                        SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
        if (userOutboxMessagesResponse.isPresent()) {
            List<UserOutboxMessage> userOutboxMessages = userOutboxMessagesResponse.get();
            log.info("Received {} UserOutboxMessage for clean-up. The payloads: {}",
                    userOutboxMessages.size(),
                    userOutboxMessages.stream().map(UserOutboxMessage::getPayload)
                            .collect(Collectors.joining("\n")));
            userOutboxHelper.deleteUserOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus.COMPLETED,
                    SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
            log.info("{} UserOutboxMessage deleted!", userOutboxMessages.size());
        }
    }
}
