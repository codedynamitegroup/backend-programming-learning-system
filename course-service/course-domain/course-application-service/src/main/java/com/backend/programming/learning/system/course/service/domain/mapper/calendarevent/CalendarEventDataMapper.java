package com.backend.programming.learning.system.course.service.domain.mapper.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent.CalendarEventUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.calendarevent.CalendarEventResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.mapper.assignment.AssignmentDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.course.CourseDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.exam.ExamDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateEventPayload;
import com.backend.programming.learning.system.course.service.domain.valueobject.*;
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
    private final AssignmentDataMapper assignmentDataMapper;
    private final ExamDataMapper examDataMapper;
    private final CourseDataMapper courseDataMapper;

    public CalendarEventDataMapper(UserDataMapper userDataMapper,
                                   AssignmentDataMapper assignmentDataMapper,
                                   ExamDataMapper examDataMapper,
                                   CourseDataMapper courseDataMapper) {
        this.userDataMapper = userDataMapper;
        this.assignmentDataMapper = assignmentDataMapper;
        this.examDataMapper = examDataMapper;
        this.courseDataMapper = courseDataMapper;
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
                .user(createCalendarEventCommand.getUserId() != null
                                ? User.builder()
                                .id(new UserId(createCalendarEventCommand.getUserId()))
                                .build()
                                : null
                )
                .course(
                        createCalendarEventCommand.getCourseId() != null
                                ? Course.builder()
                                    .id(new CourseId(createCalendarEventCommand.getCourseId()))
                                    .build()
                                : null
                )
                .contestId(createCalendarEventCommand.getContestId())
                .exam(createCalendarEventCommand.getExamId() != null
                                ? Exam.builder()
                                .id(new ExamId(createCalendarEventCommand.getExamId()))
                                .build()
                                : null
                )
                .assignment(
                        createCalendarEventCommand.getAssignmentId() != null
                                ? Assignment.builder()
                                .id(new AssignmentId(createCalendarEventCommand.getAssignmentId()))
                                .build()
                                : null
                )
                .component(NotificationComponentType.valueOf(createCalendarEventCommand.getComponent()))
                .notificationNotifyTime(null)
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    public CalendarEventResponseEntity calendarEventToCalendarEventResponseEntity(CalendarEvent calendarEvent) {
        CourseResponseEntity courseResponseEntity = calendarEvent.getCourse() != null
                ? courseDataMapper.courseToQueryCourseResponse(calendarEvent.getCourse())
                : null;
        if (courseResponseEntity != null) {
            courseResponseEntity.getOrganization().setApiKey(null);
            courseResponseEntity.getOrganization().setMoodleUrl(null);
        }

        return CalendarEventResponseEntity.builder()
                .calendarEventId(calendarEvent.getId().getValue())
                .user(calendarEvent.getUser() != null
                        ? userDataMapper.userToUserResponseEntity(calendarEvent.getUser())
                        : null
                )
                .name(calendarEvent.getName())
                .description(calendarEvent.getDescription())
                .eventType(NotificationEventType.valueOf(calendarEvent.getEventType().name()))
                .startTime(calendarEvent.getStartTime())
                .endTime(calendarEvent.getEndTime())
                .course(courseResponseEntity)
                .contestId(calendarEvent.getContestId())
                .assignment(
                        calendarEvent.getAssignment() != null
                                ? assignmentDataMapper.assignmentToAssignmentResponseEntity(calendarEvent.getAssignment())
                                : null
                )
                .exam(
                        calendarEvent.getExam() != null
                                ? examDataMapper.examToExamResponseEntity(calendarEvent.getExam())
                                : null
                )
                .component(calendarEvent.getComponent())
                .notificationNotifyTime(calendarEvent.getNotificationNotifyTime())
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
                .course(null)
                .exam(null)
                .assignment(null)
                .contestId(UUID.fromString(calendarEventUpdateRequest.getContestId()))
                .component(NotificationComponentType.valueOf(String.valueOf(calendarEventUpdateRequest.getComponent())))
                .notificationNotifyTime(null)
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
