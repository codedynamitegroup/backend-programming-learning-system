package com.backend.programming.learning.system.core.service.domain.implement.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest_user.CreateContestUserResponse;
import com.backend.programming.learning.system.core.service.domain.implement.contest.ContestCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest.ContestApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest_user.ContestUserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

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
}
