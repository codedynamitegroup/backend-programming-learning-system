package com.backend.programming.learning.system.core.service.domain.outbox.scheduler.contest_user;

import com.backend.programming.learning.system.outbox.OutboxScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class ContestUserOutboxCleanerScheduler implements OutboxScheduler {

    private final ContestUserOutboxHelper contestUserOutboxHelper;

    public ContestUserOutboxCleanerScheduler(ContestUserOutboxHelper contestUserOutboxHelper) {
        this.contestUserOutboxHelper = contestUserOutboxHelper;
    }

    @Override
    @Transactional
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
    }
}
