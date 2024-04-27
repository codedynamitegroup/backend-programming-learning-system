package com.backend.programming.learning.system.core.service.domain.implement.saga.calendarevent;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.calendarevent.CalendarEventUpdateResponse;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import com.backend.programming.learning.system.domain.event.EmptyEvent;
import com.backend.programming.learning.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CalendarEventUpdateSaga implements SagaStep<CalendarEventUpdateResponse, EmptyEvent, EmptyEvent> {

    private final ContestUserRepository contestUserRepository;

    public CalendarEventUpdateSaga(ContestUserRepository contestUserRepository) {
        this.contestUserRepository = contestUserRepository;
    }

    @Override
    public EmptyEvent process(CalendarEventUpdateResponse data) {
        return null;
    }

    @Override
    public EmptyEvent rollback(CalendarEventUpdateResponse data) {
        return null;
    }
}
