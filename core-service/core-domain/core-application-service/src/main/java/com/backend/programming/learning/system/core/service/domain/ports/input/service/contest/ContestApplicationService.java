package com.backend.programming.learning.system.core.service.domain.ports.input.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryMostPopularContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;

import jakarta.validation.Valid;

public interface ContestApplicationService {
    CreateContestResponse createContest(
            @Valid CreateContestCommand createContestCommand);

    QueryAllContestsResponse queryAllContests(
            @Valid QueryAllContestsCommand queryAllContestsCommand);
    QueryMostPopularContestsResponse queryMostPopularContests();

    ContestResponseEntity queryContest(
            @Valid QueryContestCommand queryContestCommand);

    DeleteContestResponse deleteContest(
            @Valid DeleteContestCommand deleteContestCommand);

    UpdateContestResponse updateContest(
            @Valid UpdateContestCommand updateContestCommand);
}
