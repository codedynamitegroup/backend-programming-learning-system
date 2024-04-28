package com.backend.programming.learning.system.course.service.domain.implement.message.listener.calendarevent;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent.CalendarEventUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.calendarevent.CalendarEventUpdatedMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class CalendarEventRequestHelper {

    private final CourseDomainService courseDomainService;
    private final CalendarEventRepository calendarEventRepository;
    private final CalendarEventUpdatedMessagePublisher calendarEventUpdatedMessagePublisher;

    public CalendarEventRequestHelper(CourseDomainService courseDomainService,
                                      CalendarEventRepository calendarEventRepository,
                                      CalendarEventUpdatedMessagePublisher calendarEventUpdatedMessagePublisher) {
        this.courseDomainService = courseDomainService;
        this.calendarEventRepository = calendarEventRepository;
        this.calendarEventUpdatedMessagePublisher = calendarEventUpdatedMessagePublisher;
    }

    @Transactional
    public void persistCalendarEvent(CalendarEventUpdateRequest calendarEventUpdateRequest) {

    }

}
