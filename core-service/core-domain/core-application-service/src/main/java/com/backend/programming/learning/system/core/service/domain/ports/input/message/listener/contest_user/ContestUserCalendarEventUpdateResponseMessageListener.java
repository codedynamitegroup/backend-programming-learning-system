package com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.contest_user.ContestUserCalendarEventUpdatedResponse;

public interface ContestUserCalendarEventUpdateResponseMessageListener {

    void calendarEventCreatedUpdatedOrDeletedSuccess(ContestUserCalendarEventUpdatedResponse contestUserCalendarEventUpdatedResponse);

    void calendarEventCreatedUpdatedOrDeletedFail(ContestUserCalendarEventUpdatedResponse contestUserCalendarEventUpdatedResponse);
}
