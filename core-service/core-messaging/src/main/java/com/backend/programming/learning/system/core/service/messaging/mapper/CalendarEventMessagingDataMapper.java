package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.calendarevent.CalendarEventUpdateResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.event.calendarevent.CalendarEventCreatedEvent;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.*;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class CalendarEventMessagingDataMapper {


    public CalendarEventUpdateRequestAvroModel contestUserCreateEventPayloadToCalendarEventCreateRequestAvroModel(
            CalendarEventCreatedEvent calendarEventCreatedEvent) {
        ContestUser contestUser = calendarEventCreatedEvent.getContestUser();

        return CalendarEventUpdateRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setUserId(contestUser.getUser().getId().getValue())
                .setContestId(contestUser.getContest().getId().getValue())
                .setCourseId(null)
                .setName(contestUser.getContest().getName())
                .setEventType(NotificationEventType.USER)
                .setStartTime(contestUser.getContest().getStartTime().toInstant())
                .setEndTime(contestUser.getContest().getEndTime().toInstant())
                .setComponent(NotificationComponentType.CONTEST)
                .setUpdateCalendarEventState(UpdateState.valueOf(contestUser.getUpdateCalendarEventState().toString()))
                .build();
    }

    public CalendarEventUpdateResponse calendarEventUpdateResponseAvroModelToCalendarEventUpdateResponse(
            CalendarEventUpdateResponseAvroModel calendarEventUpdateResponseAvroModel) {
        ZonedDateTime startTime = ZonedDateTime.ofInstant(calendarEventUpdateResponseAvroModel.getStartTime(), ZoneId.of("UTC"));
        ZonedDateTime endTime = ZonedDateTime.ofInstant(calendarEventUpdateResponseAvroModel.getEndTime(), ZoneId.of("UTC"));

        return CalendarEventUpdateResponse.builder()
                .id(calendarEventUpdateResponseAvroModel.getId().toString())
                .userId(calendarEventUpdateResponseAvroModel.getUserId().toString())
                .contestId(calendarEventUpdateResponseAvroModel.getContestId().toString())
                .courseId(calendarEventUpdateResponseAvroModel.getCourseId().toString())
                .name(calendarEventUpdateResponseAvroModel.getName())
                .eventType(com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType.valueOf(calendarEventUpdateResponseAvroModel.getEventType().toString()))
                .startTime(startTime)
                .endTime(endTime)
                .component(com.backend.programming.learning.system.core.service.domain.valueobject.NotificationComponentType.valueOf(calendarEventUpdateResponseAvroModel.getComponent().toString()))
                .updateCalendarEventState(com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState.valueOf(calendarEventUpdateResponseAvroModel.getUpdateCalendarEventState().toString()))
                .failureMessages(calendarEventUpdateResponseAvroModel.getFailureMessages())
                .build();
    }
}
