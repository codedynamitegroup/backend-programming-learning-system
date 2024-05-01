package com.backend.programming.learning.system.course.service.domain.implement.service.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsCommand;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
public class CalendarEventQueryHelper {
    private final CalendarEventRepository calendarEventRepository;

    public CalendarEventQueryHelper(CalendarEventRepository calendarEventRepository) {
        this.calendarEventRepository = calendarEventRepository;
    }

    @Transactional(readOnly = true)
    public List<CalendarEvent> findAllCalendarEvents(
            QueryAllCalendarEventsCommand queryAllCalendarEventsCommand
    ) {
        return calendarEventRepository.findAllBetweenFromTimeAndToTime(queryAllCalendarEventsCommand.getFromTime(),
                queryAllCalendarEventsCommand.getToTime());
    }
}





















