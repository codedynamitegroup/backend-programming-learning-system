package com.backend.programming.learning.system.course.service.messaging.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent.CalendarEventUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateEventPayload;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Slf4j
@Component
public class CalendarEventMessagingDataMapper {

    public CalendarEventUpdateResponseAvroModel calendarEventUpdateEventPayloadToCalendarEventUpdateResponseAvroModel(
            String sagaId,
            CalendarEventUpdateEventPayload calendarEventUpdateEventPayload
    ) {
        Instant endTime = calendarEventUpdateEventPayload.getEndTime() != null
                ? calendarEventUpdateEventPayload.getEndTime().toInstant()
                : null;

        return CalendarEventUpdateResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.fromString(sagaId))
                .setCalendarEventId(
                        calendarEventUpdateEventPayload.getCalendarEventId() != null
                                ? UUID.fromString(calendarEventUpdateEventPayload.getCalendarEventId())
                                : null)
                .setUserId(UUID.fromString(calendarEventUpdateEventPayload.getUserId()))
                .setContestId(UUID.fromString(calendarEventUpdateEventPayload.getContestId()))
                .setCourseId(null)
                .setName(calendarEventUpdateEventPayload.getName())
                .setDescription(calendarEventUpdateEventPayload.getDescription())
                .setEventType(NotificationEventType.valueOf(calendarEventUpdateEventPayload.getEventType()))
                .setStartTime(calendarEventUpdateEventPayload.getStartTime().toInstant())
                .setEndTime(endTime)
                .setComponent(NotificationComponentType.valueOf(calendarEventUpdateEventPayload.getComponent()))
                .setUpdateCalendarEventState(UpdateState.valueOf(calendarEventUpdateEventPayload.getUpdateCalendarEventState()))
                .setFailureMessages(calendarEventUpdateEventPayload.getFailureMessages())
                .build();
    }

    public CalendarEventUpdateRequest calendarEventUpdateRequestAvroModelToCalendarEventUpdateRequest(
            CalendarEventUpdateRequestAvroModel calendarEventUpdateRequestAvroModel
    ) {
        ZonedDateTime startTime = ZonedDateTime.ofInstant(calendarEventUpdateRequestAvroModel.getStartTime(), ZoneId.of("UTC"));
        ZonedDateTime endTime = calendarEventUpdateRequestAvroModel.getEndTime() != null
                ? ZonedDateTime.ofInstant(calendarEventUpdateRequestAvroModel.getEndTime(), ZoneId.of("UTC"))
                : null;

        return CalendarEventUpdateRequest.builder()
                .id(calendarEventUpdateRequestAvroModel.getId().toString())
                .sagaId(calendarEventUpdateRequestAvroModel.getSagaId().toString())
                .userId(calendarEventUpdateRequestAvroModel.getUserId().toString())
                .contestId(calendarEventUpdateRequestAvroModel.getContestId().toString())
                .courseId(null)
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
}
