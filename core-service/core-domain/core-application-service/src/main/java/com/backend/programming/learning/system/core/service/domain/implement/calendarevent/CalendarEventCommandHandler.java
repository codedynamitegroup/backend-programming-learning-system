package com.backend.programming.learning.system.core.service.domain.implement.calendarevent;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.implement.certificatecourse.CertificateCourseCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.certificatecourse.CertificateCourseDeleteHelper;
import com.backend.programming.learning.system.core.service.domain.implement.certificatecourse.CertificateCourseQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.certificatecourse.CertificateCourseUpdateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.calendarevent.CalendarEventDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class CalendarEventCommandHandler {
    private final CalendarEventCreateHelper calendarEventCreateHelper;
    private final CalendarEventDataMapper calendarEventDataMapper;

    public CalendarEventCommandHandler(CalendarEventCreateHelper calendarEventCreateHelper,
                                       CalendarEventDataMapper calendarEventDataMapper) {
        this.calendarEventCreateHelper = calendarEventCreateHelper;
        this.calendarEventDataMapper = calendarEventDataMapper;
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


}
