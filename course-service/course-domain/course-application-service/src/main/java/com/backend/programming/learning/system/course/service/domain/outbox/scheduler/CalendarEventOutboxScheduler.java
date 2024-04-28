package com.backend.programming.learning.system.course.service.domain.outbox.scheduler;

import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.calendarevent.CalendarEventUpdatedMessagePublisher;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Slf4j
@Component
public class CalendarEventOutboxScheduler implements OutboxScheduler {

    private final CalendarEventOutboxHelper calendarEventOutboxHelper;
    private final CalendarEventUpdatedMessagePublisher calendarEventUpdatedMessagePublisher;

    public CalendarEventOutboxScheduler(CalendarEventOutboxHelper calendarEventOutboxHelper,
                                        CalendarEventUpdatedMessagePublisher calendarEventUpdatedMessagePublisher) {
        this.calendarEventOutboxHelper = calendarEventOutboxHelper;
        this.calendarEventUpdatedMessagePublisher = calendarEventUpdatedMessagePublisher;
    }

    @Override
    @Transactional
    @Scheduled(fixedRateString = "${course-service.outbox-scheduler-fixed-rate}",
            initialDelayString = "${course-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
    }

}
