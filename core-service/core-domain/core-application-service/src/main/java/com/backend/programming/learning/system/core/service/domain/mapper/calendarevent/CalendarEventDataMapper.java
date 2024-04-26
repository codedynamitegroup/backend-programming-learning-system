package com.backend.programming.learning.system.core.service.domain.mapper.calendarevent;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.calendarevent.CalendarEventResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.topic.TopicDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.*;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

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
                .component(NotificationComponentType.valueOf(createCalendarEventCommand.getComponent()))
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
                .component(calendarEvent.getComponent().name())
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

}
