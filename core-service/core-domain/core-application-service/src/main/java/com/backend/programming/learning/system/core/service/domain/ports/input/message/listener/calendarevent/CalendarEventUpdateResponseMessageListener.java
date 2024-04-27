package com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.calendarevent;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.calendarevent.CalendarEventUpdateResponse;

public interface CalendarEventUpdateResponseMessageListener {

    void calendarEventCreatedUpdatedOrDeletedSuccess(CalendarEventUpdateResponse calendarEventUpdateResponse);

    void calendarEventCreatedUpdatedOrDeletedFail(CalendarEventUpdateResponse calendarEventUpdateResponse);
}
