package com.backend.programming.learning.system.course.service.domain.ports.input.service.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsResponse;

import jakarta.validation.Valid;

public interface CalendarEventApplicationService {
    CreateCalendarEventResponse createCalendarEventResponse(
            @Valid CreateCalendarEventCommand createCalendarEventCommand);

    QueryAllCalendarEventsResponse queryAllCalendarEventsResponse(
            @Valid QueryAllCalendarEventsCommand queryAllCalendarEventsCommand);

    DeleteCalendarEventResponse deleteCalendarEventResponse(
            @Valid DeleteCalendarEventCommand deleteCalendarEventCommand);

}
