package com.backend.programming.learning.system.core.service.domain.implement.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.mapper.contest.ContestDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class ContestCommandHandler {
    private final ContestCreateHelper contestCreateHelper;
    private final ContestQueryHelper contestQueryHelper;
    private final ContestDeleteHelper contestDeleteHelper;
    private final ContestDataMapper contestDataMapper;

    public ContestCommandHandler(ContestCreateHelper contestCreateHelper,
                                 ContestQueryHelper contestQueryHelper,
                                 ContestDeleteHelper contestDeleteHelper,
                                 ContestDataMapper contestDataMapper) {
        this.contestCreateHelper = contestCreateHelper;
        this.contestQueryHelper = contestQueryHelper;
        this.contestDeleteHelper = contestDeleteHelper;
        this.contestDataMapper = contestDataMapper;
    }

    @Transactional
    public CreateContestResponse createContestResponse(
            CreateContestCommand createContestCommand) {
        Contest contest = contestCreateHelper
                .persistContest(createContestCommand);

        log.info("Contest created with id: {}", contest.getId().getValue());

        return contestDataMapper.contestToCreateContestResponse(contest,
                "Contest created successfully");
    }

    @Transactional(readOnly = true)
    public QueryAllContestsResponse queryAllContestsResponse(
            QueryAllContestsCommand queryAllContestsCommand
    ) {
        Page<Contest> contests = contestQueryHelper
                .queryAllContests(
                        queryAllContestsCommand.getPageNo(),
                        queryAllContestsCommand.getPageSize());

        return contestDataMapper.contestsToQueryAllContestsResponse(contests);
    }

    @Transactional(readOnly = true)
    public ContestResponseEntity queryContestResponse(
            QueryContestCommand queryContestCommand
    ) {
        Contest contest = contestQueryHelper
                .queryContestById(queryContestCommand.getContestId());

        return contestDataMapper.contestToQueryContestResponse(contest);
    }

    @Transactional
    public DeleteContestResponse deleteContestResponse(
            DeleteContestCommand deleteContestCommand
    ) {
        contestDeleteHelper.deleteContestById(
                deleteContestCommand.getContestId());

        return DeleteContestResponse.builder()
                .contestId(deleteContestCommand.getContestId())
                .message("Contest deleted successfully")
                .build();
    }
}
