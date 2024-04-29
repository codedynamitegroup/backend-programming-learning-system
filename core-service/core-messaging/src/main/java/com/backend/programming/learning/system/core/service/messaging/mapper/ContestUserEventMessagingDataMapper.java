package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.contest_user.ContestUserCalendarEventUpdatedResponse;
import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateEventPayload;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class ContestUserEventMessagingDataMapper {
    public CalendarEventUpdateRequestAvroModel contestUserUpdatedEventPayloadToCalendarEventUpdateRequestAvroModel(
            String sagaId,
            ContestUserUpdateEventPayload contestUserUpdateEventPayload) {
        Instant endTime = contestUserUpdateEventPayload.getEndTime() != null
                ? contestUserUpdateEventPayload.getEndTime().toInstant()
                : null;
        return CalendarEventUpdateRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.fromString(sagaId))
                .setUserId(UUID.fromString(contestUserUpdateEventPayload.getUserId()))
                .setContestId(UUID.fromString(contestUserUpdateEventPayload.getContestId()))
                .setCourseId(null)
                .setName(contestUserUpdateEventPayload.getName())
                .setDescription(contestUserUpdateEventPayload.getDescription())
                .setEventType(NotificationEventType.USER)
                .setStartTime(contestUserUpdateEventPayload.getStartTime().toInstant())
                .setEndTime(endTime)
                .setComponent(NotificationComponentType.CONTEST)
                .setUpdateCalendarEventState(UpdateState.valueOf(contestUserUpdateEventPayload.getUpdateCalendarEventState()))
                .build();
    }

    public ContestUserCalendarEventUpdatedResponse calendarEventUpdateResponseAvroModelToCalendarEventUpdateResponse(
            CalendarEventUpdateResponseAvroModel calendarEventUpdateResponseAvroModel) {
        ZonedDateTime startTime = ZonedDateTime.ofInstant(calendarEventUpdateResponseAvroModel.getStartTime(), ZoneId.of("UTC"));
        ZonedDateTime endTime = calendarEventUpdateResponseAvroModel.getEndTime() != null
                ? ZonedDateTime.ofInstant(calendarEventUpdateResponseAvroModel.getEndTime(), ZoneId.of("UTC"))
                : null;
        String calendarEventId = calendarEventUpdateResponseAvroModel.getCalendarEventId() != null
                ? calendarEventUpdateResponseAvroModel.getCalendarEventId().toString()
                : null;

        return ContestUserCalendarEventUpdatedResponse.builder()
                .id(calendarEventUpdateResponseAvroModel.getId().toString())
                .calendarEventId(calendarEventId)
                .sagaId(calendarEventUpdateResponseAvroModel.getSagaId().toString())
                .userId(calendarEventUpdateResponseAvroModel.getUserId().toString())
                .contestId(calendarEventUpdateResponseAvroModel.getContestId().toString())
                .courseId(null)
                .name(calendarEventUpdateResponseAvroModel.getName())
                .description(calendarEventUpdateResponseAvroModel.getDescription())
                .eventType(com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType.valueOf(calendarEventUpdateResponseAvroModel.getEventType().toString()))
                .startTime(startTime)
                .endTime(endTime)
                .component(
                        com.backend.programming.learning.system.core.service.domain.valueobject.
                                NotificationComponentType.valueOf(
                                        calendarEventUpdateResponseAvroModel.getComponent().toString()))
                .updateCalendarEventState(
                        com.backend.programming.learning.system.core.service.domain.valueobject.
                                UpdateState.valueOf(
                                        calendarEventUpdateResponseAvroModel.getUpdateCalendarEventState().toString()))
                .failureMessages(calendarEventUpdateResponseAvroModel.getFailureMessages())
                .build();
    }
}
