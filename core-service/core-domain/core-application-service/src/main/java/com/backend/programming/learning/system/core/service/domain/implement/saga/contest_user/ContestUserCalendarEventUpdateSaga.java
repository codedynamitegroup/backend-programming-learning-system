package com.backend.programming.learning.system.core.service.domain.implement.saga.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.contest_user.ContestUserCalendarEventUpdatedResponse;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import com.backend.programming.learning.system.domain.event.EmptyEvent;
import com.backend.programming.learning.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ContestUserCalendarEventUpdateSaga implements SagaStep<ContestUserCalendarEventUpdatedResponse, EmptyEvent, EmptyEvent> {

    private final ContestUserRepository contestUserRepository;

    public ContestUserCalendarEventUpdateSaga(ContestUserRepository contestUserRepository) {
        this.contestUserRepository = contestUserRepository;
    }

    @Override
    public EmptyEvent process(ContestUserCalendarEventUpdatedResponse data) {
        return null;
    }

    @Override
    public EmptyEvent rollback(ContestUserCalendarEventUpdatedResponse data) {
        return null;
    }
}
