package com.backend.programming.learning.system.course.service.domain.implement.service.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllToDoCalendarEventsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.calendarevent.UpdateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.calendarevent.UpdateCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.calendarevent.CalendarEventApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
class CalendarEventApplicationServiceImpl implements CalendarEventApplicationService {
    private final CalendarEventCommandHandler calendarEventCommandHandler;

    public CalendarEventApplicationServiceImpl(CalendarEventCommandHandler calendarEventCommandHandler) {
        this.calendarEventCommandHandler = calendarEventCommandHandler;
    }

    @Override
    public CreateCalendarEventResponse createCalendarEventResponse(CreateCalendarEventCommand createCalendarEventCommand) {
        return calendarEventCommandHandler.createCalendarEvent(createCalendarEventCommand);
    }

    @Override
    public QueryAllCalendarEventsResponse queryAllCalendarEventsResponse(QueryAllCalendarEventsCommand queryAllCalendarEventsCommand) {
        return calendarEventCommandHandler.queryAllCalendarEvents(queryAllCalendarEventsCommand);
    }

    @Override
    public QueryAllCalendarEventsResponse queryAllToDoCalendarEventsResponse(QueryAllToDoCalendarEventsCommand queryAllToDoCalendarEventsCommand) {
        return calendarEventCommandHandler.queryAllToDoCalendarEvents(queryAllToDoCalendarEventsCommand);
    }

    @Override
    public DeleteCalendarEventResponse deleteCalendarEventResponse(DeleteCalendarEventCommand deleteCalendarEventCommand) {
        return calendarEventCommandHandler.deleteCalendarEvent(deleteCalendarEventCommand);
    }

    @Override
    public UpdateCalendarEventResponse updateCalendarEventResponse(
            UUID calendarEventId,
            UpdateCalendarEventCommand updateCalendarEventCommand) {
        return calendarEventCommandHandler.updateCalendarEvent(
                    calendarEventId, updateCalendarEventCommand);
    }
}
