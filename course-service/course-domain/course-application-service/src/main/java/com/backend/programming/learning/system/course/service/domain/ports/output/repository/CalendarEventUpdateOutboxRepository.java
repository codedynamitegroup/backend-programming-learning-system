package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CalendarEventUpdateOutboxRepository {
    CalendarEventUpdateOutboxMessage save(CalendarEventUpdateOutboxMessage calendarEventUpdateOutboxMessage);

    Optional<CalendarEventUpdateOutboxMessage> findByTypeAndSagaIdAndUpdateCalendarEventState(
            String type,
            UUID sagaId,
            UpdateState updateCalendarEventState);

    Optional<List<CalendarEventUpdateOutboxMessage>> findByTypeAndOutboxStatus(
            String type,
            OutboxStatus outboxStatus);

    void deleteByTypeAndOutboxStatus(
            String type,
            OutboxStatus outboxStatus);
}
