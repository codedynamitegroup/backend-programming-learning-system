package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryStatisticsOfContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest_user.ContestUserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.ContestNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeCodeQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.contest.ContestDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest.ContestRedisService;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestStartTimeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final ContestRedisService contestRedisService;
    private final ContestRepository contestRepository;
    private final ContestQuestionRepository contestQuestionRepository;
    private final ContestUserRepository contestUserRepository;
    private final QtypeCodeQuestionRepository qtypeCodeQuestionRepository;
    private final CodeSubmissionRepository codeSubmissionRepository;
    private final UserRepository userRepository;
    private final ContestDataMapper contestDataMapper;

    public ContestQueryHelper(ContestRedisService contestRedisService,
                              ContestRepository contestRepository,
                              ContestQuestionRepository contestQuestionRepository,
                              ContestUserRepository contestUserRepository,
                              QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
                              CodeSubmissionRepository codeSubmissionRepository,
                              UserRepository userRepository,
                              ContestDataMapper contestDataMapper) {
        this.contestRedisService = contestRedisService;
        this.contestRepository = contestRepository;
        this.contestQuestionRepository = contestQuestionRepository;
        this.contestUserRepository = contestUserRepository;
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.userRepository = userRepository;
        this.contestDataMapper = contestDataMapper;
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
        User userCreatedBy = getUserHideSensitiveData(contest.getCreatedBy().getId().getValue());
        contest.setCreatedBy(userCreatedBy);
        User userUpdatedBy = getUserHideSensitiveData(contest.getUpdatedBy().getId().getValue());
        contest.setUpdatedBy(userUpdatedBy);

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
                        codeSubmissionRepository.countAllByUserIdAndCodeQuestionIdAndContestId(
                                userResult.get().getId().getValue(),
                                codeQuestion.get().getId().getValue(),
                                contestId
                        )
                );
                Optional<CodeSubmission> codeSubmission = codeSubmissionRepository
                        .findLatestPassedCodeSubmissionByUserIdAndCodeQuestionIdAndContestId(
                                userResult.get().getId().getValue(),
                                codeQuestion.get().getId().getValue(),
                                contestId
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
            String email,
            Boolean isAdmin
    ) {
        log.info("Querying all contests with searchName: {}, startTimeFilter: {}, pageNo: {}, pageSize: {}",
                searchName, startTimeFilter, pageNo, pageSize);

        Page<Contest> contests = null;
        if (
                searchName == null ||
                        searchName.isEmpty() ||
                        searchName.isBlank()
        ) {
            QueryAllContestsResponse redisResponse = contestRedisService.getAllContests(
                    ContestStartTimeFilter.valueOf(startTimeFilter),
                    pageNo,
                    pageSize,
                    isAdmin
            );
            if (redisResponse != null) {
                log.info("Get all contests from redis");
                List<ContestResponseEntity> contestResponseEntities = redisResponse.getContests();
                Pageable pageable = PageRequest.of(redisResponse.getCurrentPage(), pageSize);
                Page<ContestResponseEntity> contestResponseEntityPage =
                        new PageImpl<>(contestResponseEntities, pageable, redisResponse.getTotalItems());
                contests = contestDataMapper.contestResponseEntitiesToContests(contestResponseEntityPage);
            } else {
                log.info("Get all contests from database");
                contests = contestRepository.findAll(searchName, startTimeFilter, pageNo, pageSize, isAdmin);
                QueryAllContestsResponse response = contestDataMapper.contestsToQueryAllContestsResponse(contests);
                contestRedisService.saveAllContests(response, ContestStartTimeFilter.valueOf(startTimeFilter), pageNo, pageSize, isAdmin);
            }
        } else {
            log.info("Get all contests from database");
            contests = contestRepository.findAll(searchName, startTimeFilter, pageNo, pageSize, isAdmin);
        }

        Optional<User> userResult = userRepository.findByEmail(email);
        if (contests != null) {
            for (Contest contest : contests) {
                contest.setQuestions(new ArrayList<>());
                if (userResult.isPresent()) {
                    Optional<ContestUser> contestUserResult = contestUserRepository.findByContestIdAndUserId(
                            contest.getId().getValue(),
                            userResult.get().getId().getValue()
                    );
                    contestUserResult.ifPresent(contestUser -> contest.setRegistered(true));
                }

                User userCreatedBy = getUserHideSensitiveData(contest.getCreatedBy().getId().getValue());
                contest.setCreatedBy(userCreatedBy);
                User userUpdatedBy = getUserHideSensitiveData(contest.getUpdatedBy().getId().getValue());
                contest.setUpdatedBy(userUpdatedBy);
            }
        }
        return contests;
    }

    @Transactional(readOnly = true)
    public Page<Contest> queryAllMyContests(
            String searchName,
            Integer pageNo,
            Integer pageSize,
            String email
    ) {
        log.info("Querying all my contests with searchName: {}, pageNo: {}, pageSize: {}",
                searchName, pageNo, pageSize);

        User user = getUserByEmail(email);

        Page<Contest> contests = contestRepository.findAllMyContests(searchName, user.getId().getValue(), pageNo, pageSize);

        if (contests != null) {
            for (Contest contest : contests) {
                contest.setQuestions(new ArrayList<>());
                Optional<ContestUser> contestUserResult = contestUserRepository.findByContestIdAndUserId(
                        contest.getId().getValue(),
                        user.getId().getValue()
                );
                contestUserResult.ifPresent(contestUser -> contest.setRegistered(true));

                User userCreatedBy = getUserHideSensitiveData(contest.getCreatedBy().getId().getValue());
                contest.setCreatedBy(userCreatedBy);
                User userUpdatedBy = getUserHideSensitiveData(contest.getUpdatedBy().getId().getValue());
                contest.setUpdatedBy(userUpdatedBy);
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
            User userCreatedBy = getUserHideSensitiveData(contest.getCreatedBy().getId().getValue());
            contest.setCreatedBy(userCreatedBy);
            User userUpdatedBy = getUserHideSensitiveData(contest.getUpdatedBy().getId().getValue());
            contest.setUpdatedBy(userUpdatedBy);
        }
        return contestList;
    }

    @Transactional(readOnly = true)
    public List<ContestQuestion> queryAllContestQuestionsByContestId(UUID contestId) {
        log.info("Querying all contest questions by contest id");
        List<ContestQuestion> contestQuestions = contestQuestionRepository.findAllContestQuestionsByContestId(contestId);
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
            contestQuestion.setNumOfCorrectSubmissions(
                    codeSubmissionRepository.countAllPassedCodeSubmissionsByCodeQuestionIdAndContestId(
                            codeQuestion.get().getId().getValue(),
                            contestId
                    )
            );
            contestQuestion.setNumOfSubmissions(
                    codeSubmissionRepository.countAllCodeSubmissionsByCodeQuestionIdAndContestId(
                            codeQuestion.get().getId().getValue(),
                            contestId
                    )
            );
        }
        return contestQuestions;
    }

    @Transactional(readOnly = true)
    public int countAllParticipants() {
        log.info("Counting all participants");
        return contestUserRepository.countAllParticipants();
    }

    @Transactional(readOnly = true)
    public int countAllParticipantsByContestId(UUID contestId) {
        log.info("Counting all participants by contest id: {}", contestId);
        return contestUserRepository.countAllParticipantsByContestId(contestId);
    }

    @Transactional(readOnly = true)
    public int countAllParticipantsHavingSubmissionsByContestId(UUID contestId) {
        log.info("Counting all participants having submissions by contest id: {}", contestId);
        return contestUserRepository.countAllParticipantsHavingSubmissionsByContestId(contestId);
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
                        codeSubmissionRepository.countAllByUserIdAndCodeQuestionIdAndContestId(
                                contestUser.getUser().getId().getValue(),
                                codeQuestion.get().getId().getValue(),
                                contestId
                        )
                );
                Optional<CodeSubmission> codeSubmission = codeSubmissionRepository
                        .findLatestPassedCodeSubmissionByUserIdAndCodeQuestionIdAndContestId(
                                contestUser.getUser().getId().getValue(),
                                codeQuestion.get().getId().getValue(),
                                contestId
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
                    codeSubmissionRepository.countAllByUserIdAndCodeQuestionIdAndContestId(
                            contestUser.getUser().getId().getValue(),
                            codeQuestion.get().getId().getValue(),
                            contestId
                    )
            );
            Optional<CodeSubmission> codeSubmission = codeSubmissionRepository
                    .findLatestPassedCodeSubmissionByUserIdAndCodeQuestionIdAndContestId(
                            contestUser.getUser().getId().getValue(),
                            codeQuestion.get().getId().getValue(),
                            contestId
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

    private User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email: {} not found", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
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





















