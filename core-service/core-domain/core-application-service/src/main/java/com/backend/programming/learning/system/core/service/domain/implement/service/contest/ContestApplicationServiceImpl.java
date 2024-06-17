package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryGeneralStatisticsContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.*;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest.ContestApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class ContestApplicationServiceImpl implements ContestApplicationService {
    private final ContestCommandHandler contestCommandHandler;

    public ContestApplicationServiceImpl(ContestCommandHandler contestCommandHandler) {
        this.contestCommandHandler = contestCommandHandler;
    }

    @Override
    public CreateContestResponse createContest(CreateContestCommand createContestCommand) {
        return contestCommandHandler.createContestResponse(createContestCommand);
    }

    @Override
    public QueryAllContestsResponse queryAllContests(QueryAllContestsCommand queryAllContestsCommand) {
        return contestCommandHandler.queryAllContestsResponse(queryAllContestsCommand);
    }

    @Override
    public QueryAllContestsResponse queryAllMyContests(QueryAllMyContestsCommand queryAllMyContestsCommand) {
        return contestCommandHandler.queryAllMyContestsResponse(queryAllMyContestsCommand);
    }

    @Override
    public QueryAllContestsResponse queryAllContestsForAdmin(QueryAllContestsCommand queryAllContestsCommand) {
        return contestCommandHandler.queryAllContestsResponseForAdmin(queryAllContestsCommand);
    }

    @Override
    public QueryAllContestsResponse queryAllContestsForOrgAdmin(QueryAllContestsCommand queryAllContestsCommand) {
        return contestCommandHandler.queryAllContestsResponseForOrgAdmin(queryAllContestsCommand);
    }

    @Override
    public QueryMostPopularContestsResponse queryMostPopularContests(
            QueryMostPopularContestsCommand queryMostPopularContestsCommand
    ) {
        return contestCommandHandler.queryMostPopularContestsResponse(
                queryMostPopularContestsCommand
        );
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

    @Override
    public QueryLeaderboardOfContestResponse queryLeaderboardOfContest(
            QueryLeaderboardOfContestCommand queryLeaderboardOfContestCommand) {
        return contestCommandHandler
                .queryLeaderboardOfContestResponse(queryLeaderboardOfContestCommand);
    }

    @Override
    public QueryStatisticsOfContestResponse queryStatisticsOfContestResponse(
            QueryStatisticsOfContestCommand queryStatisticsOfContestCommand) {
        return contestCommandHandler
                .queryStatisticsOfContestResponse(
                        queryStatisticsOfContestCommand);
    }

    @Override
    public QueryGeneralStatisticsContestResponse getStatisticContest() {
        return contestCommandHandler.getStatisticContestResponse();
    }
}
