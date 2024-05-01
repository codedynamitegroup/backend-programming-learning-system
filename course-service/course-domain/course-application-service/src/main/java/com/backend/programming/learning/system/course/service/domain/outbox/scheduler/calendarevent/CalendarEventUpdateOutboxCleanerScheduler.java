package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.calendarevent;

import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxScheduler;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CalendarEventUpdateOutboxCleanerScheduler implements OutboxScheduler {

    private final CalendarEventUpdateOutboxHelper calendarEventUpdateOutboxHelper;

    public CalendarEventUpdateOutboxCleanerScheduler(CalendarEventUpdateOutboxHelper calendarEventUpdateOutboxHelper) {
        this.calendarEventUpdateOutboxHelper = calendarEventUpdateOutboxHelper;
    }

    @Override
    @Transactional
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
        Optional<List<CalendarEventUpdateOutboxMessage>> outboxMessagesResponse =
                calendarEventUpdateOutboxHelper.getCalendarEventUpdateOutboxMessageByOutboxStatus(
                        OutboxStatus.COMPLETED);

        if (outboxMessagesResponse.isPresent()) {
            List<CalendarEventUpdateOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} CalendarEventUpdateOutboxMessage for clean-up. The payloads: {}",
                    outboxMessages.size(),
                    outboxMessages.stream().map(CalendarEventUpdateOutboxMessage::getPayload)
                            .collect(Collectors.joining("\n")));
            calendarEventUpdateOutboxHelper.deleteCalendarEventUpdateOutboxMessageByOutboxStatus(
                    OutboxStatus.COMPLETED);
            log.info("{} CalendarEventUpdateOutboxMessage deleted!", outboxMessages.size());
        }
    }
}
