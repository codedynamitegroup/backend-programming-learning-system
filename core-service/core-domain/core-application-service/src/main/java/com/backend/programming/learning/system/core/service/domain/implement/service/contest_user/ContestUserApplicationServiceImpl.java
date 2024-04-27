package com.backend.programming.learning.system.core.service.domain.implement.service.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestUsersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestUsersResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest_user.ContestUserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class ContestUserApplicationServiceImpl implements ContestUserApplicationService {
    private final ContestUserCommandHandler contestUserCommandHandler;

    public ContestUserApplicationServiceImpl(ContestUserCommandHandler contestUserCommandHandler) {
        this.contestUserCommandHandler = contestUserCommandHandler;
    }


    @Override
    public CreateContestUserResponse createContestUser(CreateContestUserCommand createContestUserCommand) {
        return contestUserCommandHandler.createContestUserResponse(createContestUserCommand);
    }

    @Override
    public QueryAllContestUsersResponse queryAllContestUsers(QueryAllContestUsersCommand queryAllContestUsersCommand) {
        return contestUserCommandHandler.findAllContestUsersResponse(queryAllContestUsersCommand);
    }
}
