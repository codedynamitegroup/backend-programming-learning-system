package com.backend.programming.learning.system.core.service.domain.implement.service.contest;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.contest.PopularContestDTO;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryGeneralStatisticsContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.contest.QueryAllContestsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.ContestResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.QueryLineChartResponse;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.ContestNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.OrganizationNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeCodeQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.contest.ContestDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.redis.ContestRedisService;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
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
import java.time.ZonedDateTime;
import java.util.*;

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
    private final OrganizationRepository organizationRepository;

    public ContestQueryHelper(ContestRedisService contestRedisService,
                              ContestRepository contestRepository,
                              ContestQuestionRepository contestQuestionRepository,
                              ContestUserRepository contestUserRepository,
                              QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
                              CodeSubmissionRepository codeSubmissionRepository,
                              UserRepository userRepository,
                              ContestDataMapper contestDataMapper,
                              OrganizationRepository organizationRepository) {
        this.contestRedisService = contestRedisService;
        this.contestRepository = contestRepository;
        this.contestQuestionRepository = contestQuestionRepository;
        this.contestUserRepository = contestUserRepository;
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.userRepository = userRepository;
        this.contestDataMapper = contestDataMapper;
        this.organizationRepository = organizationRepository;
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
            Boolean isAdmin,
            UUID orgId,
            Boolean isOrgAdmin
    ) {
        log.info("Querying all contests with searchName: {}, startTimeFilter: {}, pageNo: {}, pageSize: {}",
                searchName, startTimeFilter, pageNo, pageSize);

        if (isOrgAdmin) {
            Optional<Organization> organization = organizationRepository.findOrganization(orgId);
            if (organization.isEmpty()) {
                log.warn("Could not find organization with id: {}",
                        orgId);
                throw new OrganizationNotFoundException("Could not find organization with id: " +
                        orgId);
            }
        }

        Page<Contest> contests = null;
        if (
                (searchName == null ||
                        searchName.isEmpty() ||
                        searchName.isBlank()) && startTimeFilter.equals("ALL")
        ) {
            try {
                QueryAllContestsResponse redisResponse = contestRedisService.getAllContests(
                        ContestStartTimeFilter.valueOf(startTimeFilter),
                        pageNo,
                        pageSize,
                        isAdmin,
                        orgId,
                        isOrgAdmin
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
                    contests = contestRepository.findAll(
                            searchName,
                            startTimeFilter,
                            pageNo,
                            pageSize,
                            isAdmin,
                            orgId,
                            isOrgAdmin);
                    QueryAllContestsResponse response = contestDataMapper.contestsToQueryAllContestsResponse(contests);
                    contestRedisService.saveAllContests(
                            response,
                            ContestStartTimeFilter.valueOf(startTimeFilter),
                            pageNo,
                            pageSize,
                            isAdmin,
                            orgId,
                            isOrgAdmin);
                }
            } catch (Exception e) {
                log.error("Error when querying all contests: {}", e.getMessage());
                log.info("Get all contests from database");
                contests = contestRepository.findAll(
                        searchName,
                        startTimeFilter,
                        pageNo,
                        pageSize,
                        isAdmin,
                        orgId,
                        isOrgAdmin);
            }

        } else {
            log.info("Get all contests from database");
            contests = contestRepository.findAll(
                    searchName,
                    startTimeFilter,
                    pageNo,
                    pageSize,
                    isAdmin,
                    orgId,
                    isOrgAdmin);
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
        log.info("Querying my rank of contest with id: {}", contestId);
        Optional<User> userResult = userRepository.findByEmail(email);
        if (userResult.isEmpty()) {
            return null;
        }
        Optional<ContestUser> contestUserResult = contestUserRepository.findMyRankOfContest(
                contestId,
                userResult.get().getId().getValue()
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

    public QueryGeneralStatisticsContestResponse getStatisticContestResponse() {
        List<Contest> allContest;
        try {
            QueryAllContestsResponse redisAllContestResponse = contestRedisService
                    .getAllContests(ContestStartTimeFilter.valueOf("ALL"), 0, 999999999, true, null, false);

            if(redisAllContestResponse == null) {
                allContest = contestRepository
                        .findAll(null, "ALL", 0, 999999999, true, null, false)
                        .getContent();
                contestRedisService.saveAllContests(
                        contestDataMapper.contestsToQueryAllContestsResponse(
                                new PageImpl<>(allContest)
                        ),
                        ContestStartTimeFilter.valueOf("ALL"),
                        0,
                        999999999,
                        true,
                        null,
                        false
                );
            }
            else
                allContest = contestDataMapper.contestResponseEntitiesToContests(
                        new PageImpl<>(redisAllContestResponse.getContests())
                ).getContent();
        } catch (Exception e) {
            log.error("Error when querying all contests: {}", e.getMessage());
            log.info("Get all contests from database");
            allContest = contestRepository
                    .findAll(null, "ALL", 0, 999999999, true, null, false)
                    .getContent();
        }

        long totalContest = allContest.size();
        long totalParticipants = contestUserRepository.countAllParticipants();
        long activeContest = allContest.stream()
                .filter(contest -> contest
                        .getStartTime()
                        .isBefore(ZonedDateTime.now()) && contest.getEndTime() != null  && contest.getEndTime().isAfter(ZonedDateTime.now()))
                .count();
        long closedContest = allContest.stream()
                .filter(contest ->  contest.getEndTime() != null && contest.getEndTime().isBefore(ZonedDateTime.now()))
                .count();
        long upcomingContest = allContest.stream()
                .filter(contest -> contest
                        .getStartTime()
                        .isAfter(ZonedDateTime.now()))
                .count();

        List<PopularContestDTO> popularContests = contestRepository.findPopularContestsBySubmissionAndParticipant();

        return QueryGeneralStatisticsContestResponse.builder()
                .totalContest(totalContest)
                .totalParticipants(totalParticipants)
                .activeContest(activeContest)
                .closedContest(closedContest)
                .upcomingContest(upcomingContest)
                .participantTrend(calculateParticipantTrend(allContest))
                .popularContest(mapPopularContestWithChart(popularContests))
                .popularContestName(popularContests.stream().map(PopularContestDTO::getContestName).toArray(String[]::new))
                .build();
    }

    private List<QueryLineChartResponse> calculateParticipantTrend(List<Contest> contests) {
        if(contests.isEmpty()) {
            return new ArrayList<>();
        }

        // Get contest end in current year
        List<Contest> filteredContest = contests.stream().filter(contest -> contest.getEndTime().getYear() == ZonedDateTime.now().getYear()).toList();
        List<ContestUser> contestUsers = contestUserRepository.findAllContestUser();

        List<QueryLineChartResponse> result = new ArrayList<>();

        final double[] totalContestInMonth = new double[12];
        final double[] totalTrendingRegisterData = new double[12];
        double[] averageTrendingRegisterData;

        // Total participant trend
        contestUsers.forEach(contestUser -> {
            ZonedDateTime startTime = contestUser.getCreatedAt();
            ZonedDateTime currentTime = ZonedDateTime.now();

            if(startTime.getYear() != currentTime.getYear()) {
                return;
            }
            totalTrendingRegisterData[startTime.getMonth().getValue() - 1]++;
        });
        result
                .add(QueryLineChartResponse.builder()
                        .label("Participant")
                        .data(totalTrendingRegisterData)
                        .build());

        // average trending
        // count contest per month
        filteredContest.forEach(contest -> {
            ZonedDateTime endTime = contest.getEndTime();
            ZonedDateTime currentTime = ZonedDateTime.now();

            if(endTime.getYear() != currentTime.getYear()) {
                return;
            }
            totalContestInMonth[endTime.getMonth().getValue() - 1]++;
        });

        // Get total participant in each month from prev calculated array
        averageTrendingRegisterData = totalTrendingRegisterData.clone();
        for (int i = 0; i < 12; i++) {
            if(totalContestInMonth[i] == 0)
                averageTrendingRegisterData[i] = 0;
            else
            {
                double temp = totalTrendingRegisterData[i] / totalContestInMonth[i];
                averageTrendingRegisterData[i] = temp;
            }
        }
        result.add(QueryLineChartResponse.builder()
                .label("Average")
                .data(averageTrendingRegisterData)
                .build());

        return result;
    }

    private List<QueryLineChartResponse> mapPopularContestWithChart( List<PopularContestDTO> popularContests) {
        List<QueryLineChartResponse> result = new ArrayList<>();

        double[] totalSubmission = popularContests.stream().mapToDouble(PopularContestDTO::getTotalSubmissions).toArray();
        double[] totalParticipant = popularContests.stream().mapToDouble(PopularContestDTO::getTotalParticipants).toArray();

        result.add(QueryLineChartResponse.builder()
                .label("Participant")
                .data(totalParticipant)
                .build());
        result.add(QueryLineChartResponse.builder()
                .label("Submission")
                .data(totalSubmission)
                .build());

        return result;
    }
}





















