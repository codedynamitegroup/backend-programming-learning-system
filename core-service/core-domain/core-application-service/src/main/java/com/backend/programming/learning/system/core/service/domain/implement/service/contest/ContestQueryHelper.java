package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_user.ContestUserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.ContestNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ContestQueryHelper {
    private final ContestRepository contestRepository;
    private final ContestQuestionRepository contestQuestionRepository;
    private final ContestUserRepository contestUserRepository;
    private final UserRepository userRepository;

    public ContestQueryHelper(ContestRepository contestRepository,
                              ContestQuestionRepository contestQuestionRepository,
                              ContestUserRepository contestUserRepository,
                              UserRepository userRepository) {
        this.contestRepository = contestRepository;
        this.contestQuestionRepository = contestQuestionRepository;
        this.contestUserRepository = contestUserRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Contest queryContestById(UUID contestId, String email) {
        Optional<Contest> contestResult =
                contestRepository.findById(new ContestId(contestId));
        if (contestResult.isEmpty()) {
            log.warn("Could not find contest with id: {}",
                    contestId);
            throw new ContestNotFoundException("Could not find contest with id: " +
                    contestId);
        }
        List<ContestQuestion> contestQuestions = getAllContestQuestionsForContest(contestId);
        List<Question> questions = contestQuestions.stream()
                .map(ContestQuestion::getQuestion)
                .toList();
        Contest contest = contestResult.get();
        contest.setQuestions(questions);

        Optional<User> userResult = userRepository.findByEmail(email);
        if(userResult.isPresent()) {
            Optional<ContestUser> contestUserResult = contestUserRepository.findByContestIdAndUserId(
                    contest.getId().getValue(),
                    userResult.get().getId().getValue()
            );
            contestUserResult.ifPresent(contestUser -> contest.setRegistered(true));
        }

        log.info("Contest queried with id: {}", contest.getId().getValue());
        return contest;
    }

    @Transactional(readOnly = true)
    public Page<Contest> queryAllContests(
            String searchName,
            String startTimeFilter,
            Integer pageNo,
            Integer pageSize,
            String email
    ) {
        log.info("Querying all contests with searchName: {}, startTimeFilter: {}, pageNo: {}, pageSize: {}",
                searchName, startTimeFilter, pageNo, pageSize);
        Optional<User> userResult = userRepository.findByEmail(email);
        Page<Contest> contests = contestRepository.findAll(searchName, startTimeFilter, pageNo, pageSize);
        for (Contest contest : contests) {
            contest.setQuestions(new ArrayList<>());
            if (userResult.isPresent()) {
                Optional<ContestUser> contestUserResult = contestUserRepository.findByContestIdAndUserId(
                        contest.getId().getValue(),
                        userResult.get().getId().getValue()
                );
                contestUserResult.ifPresent(contestUser -> contest.setRegistered(true));
            }
        }
        return contests;
    }

    @Transactional(readOnly = true)
    public List<Contest> findMostPopularContests() {
        log.info("Querying most popular upcoming contests");
        List<Contest> contestList = contestRepository.findMostPopularContests();
        for (Contest contest : contestList) {
            contest.setQuestions(new ArrayList<>());
        }
        return contestList;
    }

    @Transactional(readOnly = true)
    public int countAllParticipants() {
        log.info("Counting all participants");
        return contestUserRepository.countAllParticipants();
    }

    @Transactional(readOnly = true)
    public int countAllContests() {
        log.info("Counting all contests");
        return contestRepository.countAllContests();
    }

    @Transactional(readOnly = true)
    public Page<ContestUserResponseEntity> queryLeaderboardOfContest(
            UUID contestId,
            Integer pageNo,
            Integer pageSize
    ) {
        Page<ContestUser> contestLeaderboardResponseEntities
                = contestUserRepository.findAllContestUsersOfLeaderboard(
                        contestId, pageNo, pageSize);
        log.info("Leaderboard of contest with id: {} queried", contestId);
        return null;
    }

    @Transactional(readOnly = true)
    public ContestUserResponseEntity queryMyRankOfContest(
            UUID contestId,
            String email
    ) {
        Optional<User> userResult = userRepository.findByEmail(email);
        if (userResult.isEmpty()) {
            return null;
        }
        return null;
    }

    private List<ContestQuestion> getAllContestQuestionsForContest(UUID contestId) {
        List<ContestQuestion> contestQuestion = contestQuestionRepository
                .findAllContestQuestionsByContestId(contestId);

        log.info("All questions queried for contest with id: {}", contestId);
        return contestQuestion;
    }
}





















