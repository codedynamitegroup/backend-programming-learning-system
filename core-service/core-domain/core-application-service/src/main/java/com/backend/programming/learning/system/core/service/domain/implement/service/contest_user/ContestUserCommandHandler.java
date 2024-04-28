package com.backend.programming.learning.system.core.service.domain.implement.service.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestUsersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestUsersResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.mapper.contest_user.ContestUserDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class ContestUserCommandHandler {
    private final ContestUserCreateHelper contestUserCreateHelper;
    private final ContestUserQueryHelper contestUserQueryHelper;
    private final ContestUserDataMapper contestUserDataMapper;

    public ContestUserCommandHandler(ContestUserCreateHelper contestUserCreateHelper,
                                     ContestUserQueryHelper contestUserQueryHelper,
                                     ContestUserDataMapper contestUserDataMapper) {
        this.contestUserCreateHelper = contestUserCreateHelper;
        this.contestUserQueryHelper = contestUserQueryHelper;
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
