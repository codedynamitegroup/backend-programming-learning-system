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
        Optional<List<UserOutboxMessage>> outboxMessagesResponse =
                userOutboxHelper.getUserOutboxMessageByOutboxStatus(OutboxStatus.COMPLETED);
        if (outboxMessagesResponse.isPresent() && outboxMessagesResponse.get().size() > 0) {
            List<UserOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} UserOutboxMessage for clean-up!", outboxMessages.size());
            userOutboxHelper.deleteUserOutboxMessageByOutboxStatus(OutboxStatus.COMPLETED);
            log.info("Deleted {} UserOutboxMessage!", outboxMessages.size());
        }
    }
}
