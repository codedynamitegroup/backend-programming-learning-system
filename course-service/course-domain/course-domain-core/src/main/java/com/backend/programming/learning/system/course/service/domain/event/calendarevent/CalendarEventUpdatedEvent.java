package com.backend.programming.learning.system.course.service.domain.event.calendarevent;

import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState;

import java.util.List;

public class CalendarEventUpdatedEvent extends CalendarEventEvent {

    protected CalendarEventUpdatedEvent(CalendarEvent calendarEvent,
                                        UpdateState updateCalendarEventState,
                                        List<String> failureMessages) {
        super(calendarEvent, updateCalendarEventState, failureMessages);
    }
    @Override
    public void fire() {

    }
}
