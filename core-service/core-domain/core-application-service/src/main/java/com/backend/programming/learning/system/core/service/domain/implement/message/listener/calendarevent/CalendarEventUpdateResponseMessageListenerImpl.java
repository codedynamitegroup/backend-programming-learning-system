package com.backend.programming.learning.system.core.service.domain.implement.message.listener.calendarevent;

import com.backend.programming.learning.system.core.service.domain.implement.saga.calendarevent.CalendarEventUpdateSaga;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.calendarevent.CalendarEventUpdateResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class CalendarEventUpdateResponseMessageListenerImpl implements CalendarEventUpdateResponseMessageListener {

    private final CalendarEventUpdateSaga calendarEventUpdateSaga;

    public CalendarEventUpdateResponseMessageListenerImpl(CalendarEventUpdateSaga calendarEventUpdateSaga) {
        this.calendarEventUpdateSaga = calendarEventUpdateSaga;
    }
}
