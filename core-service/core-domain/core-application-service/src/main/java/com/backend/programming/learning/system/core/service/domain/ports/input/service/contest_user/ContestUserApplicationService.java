package com.backend.programming.learning.system.core.service.domain.ports.input.service.contest_user;

import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest_user.CreateContestUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest_user.CreateContestUserResponse;

import javax.validation.Valid;

public interface ContestUserApplicationService {
    CreateContestUserResponse createContestUser(
            @Valid CreateContestUserCommand createContestUserCommand);
}
