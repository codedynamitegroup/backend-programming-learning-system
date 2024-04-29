package com.backend.programming.learning.system.course.service.messaging.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent.CalendarEventUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.event.calendarevent.CalendarEventUpdatedEvent;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateEventPayload;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.*;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class CalendarEventMessagingDataMapper {

    public CalendarEventUpdateResponseAvroModel calendarEventUpdateEventPayloadToCalendarEventUpdateResponseAvroModel(
            String sagaId,
            CalendarEventUpdateEventPayload calendarEventUpdateEventPayload
    ) {
        return CalendarEventUpdateResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.fromString(sagaId))
                .setCalendarEventId(UUID.fromString(calendarEventUpdateEventPayload.getCalendarEventId()))
                .setUserId(UUID.fromString(calendarEventUpdateEventPayload.getUserId()))
                .setContestId(UUID.fromString(calendarEventUpdateEventPayload.getContestId()))
                .setCourseId(null)
                .setName(calendarEventUpdateEventPayload.getName())
                .setDescription(calendarEventUpdateEventPayload.getDescription())
                .setEventType(NotificationEventType.valueOf(calendarEventUpdateEventPayload.getEventType()))
                .setStartTime(calendarEventUpdateEventPayload.getStartTime().toInstant())
                .setEndTime(calendarEventUpdateEventPayload.getEndTime().toInstant())
                .setComponent(NotificationComponentType.valueOf(calendarEventUpdateEventPayload.getComponent()))
                .setUpdateCalendarEventState(UpdateState.valueOf(calendarEventUpdateEventPayload.getUpdateCalendarEventState()))
                .build();
    }

    public CalendarEventUpdateRequest calendarEventUpdateRequestAvroModelToCalendarEventUpdateRequest(
            CalendarEventUpdateRequestAvroModel calendarEventUpdateRequestAvroModel
    ) {
        ZonedDateTime startTime = ZonedDateTime.ofInstant(calendarEventUpdateRequestAvroModel.getStartTime(), ZoneId.of("UTC"));
        ZonedDateTime endTime = ZonedDateTime.ofInstant(calendarEventUpdateRequestAvroModel.getEndTime(), ZoneId.of("UTC"));

        return CalendarEventUpdateRequest.builder()
                .id(calendarEventUpdateRequestAvroModel.getId().toString())
                .sagaId(calendarEventUpdateRequestAvroModel.getSagaId().toString())
                .userId(calendarEventUpdateRequestAvroModel.getUserId().toString())
                .contestId(calendarEventUpdateRequestAvroModel.getContestId().toString())
                .courseId(calendarEventUpdateRequestAvroModel.getCourseId().toString())
                .name(calendarEventUpdateRequestAvroModel.getName())
                .description(calendarEventUpdateRequestAvroModel.getDescription())
                .eventType(com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType.valueOf(calendarEventUpdateRequestAvroModel.getEventType().name()))
                .startTime(startTime)
                .endTime(endTime)
                .component(
                        com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType.valueOf(
                        calendarEventUpdateRequestAvroModel.getComponent().name()))
                .updateCalendarEventState(
                        com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState.valueOf(
                        calendarEventUpdateRequestAvroModel.getUpdateCalendarEventState().name()))
                .build();
    }


    public CalendarEventUpdateRequest calendarEventUpdatedEventToCalendarEventUpdateRequest(
            CalendarEventUpdatedEvent calendarEventUpdatedEvent
    ) {
        ZonedDateTime startTime = calendarEventUpdatedEvent.getCalendarEvent().getStartTime();
        ZonedDateTime endTime = calendarEventUpdatedEvent.getCalendarEvent().getEndTime();

        return CalendarEventUpdateRequest.builder()
                .id(UUID.randomUUID().toString())
                .sagaId(UUID.randomUUID().toString())
                .userId(calendarEventUpdatedEvent.getCalendarEvent().getUser().getId().getValue().toString())
                .contestId(calendarEventUpdatedEvent.getCalendarEvent().getContestId().toString())
                .courseId(calendarEventUpdatedEvent.getCalendarEvent().getCourseId().toString())
                .name(calendarEventUpdatedEvent.getCalendarEvent().getName())
                .description(calendarEventUpdatedEvent.getCalendarEvent().getDescription())
                .eventType(com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType.valueOf(calendarEventUpdatedEvent.getCalendarEvent().getEventType().name()))
                .startTime(startTime)
                .endTime(endTime)
                .component(
                        com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType.valueOf(
                        calendarEventUpdatedEvent.getCalendarEvent().getComponent().name()))
                .updateCalendarEventState(
                        com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState.valueOf(
                        calendarEventUpdatedEvent.getUpdateCalendarEventState().name()))
                .build();
    }


}
