package com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.calendarevent;

import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface CalendarEventUpdatedMessagePublisher {
    void publish(CalendarEventUpdateOutboxMessage calendarEventUpdateOutboxMessage,
                 BiConsumer<CalendarEventUpdateOutboxMessage, OutboxStatus> outboxCallback);
}
