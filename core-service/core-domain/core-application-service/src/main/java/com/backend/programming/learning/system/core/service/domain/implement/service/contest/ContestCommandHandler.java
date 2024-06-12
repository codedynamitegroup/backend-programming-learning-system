package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.DeleteContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.QueryGeneralStatisticsContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.*;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.contest.UpdateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.ContestQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.mapper.contest.ContestDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.contest_question.ContestQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ContestCommandHandler {
    private final ContestCreateHelper contestCreateHelper;
    private final ContestQueryHelper contestQueryHelper;
    private final ContestDeleteHelper contestDeleteHelper;
    private final ContestUpdateHelper contestUpdateHelper;
    private final ContestDataMapper contestDataMapper;
    private final ContestQuestionDataMapper contestQuestionDataMapper;

    public ContestCommandHandler(ContestCreateHelper contestCreateHelper,
                                 ContestQueryHelper contestQueryHelper,
                                 ContestDeleteHelper contestDeleteHelper,
                                 ContestUpdateHelper contestUpdateHelper,
                                 ContestDataMapper contestDataMapper,
                                 ContestQuestionDataMapper contestQuestionDataMapper) {
        this.contestCreateHelper = contestCreateHelper;
        this.contestQueryHelper = contestQueryHelper;
        this.contestDeleteHelper = contestDeleteHelper;
        this.contestUpdateHelper = contestUpdateHelper;
        this.contestDataMapper = contestDataMapper;
        this.contestQuestionDataMapper = contestQuestionDataMapper;
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
                        queryAllContestsCommand.getSearchName(),
                        queryAllContestsCommand.getStartTimeFilter(),
                        queryAllContestsCommand.getPageNo(),
                        queryAllContestsCommand.getPageSize(),
                        queryAllContestsCommand.getEmail(),
                        false);

        log.info("Returning all contests: {}", contests);

        return contestDataMapper.contestsToQueryAllContestsResponse(contests);
    }

    @Transactional(readOnly = true)
    public QueryAllContestsResponse queryAllMyContestsResponse(
            QueryAllMyContestsCommand queryAllMyContestsCommand
    ) {
        Page<Contest> contests = contestQueryHelper
                .queryAllMyContests(
                        queryAllMyContestsCommand.getSearchName(),
                        queryAllMyContestsCommand.getPageNo(),
                        queryAllMyContestsCommand.getPageSize(),
                        queryAllMyContestsCommand.getEmail());

        log.info("Returning all my contests: {}", contests);

        return contestDataMapper.contestsToQueryAllContestsResponse(contests);
    }

    @Transactional(readOnly = true)
    public QueryStatisticsOfContestResponse queryStatisticsOfContestResponse(
            QueryStatisticsOfContestCommand queryStatisticsOfContestCommand
    ) {

        List<ContestQuestion> contestQuestions = contestQueryHelper
                .queryAllContestQuestionsByContestId(
                        queryStatisticsOfContestCommand.getContestId());
        log.info("Returning all contest questions: {}", contestQuestions);

        int numOfParticipantsOfContest = contestQueryHelper
                .countAllParticipantsByContestId(
                        queryStatisticsOfContestCommand.getContestId());
        log.info("Returning number of participants for contest: {}", numOfParticipantsOfContest);

        int numOfParticipantsHavingSubmissions = contestQueryHelper
                .countAllParticipantsHavingSubmissionsByContestId(
                        queryStatisticsOfContestCommand.getContestId());
        log.info("Returning number of participants having submissions for contest: {}", numOfParticipantsHavingSubmissions);

        return QueryStatisticsOfContestResponse.builder()
                .contestQuestions(
                        contestQuestionDataMapper.contestQuestionsToContestQuestionResponseEntities(contestQuestions)
                )
                .numOfSignUps(numOfParticipantsOfContest)
                .numOfParticipantsHavingSubmissions(numOfParticipantsHavingSubmissions)
                .build();
    }

    @Transactional(readOnly = true)
    public QueryAllContestsResponse queryAllContestsResponseForAdmin(
            QueryAllContestsCommand queryAllContestsCommand
    ) {
        Page<Contest> contests = contestQueryHelper
                .queryAllContests(
                        queryAllContestsCommand.getSearchName(),
                        queryAllContestsCommand.getStartTimeFilter(),
                        queryAllContestsCommand.getPageNo(),
                        queryAllContestsCommand.getPageSize(),
                        queryAllContestsCommand.getEmail(),
                        true);

        log.info("Returning all contests: {}", contests);

        return contestDataMapper.contestsToQueryAllContestsResponse(contests);
    }

    @Transactional(readOnly = true)
    public QueryMostPopularContestsResponse queryMostPopularContestsResponse(
            QueryMostPopularContestsCommand queryMostPopularContestsCommand
    ) {
        List<Contest> contests = contestQueryHelper
                .findMostPopularContests();
        log.info("Returning most popular upcoming contests: {}", contests);

        int numOfParticipants = contestQueryHelper.countAllParticipants();
        log.info("Returning number of participants: {}", numOfParticipants);

        int numOfContests = contestQueryHelper.countAllContests();
        log.info("Returning number of contests: {}", numOfContests);

        return QueryMostPopularContestsResponse
                .builder()
                .mostPopularContests(contestDataMapper.contestsToContestResponseEntities(contests))
                .numOfParticipants(numOfParticipants)
                .numOfContests(numOfContests)
                .build();
    }

    @Transactional(readOnly = true)
    public ContestResponseEntity queryContestResponse(
            QueryContestCommand queryContestCommand
    ) {
        Contest contest = contestQueryHelper
                .queryContestById(
                        queryContestCommand.getContestId(),
                        queryContestCommand.getEmail());

        return contestDataMapper.contestToQueryContestResponse(contest);
    }

    @Transactional(readOnly = true)
    public QueryLeaderboardOfContestResponse queryLeaderboardOfContestResponse(
            QueryLeaderboardOfContestCommand queryLeaderboardOfContestCommand
    ) {
        Page<ContestUser> contestUsers = contestQueryHelper
                .queryLeaderboardOfContest(
                        queryLeaderboardOfContestCommand.getContestId(),
                        queryLeaderboardOfContestCommand.getPageNo(),
                        queryLeaderboardOfContestCommand.getPageSize());

        ContestUser participantRank = contestQueryHelper
                .queryMyRankOfContest(
                        queryLeaderboardOfContestCommand.getContestId(),
                        queryLeaderboardOfContestCommand.getEmail());

        log.info("Returning leaderboard of contest: {}", contestUsers);
        return QueryLeaderboardOfContestResponse.builder()
                .participantRank(
                        participantRank == null
                                ? null
                                : contestDataMapper.contestUserToContestUserResponseEntity(participantRank))
                .contestLeaderboard(contestDataMapper.contestUsersToContestUserResponseEntities(contestUsers.getContent()))
                .currentPage(contestUsers.getNumber())
                .totalItems(contestUsers.getTotalElements())
                .totalPages(contestUsers.getTotalPages())
                .build();
    }



    @Transactional
    public DeleteContestResponse deleteContestResponse(
            DeleteContestCommand deleteContestCommand
    ) {
        contestDeleteHelper.deleteContestById(
                deleteContestCommand.getContestId()
        );

        return DeleteContestResponse.builder()
                .contestId(deleteContestCommand.getContestId())
                .message("Contest deleted successfully")
                .build();
    }

    @Transactional
    public UpdateContestResponse updateContestResponse(
            UpdateContestCommand updateContestCommand) {
        contestUpdateHelper
                .persistContest(updateContestCommand);

        log.info("Contest updated with id: {}", updateContestCommand.getContestId());

        return contestDataMapper.contestToUpdateContestResponse(
                new ContestId(updateContestCommand.getContestId()),
                "Contest updated successfully");
    }

    public QueryGeneralStatisticsContestResponse getStatisticContestResponse() {
        return contestQueryHelper.getStatisticContestResponse();
    }
}
