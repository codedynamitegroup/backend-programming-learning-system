package com.backend.programming.learning.system.core.service.domain.implement.service.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestUsersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestUsersResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.event.contest_user.ContestUserUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.mapper.contest_user.ContestUserDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.contest_user.ContestUserUpdateOutboxHelper;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@Slf4j
public class ContestUserCommandHandler {
    private final ContestUserCreateHelper contestUserCreateHelper;
    private final ContestUserQueryHelper contestUserQueryHelper;
    private final ContestUserDataMapper contestUserDataMapper;
    private final ContestUserUpdateOutboxHelper contestUserUpdateOutboxHelper;
    private final ContestUserSagaHelper contestUserSagaHelper;
    private final ObjectMapper objectMapper;

    public ContestUserCommandHandler(ContestUserCreateHelper contestUserCreateHelper,
                                     ContestUserQueryHelper contestUserQueryHelper,
                                     ContestUserDataMapper contestUserDataMapper,
                                     ContestUserUpdateOutboxHelper contestUserUpdateOutboxHelper,
                                     ContestUserSagaHelper contestUserSagaHelper,
                                     ObjectMapper objectMapper) {
        this.contestUserCreateHelper = contestUserCreateHelper;
        this.contestUserQueryHelper = contestUserQueryHelper;
        this.contestUserDataMapper = contestUserDataMapper;
        this.contestUserUpdateOutboxHelper = contestUserUpdateOutboxHelper;
        this.contestUserSagaHelper = contestUserSagaHelper;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public CreateContestUserResponse createContestUserResponse(
            CreateContestUserCommand createContestUserCommand) {
        ContestUserUpdatedEvent contestUserUpdatedEvent = contestUserCreateHelper
                .persistContestUser(createContestUserCommand);
        log.info("Contest_User is created with id: {}", contestUserUpdatedEvent.getContestUser().getId().getValue());
        CreateContestUserResponse createContestUserResponse = contestUserDataMapper
                .contestUserToCreateContestUserResponse(contestUserUpdatedEvent.getContestUser(),
                "Contest_User created successfully");

        contestUserUpdateOutboxHelper.saveContestUserUpdateOutboxMessage(
                contestUserDataMapper
                        .contestUserUpdatedEventToContestUserUpdateEventPayload(contestUserUpdatedEvent),
                contestUserUpdatedEvent.getContestUser().getUpdateCalendarEventState(),
                contestUserSagaHelper.updateCalendarEventStateToSagaStatus(
                        contestUserUpdatedEvent.getContestUser().getUpdateCalendarEventState()),
                OutboxStatus.STARTED,
                UUID.randomUUID());

        log.info("Returning contestUserUpdatedEvent with contest id and user id: {} {}",
                contestUserUpdatedEvent.getContestUser().getContest().getId().getValue(),
                contestUserUpdatedEvent.getContestUser().getUser().getId().getValue());

        return createContestUserResponse;
    }

    @Transactional(readOnly = true)
    public QueryAllContestUsersResponse findAllContestUsersResponse(
            QueryAllContestUsersCommand queryAllContestUsersCommand) {
        Page<ContestUser> contestUsers = contestUserQueryHelper
                .queryAllContestUsers(
                        queryAllContestUsersCommand.getContestId(),
                        queryAllContestUsersCommand.getPageNo(),
                        queryAllContestUsersCommand.getPageSize(),
                        queryAllContestUsersCommand.getFetchAll());

        return contestUserDataMapper.contestUsersToQueryAllContestUsersResponse(
                contestUsers);
    }

}
