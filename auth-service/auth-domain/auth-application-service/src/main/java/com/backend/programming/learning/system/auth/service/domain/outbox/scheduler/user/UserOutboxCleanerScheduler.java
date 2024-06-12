package com.backend.programming.learning.system.auth.service.domain.outbox.scheduler.user;

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

import static com.backend.programming.learning.system.saga.user.SagaConstants.AUTH_TO_ANY_SERVICES_USER_SAGA_NAME;
import static com.backend.programming.learning.system.saga.user.SagaConstants.COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME;

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
        Optional<List<UserOutboxMessage>> userOutboxMessagesAuthToAnyServicesResponse = userOutboxHelper
                .getUserOutboxMessageByOutboxStatusAndSagaStatus(AUTH_TO_ANY_SERVICES_USER_SAGA_NAME, OutboxStatus.COMPLETED,
                        SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
        if (userOutboxMessagesAuthToAnyServicesResponse.isPresent()) {
            List<UserOutboxMessage> userOutboxMessages = userOutboxMessagesAuthToAnyServicesResponse.get();
            log.info("Received {} UserOutboxMessage for clean-up. The payloads: {}",
                    userOutboxMessages.size(),
                    userOutboxMessages.stream().map(UserOutboxMessage::getPayload)
                            .collect(Collectors.joining("\n")));
            userOutboxHelper.deleteUserOutboxMessageByOutboxStatusAndSagaStatus(AUTH_TO_ANY_SERVICES_USER_SAGA_NAME, OutboxStatus.COMPLETED,
                    SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
            log.info("{} UserOutboxMessage deleted!", userOutboxMessages.size());
        }

        Optional<List<UserOutboxMessage>> userOutboxMessagesCourseToAuthServiceResponse = userOutboxHelper
                .getUserOutboxMessageByOutboxStatusAndSagaStatus(COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME, OutboxStatus.COMPLETED,
                        SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
        if (userOutboxMessagesCourseToAuthServiceResponse.isPresent()) {
            List<UserOutboxMessage> userOutboxMessages = userOutboxMessagesCourseToAuthServiceResponse.get();
            log.info("Received {} UserOutboxMessage for clean-up. The payloads: {}",
                    userOutboxMessages.size(),
                    userOutboxMessages.stream().map(UserOutboxMessage::getPayload)
                            .collect(Collectors.joining("\n")));
            userOutboxHelper.deleteUserOutboxMessageByOutboxStatusAndSagaStatus(COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME, OutboxStatus.COMPLETED,
                    SagaStatus.SUCCEEDED, SagaStatus.FAILED, SagaStatus.COMPENSATED);
            log.info("{} UserOutboxMessage deleted!", userOutboxMessages.size());
        }
    }
}
