package com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user_auth_to_any_services;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_auth_to_any_services.UserOutboxAuthToAnyServicesMessage;
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
public class UserOutboxAuthToAnyServicesCleanerScheduler implements OutboxScheduler {
    private final UserOutboxAuthToAnyServicesHelper userOutboxHelper;

    public UserOutboxAuthToAnyServicesCleanerScheduler(UserOutboxAuthToAnyServicesHelper userOutboxHelper) {
        this.userOutboxHelper = userOutboxHelper;
    }

    @Override
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
        Optional<List<UserOutboxAuthToAnyServicesMessage>> userOutboxMessagesResponse = userOutboxHelper
                .getUserOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus.COMPLETED,
                        SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
        if (userOutboxMessagesResponse.isPresent()) {
            List<UserOutboxAuthToAnyServicesMessage> userOutboxMessages = userOutboxMessagesResponse.get();
            log.info("Received {} UserOutboxMessage for clean-up. The payloads: {}",
                    userOutboxMessages.size(),
                    userOutboxMessages.stream().map(UserOutboxAuthToAnyServicesMessage::getPayload)
                            .collect(Collectors.joining("\n")));
            userOutboxHelper.deleteUserOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus.COMPLETED,
                    SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
            log.info("{} UserOutboxMessage deleted!", userOutboxMessages.size());
        }
    }
}
