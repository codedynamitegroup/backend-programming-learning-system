package com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent.CalendarEventUpdateRequest;

public interface CalendarEventUpdateRequestMessageListener {
    void updateCalendarEvent(CalendarEventUpdateRequest calendarEventUpdateRequest);
}
