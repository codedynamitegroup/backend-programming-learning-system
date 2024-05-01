package com.backend.programming.learning.system.course.service.domain.event.calendarevent;


import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;
import java.util.List;

public abstract class CalendarEventEvent implements DomainEvent<CalendarEvent> {
    private final CalendarEvent calendarEvent;
    private final UpdateState updateCalendarEventState;
    private final ZonedDateTime createdAt;
    private final List<String> failureMessages;

    protected CalendarEventEvent(CalendarEvent calendarEvent,
                                 UpdateState updateCalendarEventState,
                                 ZonedDateTime createdAt,
                                 List<String> failureMessages) {
        this.calendarEvent = calendarEvent;
        this.updateCalendarEventState = updateCalendarEventState;
        this.createdAt = createdAt;
        this.failureMessages = failureMessages;
    }

    public UpdateState getUpdateCalendarEventState() {
        return updateCalendarEventState;
    }

    public CalendarEvent getCalendarEvent() {
        return calendarEvent;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }
}
