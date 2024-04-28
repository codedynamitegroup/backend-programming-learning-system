package com.backend.programming.learning.system.core.service.domain.outbox.scheduler.contest_user;

import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.contest_user.ContestUserUpdatedMessagePublisher;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class ContestUserOutboxScheduler implements OutboxScheduler {

    private final ContestUserOutboxHelper contestUserOutboxHelper;
    private final ContestUserUpdatedMessagePublisher contestUserUpdatedMessagePublisher;

    public ContestUserOutboxScheduler(ContestUserOutboxHelper contestUserOutboxHelper,
                                      ContestUserUpdatedMessagePublisher contestUserUpdatedMessagePublisher) {
        this.contestUserOutboxHelper = contestUserOutboxHelper;
        this.contestUserUpdatedMessagePublisher = contestUserUpdatedMessagePublisher;
    }

    @Override
    @Transactional
    @Scheduled(fixedRateString = "${course-service.outbox-scheduler-fixed-rate}",
            initialDelayString = "${course-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
    }

}
