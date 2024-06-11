package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.user;

import com.backend.programming.learning.system.course.service.domain.outbox.model.user.UserOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.backend.programming.learning.system.saga.user.SagaConstants.AUTH_TO_ANY_SERVICES_USER_SAGA_NAME;
import static com.backend.programming.learning.system.saga.user.SagaConstants.COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME;

@Slf4j
@Component
public class UserOutboxCleaner implements OutboxScheduler {
    private final UserOutboxHelper userOutboxHelper;

    public UserOutboxCleaner(UserOutboxHelper userOutboxHelper) {
        this.userOutboxHelper = userOutboxHelper;
    }

    @Override
    @Scheduled(cron = "@midnight")
    @Transactional
    public void processOutboxMessage() {
        Optional<List<UserOutboxMessage>> outboxMessagesResponseAuthToAnyServices =
                userOutboxHelper.getUserOutboxMessageByOutboxStatus(AUTH_TO_ANY_SERVICES_USER_SAGA_NAME, OutboxStatus.COMPLETED);
        if (outboxMessagesResponseAuthToAnyServices.isPresent() && outboxMessagesResponseAuthToAnyServices.get().size() > 0) {
            List<UserOutboxMessage> outboxMessages = outboxMessagesResponseAuthToAnyServices.get();
            log.info("Received {} UserOutboxMessage for clean-up!", outboxMessages.size());
            userOutboxHelper.deleteUserOutboxMessageByOutboxStatus(AUTH_TO_ANY_SERVICES_USER_SAGA_NAME, OutboxStatus.COMPLETED);
            log.info("Deleted {} UserOutboxMessage!", outboxMessages.size());
        }

        Optional<List<UserOutboxMessage>> outboxMessagesResponseCourseToAuthService =
                userOutboxHelper.getUserOutboxMessageByOutboxStatus(COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME, OutboxStatus.COMPLETED);
        if (outboxMessagesResponseCourseToAuthService.isPresent() && outboxMessagesResponseCourseToAuthService.get().size() > 0) {
            List<UserOutboxMessage> outboxMessages = outboxMessagesResponseCourseToAuthService.get();
            log.info("Received {} UserOutboxMessage for clean-up!", outboxMessages.size());
            userOutboxHelper.deleteUserOutboxMessageByOutboxStatus(COURSE_TO_AUTH_SERVICE_USER_SAGA_NAME, OutboxStatus.COMPLETED);
            log.info("Deleted {} UserOutboxMessage!", outboxMessages.size());
        }
    }
}
