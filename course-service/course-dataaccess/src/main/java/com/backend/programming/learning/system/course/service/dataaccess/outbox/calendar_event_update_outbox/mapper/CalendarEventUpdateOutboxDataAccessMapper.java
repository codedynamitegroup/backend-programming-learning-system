package com.backend.programming.learning.system.course.service.dataaccess.outbox.calendar_event_update_outbox.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.outbox.calendar_event_update_outbox.entity.CalendarEventUpdateOutboxEntity;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateOutboxMessage;
import org.springframework.stereotype.Component;

@Component
public class CalendarEventUpdateOutboxDataAccessMapper {
    public CalendarEventUpdateOutboxEntity calendarEventUpdateOutboxMessageToCalendarEventUpdateOutboxEntity(
            CalendarEventUpdateOutboxMessage calendarEventUpdateOutboxMessage) {
        return CalendarEventUpdateOutboxEntity.builder()
                .id(calendarEventUpdateOutboxMessage.getId())
                .sagaId(calendarEventUpdateOutboxMessage.getSagaId())
                .createdAt(calendarEventUpdateOutboxMessage.getCreatedAt())
                .type(calendarEventUpdateOutboxMessage.getType())
                .payload(calendarEventUpdateOutboxMessage.getPayload())
                .updateCalendarEventState(calendarEventUpdateOutboxMessage.getUpdateCalendarEventState())
                .sagaStatus(calendarEventUpdateOutboxMessage.getSagaStatus())
                .outboxStatus(calendarEventUpdateOutboxMessage.getOutboxStatus())
                .version(calendarEventUpdateOutboxMessage.getVersion())
                .build();
    }

    public CalendarEventUpdateOutboxMessage calendarEventUpdateOutboxEntityToCalendarEventUpdateOutboxMessage(
            CalendarEventUpdateOutboxEntity calendarEventUpdateOutboxEntity) {
        return CalendarEventUpdateOutboxMessage.builder()
                .id(calendarEventUpdateOutboxEntity.getId())
                .sagaId(calendarEventUpdateOutboxEntity.getSagaId())
                .createdAt(calendarEventUpdateOutboxEntity.getCreatedAt())
                .processedAt(calendarEventUpdateOutboxEntity.getProcessedAt())
                .type(calendarEventUpdateOutboxEntity.getType())
                .payload(calendarEventUpdateOutboxEntity.getPayload())
                .updateCalendarEventState(calendarEventUpdateOutboxEntity.getUpdateCalendarEventState())
                .sagaStatus(calendarEventUpdateOutboxEntity.getSagaStatus())
                .outboxStatus(calendarEventUpdateOutboxEntity.getOutboxStatus())
                .version(calendarEventUpdateOutboxEntity.getVersion())
                .build();
    }
}
