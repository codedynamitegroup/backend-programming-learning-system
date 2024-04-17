package com.backend.programming.learning.system.core.service.domain.implement.contest;

import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.review.CreateReviewResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.certificatecourse.DeleteCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.contest.DeleteContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.contest.DeleteContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryAllContestsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.contest.QueryContestResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.implement.review.ReviewCreateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.contest.ContestDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.review.ReviewDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
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
    public QueryContestResponse queryContestResponse(
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
