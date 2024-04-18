package com.backend.programming.learning.system.core.service.domain.mapper.calendarevent;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.CertificateCourseResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.topic.TopicDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalendarEventDataMapper {

    public CreateCalendarEventResponse calendarEventToCreateCalendarEventResponse(
            CalendarEvent calendarEvent, String message) {
        return CreateCalendarEventResponse.builder()
                .calendarEventId(calendarEvent.getId().getValue())
                .message(message)
                .build();
    }

    public CalendarEvent createCalendarEventCommandToCalendarEvent(CreateCalendarEventCommand createCalendarEventCommand) {
        return CalendarEvent.builder()
                .userTo(User.builder()
                        .id(new UserId(createCalendarEventCommand.getUserIdTo()))
                        .build())
                .name(createCalendarEventCommand.getName())
                .description(createCalendarEventCommand.getDescription())
                .eventType(NotificationEventType.valueOf(createCalendarEventCommand.getEventType()))
                .startTime(createCalendarEventCommand.getStartTime())
                .endTime(createCalendarEventCommand.getEndTime())
                .build();
    }

}
