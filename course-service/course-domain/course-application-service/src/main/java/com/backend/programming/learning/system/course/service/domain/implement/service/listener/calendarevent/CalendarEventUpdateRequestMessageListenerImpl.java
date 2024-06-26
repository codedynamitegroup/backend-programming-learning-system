package com.backend.programming.learning.system.course.service.domain.implement.service.listener.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent.CalendarEventUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.calendarevent.CalendarEventUpdateRequestMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class CalendarEventUpdateRequestMessageListenerImpl implements CalendarEventUpdateRequestMessageListener {

    private final CalendarEventRequestHelper calendarEventRequestHelper;

    public CalendarEventUpdateRequestMessageListenerImpl(
            CalendarEventRequestHelper calendarEventRequestHelper) {
        this.calendarEventRequestHelper = calendarEventRequestHelper;
    }

    @Override
    @Transactional
    public void updateCalendarEvent(CalendarEventUpdateRequest calendarEventUpdateRequest) {
        switch (calendarEventUpdateRequest.getUpdateCalendarEventState()) {
            case CREATING:
                calendarEventRequestHelper.persistCalendarEvent(calendarEventUpdateRequest);
                break;
            case UPDATING:
                calendarEventRequestHelper.updateCalendarEvent(calendarEventUpdateRequest);
                break;
            case DELETING:
                calendarEventRequestHelper.deleteCalendarEvent(calendarEventUpdateRequest);
                break;
            default:
                log.error("Invalid update state: {}", calendarEventUpdateRequest.getUpdateCalendarEventState());
        }
    }
}
