package com.backend.programming.learning.system.core.service.domain.ports.input.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.contest.DeleteContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.contest.DeleteContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryAllContestsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryContestResponse;

import javax.validation.Valid;

public interface ContestApplicationService {
    CreateContestResponse createContest(
            @Valid CreateContestCommand createContestCommand);

    QueryAllContestsResponse queryAllContests(
            @Valid QueryAllContestsCommand queryAllContestsCommand);

    QueryContestResponse queryContest(
            @Valid QueryContestCommand queryContestCommand);

    DeleteContestResponse deleteContest(
            @Valid DeleteContestCommand deleteContestCommand);
}
