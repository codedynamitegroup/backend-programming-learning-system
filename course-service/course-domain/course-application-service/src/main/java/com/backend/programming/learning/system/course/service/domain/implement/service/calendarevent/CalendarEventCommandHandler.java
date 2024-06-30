package com.backend.programming.learning.system.course.service.domain.implement.service.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.calendarevent.UpdateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.calendarevent.UpdateCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.calendarevent.CalendarEventDataMapper;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class CalendarEventCommandHandler {
    private final CalendarEventCreateHelper calendarEventCreateHelper;
    private final CalendarEventQueryHelper calendarEventQueryHelper;
    private final CalendarEventDeleteHelper calendarEventDeleteHelper;
    private final CalendarEventDataMapper calendarEventDataMapper;
    private final CalendarEventUpdateHelper calendarEventUpdateHelper;

    public CalendarEventCommandHandler(CalendarEventCreateHelper calendarEventCreateHelper,
                                       CalendarEventQueryHelper calendarEventQueryHelper,
                                       CalendarEventDeleteHelper calendarEventDeleteHelper,
                                       CalendarEventDataMapper calendarEventDataMapper,
                                       CalendarEventUpdateHelper calendarEventUpdateHelper) {
        this.calendarEventCreateHelper = calendarEventCreateHelper;
        this.calendarEventQueryHelper = calendarEventQueryHelper;
        this.calendarEventDeleteHelper = calendarEventDeleteHelper;
        this.calendarEventDataMapper = calendarEventDataMapper;
        this.calendarEventUpdateHelper = calendarEventUpdateHelper;
    }

    @Transactional
    public CreateCalendarEventResponse createCalendarEvent(
            CreateCalendarEventCommand createCalendarEventCommand) {
        CalendarEvent calendarEvent = calendarEventCreateHelper
                .persistCalendarEvent(createCalendarEventCommand);

        log.info("Calendar event created with id: {}", calendarEvent.getId().getValue());

        return calendarEventDataMapper.calendarEventToCreateCalendarEventResponse(calendarEvent,
                "Calendar event created successfully");
    }

    @Transactional
    public UpdateCalendarEventResponse updateCalendarEvent(
            UUID calendarEventId,
            UpdateCalendarEventCommand updateCalendarEventCommand) {
        CalendarEvent calendarEvent = calendarEventUpdateHelper
                .persistCalendarEvent(
                        calendarEventId,
                        updateCalendarEventCommand);

        log.info("Calendar event updated with id: {}", calendarEvent.getId().getValue());

        return UpdateCalendarEventResponse.builder()
                .calendarEventId(calendarEvent.getId().getValue())
                .message("Calendar event updated successfully")
                .build();
    }

    @Transactional(readOnly = true)
    public QueryAllCalendarEventsResponse queryAllCalendarEvents(
            QueryAllCalendarEventsCommand queryAllCalendarEventsCommand) {
        List<CalendarEvent> calendarEvents = calendarEventQueryHelper
                .findAllCalendarEvents(queryAllCalendarEventsCommand);

        log.info("Returning all calendar events: {}", calendarEvents);

        return calendarEventDataMapper.calendarEventsToQueryAllCalendarEventsResponse(calendarEvents);
    }

    @Transactional
    public DeleteCalendarEventResponse deleteCalendarEvent(DeleteCalendarEventCommand deleteCalendarEventCommand) {
        calendarEventDeleteHelper.deleteCalendarEventById(deleteCalendarEventCommand.getCalendarEventId());

        log.info("Calendar event deleted with id: {}", deleteCalendarEventCommand.getCalendarEventId());

        return DeleteCalendarEventResponse.builder()
                .calendarEventId(deleteCalendarEventCommand.getCalendarEventId())
                .message("Calendar event deleted successfully")
                .build();
    }

    @Transactional(readOnly = true)
    public CalendarEvent findByExamId(UUID examId) {
        List<CalendarEvent> calendarEvents = calendarEventQueryHelper.findAllCalendarEventsByExamId(examId);
        if (calendarEvents.isEmpty()) {
            log.warn("No calendar event found for exam id: {}", examId);
            return null;
        }
        return calendarEvents.get(0);
    }

    @Transactional(readOnly = true)
    public CalendarEvent findByAssignmentId(UUID assignmentId) {
        List<CalendarEvent> calendarEvents = calendarEventQueryHelper.findAllCalendarEventsByAssignmentId(assignmentId);
        if (calendarEvents.isEmpty()) {
            log.warn("No calendar event found for assignment id: {}", assignmentId);
            return null;
        }
        return calendarEvents.get(0);
    }

}
