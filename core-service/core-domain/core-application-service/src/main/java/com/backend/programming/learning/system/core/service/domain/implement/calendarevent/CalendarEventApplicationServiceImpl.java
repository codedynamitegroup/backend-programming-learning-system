package com.backend.programming.learning.system.core.service.domain.implement.calendarevent;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.backend.programming.learning.system.core.service.domain.implement.certificatecourse.CertificateCourseCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.calendarevent.CalendarEventApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

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
    public DeleteCalendarEventResponse deleteCalendarEventResponse(DeleteCalendarEventCommand deleteCalendarEventCommand) {
        return calendarEventCommandHandler.deleteCalendarEvent(deleteCalendarEventCommand);
    }
}
