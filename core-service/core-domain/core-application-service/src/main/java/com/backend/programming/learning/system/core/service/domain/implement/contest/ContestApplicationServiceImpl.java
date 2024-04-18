package com.backend.programming.learning.system.core.service.domain.implement.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest.ContestApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@Slf4j
class ContestApplicationServiceImpl implements ContestApplicationService {
    private final ContestCommandHandler contestCommandHandler;

    public ContestApplicationServiceImpl(ContestCommandHandler contestCommandHandler) {
        this.contestCommandHandler = contestCommandHandler;
    }

    @Override
    public CreateContestResponse createContest(@Valid CreateContestCommand createContestCommand) {
        return contestCommandHandler.createContestResponse(createContestCommand);
    }

    @Override
    public QueryAllContestsResponse queryAllContests(QueryAllContestsCommand queryAllContestsCommand) {
        return contestCommandHandler.queryAllContestsResponse(queryAllContestsCommand);
    }

    @Override
    public ContestResponseEntity queryContest(QueryContestCommand queryContestCommand) {
        return contestCommandHandler.queryContestResponse(queryContestCommand);
    }

    @Override
    public DeleteContestResponse deleteContest(DeleteContestCommand deleteContestCommand) {
        return contestCommandHandler.deleteContestResponse(deleteContestCommand);
    }

    @Override
    public UpdateContestResponse updateContest(UpdateContestCommand updateContestCommand) {
        return contestCommandHandler.updateContestResponse(updateContestCommand);
    }
}
