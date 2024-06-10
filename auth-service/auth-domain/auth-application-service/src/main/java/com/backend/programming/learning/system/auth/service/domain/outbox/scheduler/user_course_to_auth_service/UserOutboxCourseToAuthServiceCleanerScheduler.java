package com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user_course_to_auth_service;

import com.backend.programming.learning.system.auth.service.domain.outbox.model.user_course_to_auth_service.UserOutboxCourseToAuthServiceMessage;
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
public class UserOutboxCourseToAuthServiceCleanerScheduler implements OutboxScheduler {
    private final UserOutboxCourseToAuthServiceHelper userOutboxHelper;

    public UserOutboxCourseToAuthServiceCleanerScheduler(UserOutboxCourseToAuthServiceHelper userOutboxHelper) {
        this.userOutboxHelper = userOutboxHelper;
    }

    @Override
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
        Optional<List<UserOutboxCourseToAuthServiceMessage>> userOutboxMessagesResponse = userOutboxHelper
                .getUserOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus.COMPLETED,
                        SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
        if (userOutboxMessagesResponse.isPresent()) {
            List<UserOutboxCourseToAuthServiceMessage> userOutboxMessages = userOutboxMessagesResponse.get();
            log.info("Received {} UserOutboxMessage for clean-up. The payloads: {}",
                    userOutboxMessages.size(),
                    userOutboxMessages.stream().map(UserOutboxCourseToAuthServiceMessage::getPayload)
                            .collect(Collectors.joining("\n")));
            userOutboxHelper.deleteUserOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus.COMPLETED,
                    SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
            log.info("{} UserOutboxMessage deleted!", userOutboxMessages.size());
        }
    }
}
