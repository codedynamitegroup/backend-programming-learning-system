package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_user.ContestUserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.ContestNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeCodeQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
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
    private final QtypeCodeQuestionRepository qtypeCodeQuestionRepository;
    private final CodeSubmissionRepository codeSubmissionRepository;
    private final UserRepository userRepository;

    public ContestQueryHelper(ContestRepository contestRepository,
                              ContestQuestionRepository contestQuestionRepository,
                              ContestUserRepository contestUserRepository,
                              QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
                              CodeSubmissionRepository codeSubmissionRepository,
                              UserRepository userRepository) {
        this.contestRepository = contestRepository;
        this.contestQuestionRepository = contestQuestionRepository;
        this.contestUserRepository = contestUserRepository;
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.codeSubmissionRepository = codeSubmissionRepository;
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
        Contest contest = contestResult.get();

        Optional<User> userResult = userRepository.findByEmail(email);
        if(userResult.isPresent()) {
            Optional<ContestUser> contestUserResult = contestUserRepository.findByContestIdAndUserId(
                    contest.getId().getValue(),
                    userResult.get().getId().getValue()
            );
            contestUserResult.ifPresent(contestUser -> contest.setRegistered(true));
        }

        List<ContestQuestion> contestQuestions = contestQuestionRepository
                .findAllContestQuestionsByContestId(contestId);
        for (ContestQuestion contestQuestion : contestQuestions) {
            Question question = contestQuestion.getQuestion();
            Optional<QtypeCodeQuestion> codeQuestion = qtypeCodeQuestionRepository
                    .findQtypeCodeQuestionByQuestionId(question.getId().getValue());
            if (codeQuestion.isEmpty()) {
                log.warn("Could not find code question for question with id: {}",
                        question.getId().getValue());
                throw new QtypeCodeQuestionNotFoundException("Could not find code question for question with id: " +
                        question.getId().getValue());
            }
            contestQuestion.setCodeQuestionId(codeQuestion.get().getId().getValue());
            contestQuestion.setMaxGrade(codeQuestion.get().getMaxGrade());
            if (userResult.isPresent()) {
                contestQuestion.setNumOfSubmissions(
                        codeSubmissionRepository.countAllByUserIdAndCodeQuestionId(
                                userResult.get().getId().getValue(),
                                codeQuestion.get().getId().getValue()
                        )
                );
                Optional<CodeSubmission> codeSubmission = codeSubmissionRepository
                        .findLatestPassedCodeSubmissionByUserIdAndCodeQuestionId(
                                userResult.get().getId().getValue(),
                                codeQuestion.get().getId().getValue()
                        );
                if (codeSubmission.isPresent()) {
                    contestQuestion.setGrade(codeSubmission.get().getGrade());
                    Duration duration = Duration.between(
                            contest.getStartTime(),
                            codeSubmission.get().getCreatedAt()
                    );
                    contestQuestion.setDoTime(duration.toSeconds());
                } else {
                    contestQuestion.setGrade(0F);
                    contestQuestion.setDoTime(0L);
                }
            }
        }
        contest.setQuestions(contestQuestions);

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
    public Page<ContestUser> queryLeaderboardOfContest(
            UUID contestId,
            Integer pageNo,
            Integer pageSize
    ) {
        Page<ContestUser> contestLeaderboardResponseEntities
                = contestUserRepository.findAllContestUsersOfLeaderboard(
                        contestId, pageNo, pageSize);

        // Get all contest questions for each contest user
        for (ContestUser contestUser : contestLeaderboardResponseEntities) {
            // Get and set user details
            User user = getUserHideSensitiveData(contestUser.getUser().getId().getValue());
            contestUser.setUser(user);
            // Get and set contest details
            Contest contest = getContest(contestUser.getContest().getId().getValue());
            contestUser.setContest(contest);

            List<ContestQuestion> contestQuestions = contestQuestionRepository
                    .findAllContestQuestionsByContestId(
                            contestId
                    );
            for (ContestQuestion contestQuestion : contestQuestions) {
                Question question = contestQuestion.getQuestion();
                Optional<QtypeCodeQuestion> codeQuestion = qtypeCodeQuestionRepository
                        .findQtypeCodeQuestionByQuestionId(
                                question.getId().getValue()
                        );
                if (codeQuestion.isEmpty()) {
                    log.warn("Could not find code question for question with id: {}",
                            question.getId().getValue());
                    throw new QtypeCodeQuestionNotFoundException("Could not find code question for question with id: " +
                            question.getId().getValue());
                }
                contestQuestion.setCodeQuestionId(codeQuestion.get().getId().getValue());
                contestQuestion.setMaxGrade(codeQuestion.get().getMaxGrade());
                contestQuestion.setNumOfSubmissions(
                        codeSubmissionRepository.countAllByUserIdAndCodeQuestionId(
                                contestUser.getUser().getId().getValue(),
                                codeQuestion.get().getId().getValue()
                        )
                );
                Optional<CodeSubmission> codeSubmission = codeSubmissionRepository
                        .findLatestPassedCodeSubmissionByUserIdAndCodeQuestionId(
                                contestUser.getUser().getId().getValue(),
                                codeQuestion.get().getId().getValue()
                        );
                if (codeSubmission.isPresent()) {
                    contestQuestion.setGrade(codeSubmission.get().getGrade());
                    Duration duration = Duration.between(
                            contestUser.getContest().getStartTime(),
                            codeSubmission.get().getCreatedAt()
                    );
                    contestQuestion.setDoTime(duration.toSeconds());
                } else {
                    contestQuestion.setGrade(0F);
                    contestQuestion.setDoTime(0L);
                }
            }
            contestUser.setContestQuestions(contestQuestions);
        }

        log.info("Leaderboard of contest with id: {} queried", contestId);
        return contestLeaderboardResponseEntities;
    }

    @Transactional(readOnly = true)
    public ContestUser queryMyRankOfContest(
            UUID contestId,
            String email
    ) {
        Optional<User> userResult = userRepository.findByEmail(email);
        if (userResult.isEmpty()) {
            return null;
        }
        Optional<ContestUser> contestUserResult = contestUserRepository.findMyRankOfContest(
                userResult.get().getId().getValue(),
                contestId
        );
        if (contestUserResult.isEmpty()) {
            return null;
        }
        ContestUser contestUser = contestUserResult.get();

        // Get and set user details
        User user = getUserHideSensitiveData(contestUser.getUser().getId().getValue());
        contestUser.setUser(user);
        // Get and set contest details
        Contest contest = getContest(contestUser.getContest().getId().getValue());
        contestUser.setContest(contest);

        // Get all code questions for the contest user
        List<ContestQuestion> contestQuestions = contestQuestionRepository
                .findAllContestQuestionsByContestId(contestId);
        for (ContestQuestion contestQuestion : contestQuestions) {
            Question question = contestQuestion.getQuestion();
            Optional<QtypeCodeQuestion> codeQuestion = qtypeCodeQuestionRepository
                    .findQtypeCodeQuestionByQuestionId(question.getId().getValue());
            if (codeQuestion.isEmpty()) {
                log.warn("Could not find code question for question with id: {}",
                        question.getId().getValue());
                throw new QtypeCodeQuestionNotFoundException("Could not find code question for question with id: " +
                        question.getId().getValue());
            }
            contestQuestion.setCodeQuestionId(codeQuestion.get().getId().getValue());
            contestQuestion.setMaxGrade(codeQuestion.get().getMaxGrade());
            contestQuestion.setNumOfSubmissions(
                    codeSubmissionRepository.countAllByUserIdAndCodeQuestionId(
                            contestUser.getUser().getId().getValue(),
                            codeQuestion.get().getId().getValue()
                    )
            );
            Optional<CodeSubmission> codeSubmission = codeSubmissionRepository
                    .findLatestPassedCodeSubmissionByUserIdAndCodeQuestionId(
                            contestUser.getUser().getId().getValue(),
                            codeQuestion.get().getId().getValue()
                    );
            if (codeSubmission.isPresent()) {
                contestQuestion.setGrade(codeSubmission.get().getGrade());
                Duration duration = Duration.between(
                        contestUser.getContest().getStartTime(),
                        codeSubmission.get().getCreatedAt()
                );
                contestQuestion.setDoTime(duration.toSeconds());
            } else {
                contestQuestion.setGrade(0F);
                contestQuestion.setDoTime(0L);
            }
        }
        contestUser.setContestQuestions(contestQuestions);

        log.info("My rank of contest with id: {} queried", contestId);
        return contestUser;
    }

    private User getUserHideSensitiveData(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        User userWithGeneralInformation = user.get();
        userWithGeneralInformation.setAddress(null);
        userWithGeneralInformation.setPhone(null);
        userWithGeneralInformation.setDob(null);
        userWithGeneralInformation.setCreatedAt(null);
        userWithGeneralInformation.setUpdatedAt(null);
        userWithGeneralInformation.setDeleted(null);
        return userWithGeneralInformation;
    }

    private Contest getContest(UUID contestId) {
        Optional<Contest> contest = contestRepository.findById(new ContestId(contestId));
        if (contest.isEmpty()) {
            log.warn("Contest with id: {} not found", contestId);
            throw new ContestNotFoundException("Could not find contest with id: " + contestId);
        }
        return contest.get();
    }

    private List<ContestQuestion> getAllContestQuestionsForContest(UUID contestId) {
        List<ContestQuestion> contestQuestion = contestQuestionRepository
                .findAllContestQuestionsByContestId(contestId);

        log.info("All questions queried for contest with id: {}", contestId);
        return contestQuestion;
    }
}





















