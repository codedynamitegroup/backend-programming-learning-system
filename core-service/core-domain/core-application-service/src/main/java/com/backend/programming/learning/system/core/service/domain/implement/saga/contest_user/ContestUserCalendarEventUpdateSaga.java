package com.backend.programming.learning.system.core.service.domain.implement.saga.contest_user;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.contest_user.ContestUserCalendarEventUpdatedResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.domain.event.EmptyEvent;
import com.backend.programming.learning.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
public class ContestUserCalendarEventUpdateSaga implements SagaStep<
        ContestUserCalendarEventUpdatedResponse,
        EmptyEvent,
        EmptyEvent> {
    private final CoreDomainService coreDomainService;
    private final ContestUserSagaHelper contestUserSagaHelper;

    public ContestUserCalendarEventUpdateSaga(CoreDomainService coreDomainService,
                                              ContestUserSagaHelper contestUserSagaHelper) {
        this.coreDomainService = coreDomainService;
        this.contestUserSagaHelper = contestUserSagaHelper;
    }

    @Override
    @Transactional
    public EmptyEvent process(ContestUserCalendarEventUpdatedResponse data) {
        log.info("Completing contest user calendar event state update process");
        ContestUser contestUser = contestUserSagaHelper.findContestUserByContestIdAndUserId(
                UUID.fromString(data.getContestId()), UUID.fromString(data.getUserId())
        );
        coreDomainService.
                updateContestUserCalendarEventState(
                        contestUser,
                        data.getCalendarEventId(),
                        data.getUpdateCalendarEventState());

        contestUserSagaHelper.saveContestUser(contestUser);

        log.info("Contest user calendar event state updated successfully with calendar event id: {}" +
                " and update calendar event state: {}",
                data.getCalendarEventId(), data.getUpdateCalendarEventState());
        return null;
    }

    @Override
    @Transactional
    public EmptyEvent rollback(ContestUserCalendarEventUpdatedResponse data) {
        log.info("Rolling back contest user calendar event state update process");
        ContestUser contestUser = contestUserSagaHelper.findContestUserByContestIdAndUserId(
                UUID.fromString(data.getContestId()), UUID.fromString(data.getUserId())
        );
        coreDomainService.
                updateContestUserCalendarEventState(
                        contestUser,
                        data.getCalendarEventId(),
                        data.getUpdateCalendarEventState());

        contestUserSagaHelper.saveContestUser(contestUser);

        log.info("Contest user calendar event state rolled back successfully with update calendar event state: {}",
                data.getUpdateCalendarEventState());
        return null;
    }
}
