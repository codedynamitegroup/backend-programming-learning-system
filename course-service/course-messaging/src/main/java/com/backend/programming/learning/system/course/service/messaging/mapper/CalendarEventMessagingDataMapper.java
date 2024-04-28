package com.backend.programming.learning.system.course.service.messaging.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent.CalendarEventUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.event.calendarevent.CalendarEventUpdatedEvent;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.*;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class CalendarEventMessagingDataMapper {

    public CalendarEventUpdateResponseAvroModel calendarEventUpdateEventToCalendarEventUpdateResponseAvroModel(
            CalendarEventUpdatedEvent calendarEventUpdatedEvent
    ) {
        ZonedDateTime startTime = calendarEventUpdatedEvent.getCalendarEvent().getStartTime();
        ZonedDateTime endTime = calendarEventUpdatedEvent.getCalendarEvent().getEndTime();

        return CalendarEventUpdateResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.randomUUID())
                .setCalendarEventId(calendarEventUpdatedEvent.getCalendarEvent().getId().getValue())
                .setUserId(calendarEventUpdatedEvent.getCalendarEvent().getUser().getId().getValue())
                .setCourseId(calendarEventUpdatedEvent.getCalendarEvent().getCourseId())
                .setContestId(calendarEventUpdatedEvent.getCalendarEvent().getContestId())
                .setName(calendarEventUpdatedEvent.getCalendarEvent().getName())
                .setDescription(calendarEventUpdatedEvent.getCalendarEvent().getDescription())
                .setEventType(NotificationEventType.valueOf(calendarEventUpdatedEvent.getCalendarEvent().getEventType().name()))
                .setStartTime(startTime.toInstant())
                .setEndTime(endTime.toInstant())
                .setComponent(NotificationComponentType.valueOf(
                        calendarEventUpdatedEvent.getCalendarEvent().getComponent().name()))
                .setUpdateCalendarEventState(UpdateState.valueOf(
                        calendarEventUpdatedEvent.getUpdateCalendarEventState().name()))
                .setFailureMessages(calendarEventUpdatedEvent.getFailureMessages())
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
