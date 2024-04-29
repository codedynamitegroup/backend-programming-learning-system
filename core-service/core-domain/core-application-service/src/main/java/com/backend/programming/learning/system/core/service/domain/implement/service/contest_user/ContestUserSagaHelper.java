package com.backend.programming.learning.system.core.service.domain.implement.service.contest_user;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.contest_user.ContestUserCalendarEventUpdatedResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.exception.ContestUserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.outbox.model.contest_user.ContestUserUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestUserSagaHelper {
    private final ContestUserRepository contestUserRepository;
    private final CoreDomainService coreDomainService;

    public ContestUserSagaHelper(ContestUserRepository contestUserRepository,
                                 CoreDomainService coreDomainService) {
        this.contestUserRepository = contestUserRepository;
        this.coreDomainService = coreDomainService;
    }

    void completeContestUserUpdateOrCreate(
            ContestUserCalendarEventUpdatedResponse response,
            UpdateState updateCalendarEventState){
        ContestUser contestUser = findContestUserByContestIdAndUserId(
                UUID.fromString(response.getContestId()),
                UUID.fromString(response.getUserId())
        );
        log.info("Completing save or change contest user with contest id: {} and user id: {} with update calendar event state: {}",
                response.getContestId(), response.getUserId(), updateCalendarEventState);
        coreDomainService.updateContestUserCalendarEventState(
                contestUser,
                response.getCalendarEventId(),
                updateCalendarEventState);
        contestUserRepository.saveContestUser(contestUser);
    }

    void failCodeQuestionsUpdateOrCreate(ContestUserCalendarEventUpdatedResponse response,
                                                 UpdateState updateCalendarEventState){
        ContestUser contestUser = findContestUserByContestIdAndUserId(
                UUID.fromString(response.getContestId()),
                UUID.fromString(response.getUserId())
        );
        log.info("Quitting save or change contest user calendar event state with contest id: {} and user id: {} with update calendar event state: {}",
                response.getContestId(), response.getUserId(), updateCalendarEventState);
        coreDomainService.updateContestUserCalendarEventState(
                contestUser,
                response.getCalendarEventId(),
                updateCalendarEventState);
        contestUserRepository.saveContestUser(contestUser);
    }

    ContestUser findContestUserByContestIdAndUserId(UUID contestId, UUID userId){
        Optional<ContestUser> response = contestUserRepository.findByContestIdAndUserId(
                contestId,
                userId
        );
        if (response.isEmpty()) {
            log.error("ContestUser with contest id: {} and user id: {} could not be found!",
                    contestId, userId);
            throw new ContestUserNotFoundException("ContestUser with contest id: " +
                    contestId + " and user id: " + userId + " could not be found!");
        }
        return response.get();
    }

    ContestUserUpdateOutboxMessage getUpdateContestUserUpdateOutboxMessage(
            ContestUserUpdateOutboxMessage message,
            UpdateState updateCalendarEventState,
            SagaStatus sagaStatus){
        message.setUpdateCalendarEventState(updateCalendarEventState);
        message.setSagaStatus(sagaStatus);
        message.setProcessedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        return message;
    }

    public SagaStatus updateCalendarEventStateToSagaStatus(UpdateState updateCalendarEventState) {
        return switch (updateCalendarEventState) {
            case CREATING,UPDATING,DELETING -> SagaStatus.STARTED;
            case CREATED,UPDATED,DELETED -> SagaStatus.SUCCEEDED;
            case CREATE_FAILED, UPDATE_FAILED, DELETE_FAILED -> SagaStatus.FAILED;
            default -> SagaStatus.STARTED;
        };
    }
}
