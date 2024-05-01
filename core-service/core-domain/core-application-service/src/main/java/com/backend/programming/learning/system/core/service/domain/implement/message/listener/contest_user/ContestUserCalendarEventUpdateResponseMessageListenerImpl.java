package com.backend.programming.learning.system.core.service.domain.implement.message.listener.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.contest_user.ContestUserCalendarEventUpdatedResponse;
import com.backend.programming.learning.system.core.service.domain.implement.service.contest_user.ContestUserCalendarEventUpdateSaga;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.contest_user.ContestUserCalendarEventUpdateResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class ContestUserCalendarEventUpdateResponseMessageListenerImpl implements ContestUserCalendarEventUpdateResponseMessageListener {

    private final ContestUserCalendarEventUpdateSaga contestUserCalendarEventUpdateSaga;

    public ContestUserCalendarEventUpdateResponseMessageListenerImpl(ContestUserCalendarEventUpdateSaga contestUserCalendarEventUpdateSaga) {
        this.contestUserCalendarEventUpdateSaga = contestUserCalendarEventUpdateSaga;
    }

    @Override
    public void calendarEventCreatedUpdatedOrDeletedSuccess(ContestUserCalendarEventUpdatedResponse contestUserCalendarEventUpdatedResponse) {
        contestUserCalendarEventUpdateSaga.process(contestUserCalendarEventUpdatedResponse);
        log.info("Calendar Event Update Saga process operation is completed for calendar event id: {}",
                contestUserCalendarEventUpdatedResponse.getCalendarEventId());
    }

    @Override
    public void calendarEventCreatedUpdatedOrDeletedFail(ContestUserCalendarEventUpdatedResponse contestUserCalendarEventUpdatedResponse) {
        contestUserCalendarEventUpdateSaga.rollback(contestUserCalendarEventUpdatedResponse);
        log.info("Calendar Event Update Saga rollback operation is completed for calendar event id: {}",
                contestUserCalendarEventUpdatedResponse.getCalendarEventId());
    }
}
