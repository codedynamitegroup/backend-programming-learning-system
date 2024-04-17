package com.backend.programming.learning.system.core.service.domain.implement.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.mapper.contest_user.ContestUserDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class ContestUserCommandHandler {
    private final ContestUserCreateHelper contestUserCreateHelper;
    private final ContestUserDataMapper contestUserDataMapper;

    public ContestUserCommandHandler(ContestUserCreateHelper contestUserCreateHelper,
                                     ContestUserDataMapper contestUserDataMapper) {
        this.contestUserCreateHelper = contestUserCreateHelper;
        this.contestUserDataMapper = contestUserDataMapper;
    }

    @Transactional
    public CreateContestUserResponse createContestUserResponse(
            CreateContestUserCommand createContestUserCommand) {
        ContestUser contestUser = contestUserCreateHelper
                .persistContestUser(createContestUserCommand);

        log.info("Contest User created with id: {}", contestUser.getId().getValue());

        return contestUserDataMapper.contestUserToCreateContestUserResponse(contestUser,
                "Contest User created successfully");
    }

}
