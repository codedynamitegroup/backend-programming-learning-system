package com.backend.programming.learning.system.course.service.domain.mapper.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent.CalendarEventUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.calendarevent.CalendarEventResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateEventPayload;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CalendarEventDataMapper {
    private final UserDataMapper userDataMapper;

    public CalendarEventDataMapper(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public CreateCalendarEventResponse calendarEventToCreateCalendarEventResponse(
            CalendarEvent calendarEvent, String message) {
        return CreateCalendarEventResponse.builder()
                .calendarEventId(calendarEvent.getId().getValue())
                .message(message)
                .build();
    }

    public CalendarEvent createCalendarEventCommandToCalendarEvent(CreateCalendarEventCommand createCalendarEventCommand) {
        return CalendarEvent.builder()
                .name(createCalendarEventCommand.getName())
                .description(createCalendarEventCommand.getDescription())
                .eventType(NotificationEventType.valueOf(createCalendarEventCommand.getEventType()))
                .startTime(createCalendarEventCommand.getStartTime())
                .endTime(createCalendarEventCommand.getEndTime())
                .user(User.builder()
                    .id(new UserId(createCalendarEventCommand.getUserId()))
                    .build())
                .courseId(createCalendarEventCommand.getCourseId())
                .contestId(createCalendarEventCommand.getContestId())
                .component(NotificationComponentType.valueOf(createCalendarEventCommand.getComponent()))
                .isStartTimeNotified(false)
                .isEndTimeNotified(false)
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    public CalendarEventResponseEntity calendarEventToCalendarEventResponseEntity(CalendarEvent calendarEvent) {
        return CalendarEventResponseEntity.builder()
                .calendarEventId(calendarEvent.getId().getValue())
                .user(userDataMapper.userToUserResponseEntity(calendarEvent.getUser()))
                .name(calendarEvent.getName())
                .description(calendarEvent.getDescription())
                .eventType(NotificationEventType.valueOf(calendarEvent.getEventType().name()))
                .startTime(calendarEvent.getStartTime())
                .endTime(calendarEvent.getEndTime())
                .courseId(calendarEvent.getCourseId())
                .contestId(calendarEvent.getContestId())
                .component(calendarEvent.getComponent())
                .isStartTimeNotified(calendarEvent.getStartTimeNotified())
                .isEndTimeNotified(calendarEvent.getEndTimeNotified())
                .createdAt(calendarEvent.getCreatedAt())
                .build();
    }

    public QueryAllCalendarEventsResponse calendarEventsToQueryAllCalendarEventsResponse(List<CalendarEvent> calendarEvents) {
        List<CalendarEventResponseEntity> calendarEventResponseEntities = new ArrayList<>();
        for (CalendarEvent calendarEvent : calendarEvents) {
            calendarEventResponseEntities.add(calendarEventToCalendarEventResponseEntity(calendarEvent));
        }
        return QueryAllCalendarEventsResponse.builder()
                .calendarEvents(calendarEventResponseEntities)
                .build();
    }

    public CalendarEvent calendarEventUpdateRequestModelToCalendarEvent(CalendarEventUpdateRequest calendarEventUpdateRequest) {
        return CalendarEvent.builder()
                .name(calendarEventUpdateRequest.getName())
                .description(calendarEventUpdateRequest.getDescription())
                .eventType(NotificationEventType.valueOf(String.valueOf(calendarEventUpdateRequest.getEventType())))
                .startTime(calendarEventUpdateRequest.getStartTime())
                .endTime(calendarEventUpdateRequest.getEndTime())
                .user(User.builder()
                        .id(new UserId(UUID.fromString(calendarEventUpdateRequest.getUserId())))
                        .build())
                .courseId(null)
                .contestId(UUID.fromString(calendarEventUpdateRequest.getContestId()))
                .component(NotificationComponentType.valueOf(String.valueOf(calendarEventUpdateRequest.getComponent())))
                .isStartTimeNotified(false)
                .isEndTimeNotified(false)
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    public CalendarEventUpdateEventPayload calendarEventUpdateRequestToCalendarEventUpdateEventPayload(
            String calendarEventId,
            CalendarEventUpdateRequest calendarEventUpdateRequest,
            String updateCalendarEventState,
            List<String> failureMessages) {
        CalendarEvent calendarEvent = calendarEventUpdateRequestModelToCalendarEvent(calendarEventUpdateRequest);

        return CalendarEventUpdateEventPayload.builder()
                .calendarEventId(calendarEventId)
                .name(calendarEvent.getName())
                .description(calendarEvent.getDescription())
                .eventType(calendarEvent.getEventType().name())
                .startTime(calendarEvent.getStartTime())
                .endTime(calendarEvent.getEndTime())
                .userId(calendarEvent.getUser().getId().getValue().toString())
                .contestId(calendarEvent.getContestId().toString())
                .component(calendarEvent.getComponent().name())
                .updateCalendarEventState(updateCalendarEventState)
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .failureMessages(failureMessages)
                .build();
    }
}
