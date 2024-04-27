package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.event.calendarevent.CalendarEventCreatedEvent;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.CalendarEventUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.NotificationComponentType;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.NotificationEventType;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.UpdateState;
import org.springframework.stereotype.Component;

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
}
