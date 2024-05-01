package com.backend.programming.learning.system.core.service.domain.implement.service.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.contest_user.ContestUserCalendarEventUpdatedResponse;
import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.contest_user.ContestUserUpdateOutboxHelper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.saga.SagaStatus;
import com.backend.programming.learning.system.saga.SagaStepApplyOutboxPattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestUserCalendarEventUpdateSaga implements SagaStepApplyOutboxPattern<
        ContestUserCalendarEventUpdatedResponse> {
    private final ContestUserSagaHelper contestUserSagaHelper;
    private final ContestUserUpdateOutboxHelper contestUserUpdateOutboxHelper;
    private final ContestUserRepository contestUserRepository;

    public ContestUserCalendarEventUpdateSaga(ContestUserSagaHelper contestUserSagaHelper,
                                              ContestUserUpdateOutboxHelper contestUserUpdateOutboxHelper,
                                              ContestUserRepository contestUserRepository) {
        this.contestUserSagaHelper = contestUserSagaHelper;
        this.contestUserUpdateOutboxHelper = contestUserUpdateOutboxHelper;
        this.contestUserRepository = contestUserRepository;
    }

    @Override
    @Transactional
    public void process(ContestUserCalendarEventUpdatedResponse contestUserCalendarEventUpdatedResponse) {
        Optional<ContestUserUpdateOutboxMessage> contestUserUpdateOutboxResponse =
                contestUserUpdateOutboxHelper.getContestUserUpdateOutboxMessageBySagaIdAndSagaStatus(
                        UUID.fromString(contestUserCalendarEventUpdatedResponse.getSagaId()),
                        SagaStatus.STARTED);

        if (contestUserUpdateOutboxResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already processed!",
                    contestUserCalendarEventUpdatedResponse.getSagaId());
            return;
        }

        ContestUserUpdateOutboxMessage contestUserUpdateOutboxMessage = contestUserUpdateOutboxResponse.get();

        // Update contest user calendar event state
        switch (contestUserCalendarEventUpdatedResponse.getUpdateCalendarEventState()){
            case CREATED ->
            {
                // Update contest user
                contestUserSagaHelper
                        .completeContestUserUpdateOrCreate(
                                contestUserCalendarEventUpdatedResponse, UpdateState.CREATED);
                // Update outbox
                contestUserUpdateOutboxHelper.save(
                        contestUserSagaHelper.getUpdateContestUserUpdateOutboxMessage(
                                contestUserUpdateOutboxMessage,
                                UpdateState.CREATED,
                                SagaStatus.SUCCEEDED));
            }
            case UPDATED ->
            {
                // Update contest user
                contestUserSagaHelper.completeContestUserUpdateOrCreate(
                        contestUserCalendarEventUpdatedResponse, UpdateState.UPDATED);
                // Update outbox
                contestUserUpdateOutboxHelper.save(
                        contestUserSagaHelper.getUpdateContestUserUpdateOutboxMessage(
                                contestUserUpdateOutboxMessage,
                                UpdateState.UPDATED,
                                SagaStatus.SUCCEEDED));
            }
            case DELETED ->
            {
                // Actual delete
                contestUserRepository.deleteByContestIdAndUserId(
                        UUID.fromString(contestUserCalendarEventUpdatedResponse.getContestId()),
                        UUID.fromString(contestUserCalendarEventUpdatedResponse.getUserId()));
                // Update outbox
                contestUserUpdateOutboxHelper.save(
                        contestUserSagaHelper.getUpdateContestUserUpdateOutboxMessage(
                                contestUserUpdateOutboxMessage,
                                UpdateState.DELETED,
                                SagaStatus.SUCCEEDED));
            }
        }

        log.info("Contest user with id {} is updated", contestUserCalendarEventUpdatedResponse.getId());
    }

    @Override
    @Transactional
    public void rollback(ContestUserCalendarEventUpdatedResponse contestUserCalendarEventUpdatedResponse) {
        Optional<ContestUserUpdateOutboxMessage> orderPaymentOutboxMessageResponse =
                contestUserUpdateOutboxHelper.getContestUserUpdateOutboxMessageBySagaIdAndSagaStatus(
                        UUID.fromString(contestUserCalendarEventUpdatedResponse.getSagaId()),
                        SagaStatus.STARTED);

        if (orderPaymentOutboxMessageResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already processed!",
                    contestUserCalendarEventUpdatedResponse.getSagaId());
            return;
        }

        ContestUserUpdateOutboxMessage contestUserUpdateOutboxMessage = orderPaymentOutboxMessageResponse.get();

        // If failed, just need to update state
        switch (contestUserUpdateOutboxMessage.getUpdateCalendarEventState()){
            case CREATE_FAILED ->
            {
                contestUserSagaHelper.failCodeQuestionsUpdateOrCreate(contestUserCalendarEventUpdatedResponse, UpdateState.CREATE_FAILED);
                // update outbox
                contestUserUpdateOutboxHelper.save(
                        contestUserSagaHelper.getUpdateContestUserUpdateOutboxMessage(
                                contestUserUpdateOutboxMessage,
                                UpdateState.CREATE_FAILED,
                                SagaStatus.FAILED));
            }
            case UPDATE_FAILED ->
            {
                contestUserSagaHelper.failCodeQuestionsUpdateOrCreate(contestUserCalendarEventUpdatedResponse, UpdateState.UPDATE_FAILED);
                contestUserUpdateOutboxHelper.save(
                        contestUserSagaHelper.getUpdateContestUserUpdateOutboxMessage(
                                contestUserUpdateOutboxMessage,
                                UpdateState.UPDATE_FAILED,
                                SagaStatus.FAILED));
            }
            case DELETE_FAILED ->
            {
                contestUserSagaHelper.failCodeQuestionsUpdateOrCreate(contestUserCalendarEventUpdatedResponse, UpdateState.DELETE_FAILED);
                contestUserUpdateOutboxHelper.save(
                        contestUserSagaHelper.getUpdateContestUserUpdateOutboxMessage(
                                contestUserUpdateOutboxMessage,
                                UpdateState.DELETE_FAILED,
                                SagaStatus.FAILED));
            }
        }
        log.info("Contest user with id {} is roll backed", contestUserCalendarEventUpdatedResponse.getId());
    }
}
