package com.backend.programming.learning.system.course.service.domain.outbox.scheduler;

import com.backend.programming.learning.system.outbox.OutboxScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class CalendarEventOutboxCleanerScheduler implements OutboxScheduler {

    private final CalendarEventOutboxHelper calendarEventOutboxHelper;

    public CalendarEventOutboxCleanerScheduler(CalendarEventOutboxHelper calendarEventOutboxHelper) {
        this.calendarEventOutboxHelper = calendarEventOutboxHelper;
    }

    @Override
    @Transactional
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
    }
}
