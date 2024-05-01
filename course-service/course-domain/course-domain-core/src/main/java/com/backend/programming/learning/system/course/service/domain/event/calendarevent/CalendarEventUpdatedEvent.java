package com.backend.programming.learning.system.course.service.domain.event.calendarevent;

import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState;

import java.time.ZonedDateTime;
import java.util.List;

public class CalendarEventUpdatedEvent extends CalendarEventEvent {

    public CalendarEventUpdatedEvent(CalendarEvent calendarEvent,
                                     UpdateState updateCalendarEventState,
                                     ZonedDateTime createdAt,
                                     List<String> failureMessages) {
        super(calendarEvent, updateCalendarEventState, createdAt, failureMessages);
    }
    @Override
    public void fire() {

    }
}
