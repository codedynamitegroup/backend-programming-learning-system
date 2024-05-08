package com.backend.programming.learning.system.core.service.domain.ports.input.service.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest_user.CreateContestUserResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestUsersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestUsersResponse;

import jakarta.validation.Valid;
import java.util.List;

public interface ContestUserApplicationService {
    CreateContestUserResponse createContestUser(
            @Valid CreateContestUserCommand createContestUserCommand);

    QueryAllContestUsersResponse queryAllContestUsers(
            @Valid QueryAllContestUsersCommand queryAllContestUsersCommand);
}
