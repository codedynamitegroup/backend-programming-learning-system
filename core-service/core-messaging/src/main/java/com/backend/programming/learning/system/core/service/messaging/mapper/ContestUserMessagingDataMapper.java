package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserCreateEventPayload;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.CalendarEventUpdateRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.NotificationComponentType;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.NotificationEventType;
import com.backend.programming.learning.system.kafka.core.calendar.event.avro.model.UpdateState;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class ContestUserMessagingDataMapper {


    public CalendarEventUpdateRequestAvroModel contestUserCreateEventPayloadToCalendarEventCreateRequestAvroModel(
            UUID sagaId, ContestUserCreateEventPayload contestUserCreateEventPayload) {
        Contest contest = contestUserCreateEventPayload.getContestUser().getContest();
        User user = contestUserCreateEventPayload.getContestUser().getUser();
        Instant startTime = contest.getStartTime().toInstant();
        Instant endTime = contest.getEndTime().toInstant();

        return CalendarEventUpdateRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(sagaId)
                .setUserId(user.getId().getValue())
                .setCourseId(null)
                .setName(contest.getName())
                .setEventType(NotificationEventType.USER)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setComponent(NotificationComponentType.CONTEST)
                .setUpdateState(UpdateState.CREATING)
                .build();
    }
}
