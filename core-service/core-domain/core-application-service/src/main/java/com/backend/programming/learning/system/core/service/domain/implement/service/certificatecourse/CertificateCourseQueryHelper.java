package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.QueryAllCertificateCourseWithPageResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryAllCertificateCoursesResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.certificatecourse.QueryGeneralCertificateCourseStatisticsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.certificatecourse.MostEnrolledWithStudentResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapterResource.ChapterResourceCount;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.QueryLineChartResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.contest.QueryPieChartResponse;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.certificatecourse.CertificateCourseRedisService;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.IsRegisteredFilter;
import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CertificateCourseQueryHelper {
    private final CertificateCourseRepository certificateCourseRepository;
    private final UserRepository userRepository;
    private final CertificateCourseUserRepository certificateCourseUserRepository;
    private final ChapterResourceRepository chapterResourceRepository;
    private final TopicRepository topicRepository;
    private final QtypeCodeQuestionRepository qtypeCodeQuestionRepository;
    private final CertificateCourseDataMapper certificateCourseDataMapper;
    private final CertificateCourseRedisService certificateCourseRedisService;

    public CertificateCourseQueryHelper(CertificateCourseRepository certificateCourseRepository,
                                        UserRepository userRepository,
                                        CertificateCourseUserRepository certificateCourseUserRepository,
                                        ChapterResourceRepository chapterResourceRepository,
                                        TopicRepository topicRepository,
                                        QtypeCodeQuestionRepository qtypeCodeQuestionRepository,
                                        CertificateCourseDataMapper certificateCourseDataMapper,
                                        CertificateCourseRedisService certificateCourseRedisService) {
        this.certificateCourseRepository = certificateCourseRepository;
        this.userRepository = userRepository;
        this.certificateCourseUserRepository = certificateCourseUserRepository;
        this.chapterResourceRepository = chapterResourceRepository;
        this.topicRepository = topicRepository;
        this.qtypeCodeQuestionRepository = qtypeCodeQuestionRepository;
        this.certificateCourseDataMapper = certificateCourseDataMapper;
        this.certificateCourseRedisService = certificateCourseRedisService;
    }

    @Transactional(readOnly = true)
    public CertificateCourse queryCertificateCourseById(
            UUID certificateCourseId,
            String email) {
        Optional<CertificateCourse> certificateCourseResult =
                certificateCourseRepository.findById(new CertificateCourseId(certificateCourseId));
        if (certificateCourseResult.isEmpty()) {
            log.warn("Could not find certificate course with id: {}",
                    certificateCourseId);
            throw new CertificateCourseNotFoundException("Could not find certificate course with id: " +
                    certificateCourseId);
        }
        CertificateCourse certificateCourse = certificateCourseResult.get();

        if (email != null) {
            Optional<User> userOptional = userRepository.findByEmail(email);
            if (userOptional.isPresent()) {
                Optional<ChapterResource> currentChapterResource = chapterResourceRepository
                        .findFirstUncompletedResourceByCertificateCourseIdAndUserId(
                                certificateCourse.getId().getValue(),
                                userOptional.get().getId().getValue()
                        );

                log.info("currentChapterResource: {}",  currentChapterResource.get().getId());
                if (currentChapterResource.isPresent()
                        && currentChapterResource.get().getResourceType().equals(ResourceType.CODE)
                        && currentChapterResource.get().getQuestion() != null) {
                    Optional<QtypeCodeQuestion> qtypeCodeQuestion = qtypeCodeQuestionRepository
                            .findQtypeCodeQuestionByQuestionId(currentChapterResource.get().getQuestion().getId().getValue());
                    qtypeCodeQuestion.ifPresent(value -> currentChapterResource.get().setCodeQuestionId(value.getId().getValue()));
                }
                currentChapterResource.ifPresent(
                        certificateCourse::setCurrentResource
                );

                Optional<CertificateCourseUser> certificateCourseUser =
                        certificateCourseUserRepository.findByCertificateCourseIdAndUserId(
                                certificateCourseId,
                                userOptional.get().getId().getValue()
                        );
                if (certificateCourseUser.isPresent()) {
                    certificateCourse.setRegistered(true);
                    certificateCourse.setNumOfCompletedResources(
                            countNumOfCompletedResources(certificateCourseId, userOptional.get().getId().getValue())
                    );
                } else {
                    certificateCourse.setRegistered(false);
                    certificateCourse.setNumOfCompletedResources(0);
                }
            }
        }

        certificateCourse.setNumOfResources(countNumOfResources(certificateCourseId));
        certificateCourse.setNumOfStudents(countNumOfStudents(certificateCourseId));
        certificateCourse.setNumOfReviews(countNumOfReviews(certificateCourseId));
        log.info("Certificate course queried with id: {}", certificateCourse.getId().getValue());
        return certificateCourse;
    }

    @Transactional(readOnly = true)
    public List<CertificateCourse> queryAllCertificateCourses(
            String courseName,
            UUID filterTopicId,
            IsRegisteredFilter isRegisteredFilter,
            String email
    ) {
        switch (isRegisteredFilter) {
            case ALL: {
                List<CertificateCourse> certificateCourseList = new ArrayList<>();
                if (courseName == null || courseName.isEmpty() || courseName.isBlank()) {
                    QueryAllCertificateCoursesResponse redisResponse = certificateCourseRedisService.getAllCertificateCourses(
                            courseName,
                            filterTopicId
                    );
                    if (redisResponse != null) {
                        certificateCourseList = certificateCourseDataMapper
                                .queryAllCertificateCoursesResponseToCertificateCourses(redisResponse);
                    } else {
                        log.info("Querying all certificate courses from database");
                        certificateCourseList = certificateCourseRepository.findAllCertificateCourses(
                                courseName,
                                filterTopicId
                        );
                        // save to redis
                        log.info("Saving all certificate courses to redis");
                        QueryAllCertificateCoursesResponse queryAllCertificateCoursesCommand = certificateCourseDataMapper
                                .certificateCoursesToQueryAllCertificateCoursesResponse(certificateCourseList);
                        certificateCourseRedisService.saveAllCertificateCourses(
                                queryAllCertificateCoursesCommand,
                                courseName,
                                filterTopicId
                        );
                    }
                } else {
                    log.info("Querying all certificate courses from database");
                    certificateCourseList = certificateCourseRepository.findAllCertificateCourses(
                            courseName,
                            filterTopicId
                    );
                }

                Optional<User> userOptional = email != null ? userRepository.findByEmail(email): Optional.empty();

                for (CertificateCourse certificateCourse : certificateCourseList) {
                    if (userOptional.isPresent()) {
                        Optional<CertificateCourseUser> certificateCourseUser =
                                certificateCourseUserRepository.findByCertificateCourseIdAndUserId(
                                        certificateCourse.getId().getValue(),
                                        userOptional.get().getId().getValue()
                                );
                        if (certificateCourseUser.isPresent()) {
                            certificateCourse.setRegistered(true);
                            certificateCourse.setNumOfCompletedResources(
                                    countNumOfCompletedResources(
                                            certificateCourse.getId().getValue(),
                                            userOptional.get().getId().getValue())
                            );
                        } else {
                            certificateCourse.setRegistered(false);
                            certificateCourse.setNumOfCompletedResources(0);
                        }
                        Optional<ChapterResource> currentChapterResource = chapterResourceRepository
                                .findFirstUncompletedResourceByCertificateCourseIdAndUserId(
                                        certificateCourse.getId().getValue(),
                                        userOptional.get().getId().getValue()
                                );

                        if (currentChapterResource.isPresent()
                                && currentChapterResource.get().getResourceType().equals(ResourceType.CODE)
                                && currentChapterResource.get().getQuestion() != null) {
                            Optional<QtypeCodeQuestion> qtypeCodeQuestion = qtypeCodeQuestionRepository
                                    .findQtypeCodeQuestionByQuestionId(currentChapterResource.get().getQuestion().getId().getValue());
                            qtypeCodeQuestion.ifPresent(value -> currentChapterResource.get().setCodeQuestionId(value.getId().getValue()));
                        }

                        currentChapterResource.ifPresent(
                                certificateCourse::setCurrentResource
                        );
                    }

                    certificateCourse.setNumOfResources(countNumOfResources(certificateCourse.getId().getValue()));
                    certificateCourse.setNumOfStudents(countNumOfStudents(certificateCourse.getId().getValue()));
                    certificateCourse.setNumOfReviews(countNumOfReviews(certificateCourse.getId().getValue()));

                }
                return certificateCourseList;
            }
            case REGISTERED: {
                User user = getUserByEmail(email);
                List<CertificateCourse> certificateCourseList =
                        certificateCourseRepository.findAllCertificateCoursesByIsRegistered(
                        courseName,
                        filterTopicId,
                        true,
                        user.getId().getValue()
                );
                for (CertificateCourse certificateCourse : certificateCourseList) {
                    Optional<CertificateCourseUser> certificateCourseUser =
                            certificateCourseUserRepository.findByCertificateCourseIdAndUserId(
                                    certificateCourse.getId().getValue(),
                                    user.getId().getValue()
                            );
                    if (certificateCourseUser.isPresent()) {
                        certificateCourse.setRegistered(true);
                        certificateCourse.setNumOfCompletedResources(
                                countNumOfCompletedResources(
                                        certificateCourse.getId().getValue(),
                                        user.getId().getValue())
                        );
                    } else {
                        certificateCourse.setRegistered(false);
                        certificateCourse.setNumOfCompletedResources(0);
                    }
                    certificateCourse.setNumOfResources(countNumOfResources(certificateCourse.getId().getValue()));
                    certificateCourse.setNumOfStudents(countNumOfStudents(certificateCourse.getId().getValue()));
                    certificateCourse.setNumOfReviews(countNumOfReviews(certificateCourse.getId().getValue()));

                    Optional<ChapterResource> currentChapterResource = chapterResourceRepository
                            .findFirstUncompletedResourceByCertificateCourseIdAndUserId(
                                    certificateCourse.getId().getValue(),
                                    user.getId().getValue()
                            );
                    if (currentChapterResource.isPresent()
                            && currentChapterResource.get().getResourceType().equals(ResourceType.CODE)
                            && currentChapterResource.get().getQuestion() != null) {
                        Optional<QtypeCodeQuestion> qtypeCodeQuestion = qtypeCodeQuestionRepository
                                .findQtypeCodeQuestionByQuestionId(currentChapterResource.get().getQuestion().getId().getValue());
                        qtypeCodeQuestion.ifPresent(value -> currentChapterResource.get().setCodeQuestionId(value.getId().getValue()));
                    }

                    currentChapterResource.ifPresent(
                            certificateCourse::setCurrentResource
                    );
                }
                return certificateCourseList;
            }
            case NOT_REGISTERED: {
//                User user = getUserByEmail(email);
//                List<CertificateCourse> certificateCourseList =
//                        certificateCourseRepository.findAllCertificateCoursesByIsRegistered(
//                        courseName,
//                        filterTopicId,
//                        false,
//                        user.getId().getValue()
//                );
//                for (CertificateCourse certificateCourse : certificateCourseList) {
//                    certificateCourse.setRegistered(false);
//                    certificateCourse.setNumOfResources(countNumOfResources(certificateCourse.getId().getValue()));
//                    certificateCourse.setNumOfStudents(countNumOfStudents(certificateCourse.getId().getValue()));
//                    certificateCourse.setNumOfReviews(countNumOfReviews(certificateCourse.getId().getValue()));
//                }
                return new ArrayList<>();
            }
            default:
                throw new CoreDomainException("Invalid isRegisteredFilter: " + isRegisteredFilter);
        }
    }

    @Transactional(readOnly = true)
    public List<CertificateCourse> queryMostEnrolledCertificateCourses(
            String email
    ) {
        Optional<User> userOptional = email != null ? userRepository.findByEmail(email): Optional.empty();

        List<CertificateCourse> certificateCourseList;
        if (userOptional.isEmpty()) {
            certificateCourseList = certificateCourseRepository
                            .findMostEnrolledCertificateCourses();
        } else {
            // Get all topic ids of registered courses by user
            List<Topic> topicIds = topicRepository
                    .findAllTopicsOfRegisteredCertificateCoursesByUserId(
                            userOptional.get().getId().getValue()
                    );
            List<UUID> topicIdsList = new ArrayList<>();
            for (Topic topic : topicIds) {
                topicIdsList.add(topic.getId().getValue());
            }
            certificateCourseList = certificateCourseRepository
                    .findMostEnrolledCertificateCoursesByTopicIds(topicIdsList);
            if (certificateCourseList.size() < 5) {
                List<CertificateCourse> all = certificateCourseRepository
                        .findMostEnrolledCertificateCourses();
                for (CertificateCourse certificateCourse : all) {
                    if (!certificateCourseList.contains(certificateCourse)) {
                        certificateCourseList.add(certificateCourse);
                    }
                }
            }
        }


        for (CertificateCourse certificateCourse : certificateCourseList) {
            if (userOptional.isPresent()) {
                Optional<CertificateCourseUser> certificateCourseUser =
                        certificateCourseUserRepository.findByCertificateCourseIdAndUserId(
                                certificateCourse.getId().getValue(),
                                userOptional.get().getId().getValue()
                        );
                if (certificateCourseUser.isPresent()) {
                    certificateCourse.setRegistered(true);
                    certificateCourse.setNumOfCompletedResources(
                            countNumOfCompletedResources(
                                    certificateCourse.getId().getValue(),
                                    userOptional.get().getId().getValue())
                    );
                } else {
                    certificateCourse.setRegistered(false);
                    certificateCourse.setNumOfCompletedResources(0);
                }
            }

            certificateCourse.setNumOfResources(countNumOfResources(certificateCourse.getId().getValue()));
            certificateCourse.setNumOfStudents(countNumOfStudents(certificateCourse.getId().getValue()));
            certificateCourse.setNumOfReviews(countNumOfReviews(certificateCourse.getId().getValue()));
        }
        return certificateCourseList;
    }

    private User getUserByEmail(String email) {
        if (email == null) {
            log.warn("User not found with email: null");
            throw new UserNotFoundException("Could not find user with email: null");
        }
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isEmpty()) {
            log.warn("User not found with email: {}", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
    }

    private int countNumOfCompletedResources(UUID certificateCourseId, UUID userId) {
        return certificateCourseRepository.countNumOfCompletedResources(certificateCourseId, userId);
    }

    private int countNumOfResources(UUID certificateCourseId) {
        return certificateCourseRepository.countNumOfResourcesByCertificateId(certificateCourseId);
    }

    private int countNumOfStudents(UUID certificateCourseId) {
        return certificateCourseRepository.countNumOfStudentsByCertificateId(certificateCourseId);
    }

    private int countNumOfReviews(UUID certificateCourseId) {
        return certificateCourseRepository.countNumOfReviewsByCertificateId(certificateCourseId);
    }

    public QueryGeneralCertificateCourseStatisticsResponse queryGeneralCertificateCourseStatistics() {
        List<CertificateCourse> certificateCourseList = certificateCourseRepository.findAllCourse();
        List<CertificateCourseUser> certificateCourseUserList = certificateCourseUserRepository.findAllCourseUser();

        // TODO: implement completed course (use 2 methods and calculate the average, if its > 85 --> pass)
        long completedCourses = certificateCourseUserList.stream().filter(CertificateCourseUser::getCompleted).count();
        double averageRating = certificateCourseList.stream().mapToDouble(CertificateCourse::getAvgRating).average().orElse(0.0);

        return QueryGeneralCertificateCourseStatisticsResponse.builder()
                .totalCertificateCourse(certificateCourseList.size())
                .totalEnrollments(certificateCourseUserList.size())
                .totalParticipantCompletedCourse(completedCourses)
                .averageRating(averageRating)
                .enrollmentChart(calculateEnrollmentChart(certificateCourseUserList))
                .topEnrolledCourse(getTopEnrolledCourse())
                .chapterResourceType(calculateChapterResourceType())
                .build();
    }

    private List<QueryLineChartResponse> calculateEnrollmentChart(List<CertificateCourseUser> certificateCourseUserList) {
        if(certificateCourseUserList.isEmpty()) {
            return new ArrayList<>();
        }

        List<QueryLineChartResponse> result = new ArrayList<>();
        QueryLineChartResponse filterByDaysInWeek;
        QueryLineChartResponse filterByDaysInMonth;
        QueryLineChartResponse filterByDaysInYear;

        final double[] daysInWeekRegisterData = new double[7];
        final double[] daysInMonthRegisterData = new double[ZonedDateTime.now().getMonth().length(ZonedDateTime.now().toLocalDate().isLeapYear())];
        final double[] daysInYearRegisterData = new double[12];

        // Days in week
        certificateCourseUserList.forEach(user -> {
            ZonedDateTime registerDate = user.getCreatedAt();
            ZonedDateTime currentDate = ZonedDateTime.now();

            if(registerDate.getYear() != currentDate.getYear() ||
                    registerDate.getMonth() != currentDate.getMonth()) {
                return;
            }

            long differenceInDays = Duration.between(registerDate, currentDate).toDays();

            if(differenceInDays <= 7) {
                daysInWeekRegisterData[registerDate.getDayOfWeek().getValue() - 1]++;
            }
        });
        filterByDaysInWeek = QueryLineChartResponse.builder()
                .label("New enrollment(s)")
                .data(daysInWeekRegisterData)
                .build();

        // Days in month
        certificateCourseUserList.forEach(user -> {
            ZonedDateTime registerDate = user.getCreatedAt();
            ZonedDateTime currentDate = ZonedDateTime.now();

            if(registerDate.getYear() != currentDate.getYear() || registerDate.getMonth() != currentDate.getMonth()) {
                return;
            }
            daysInMonthRegisterData[registerDate.getDayOfMonth() - 1]++;
        });
        filterByDaysInMonth = QueryLineChartResponse.builder()
                .label("New enrollment(s)")
                .data(daysInMonthRegisterData)
                .build();

        // Days in year
        certificateCourseUserList.forEach(user -> {
            ZonedDateTime registerDate = user.getCreatedAt();
            ZonedDateTime currentDate = ZonedDateTime.now();

            if(registerDate.getYear() != currentDate.getYear()) {
                return;
            }
            daysInYearRegisterData[registerDate.getMonth().getValue() - 1]++;
        });
        filterByDaysInYear = QueryLineChartResponse.builder()
                .label("New enrollment(s)")
                .data(daysInYearRegisterData)
                .build();

        result.add(filterByDaysInWeek);
        result.add(filterByDaysInMonth);
        result.add(filterByDaysInYear);

        return result;
    }

    private List<QueryLineChartResponse> getTopEnrolledCourse() {
        List<MostEnrolledWithStudentResponse> topEnrolledCourses = certificateCourseRepository.findMostEnrolledCertificateCourseWithStudentCount();
        List<QueryLineChartResponse> result = new ArrayList<>();

        topEnrolledCourses.forEach(certificateCourse -> {
            QueryLineChartResponse queryLineChartResponse = QueryLineChartResponse.builder()
                    .label(certificateCourse.getCertificateCourseName())
                    .data(new double[]{certificateCourse.getNumOfStudents()})
                    .build();
            result.add(queryLineChartResponse);
        });

        return result;
    }

    private List<QueryPieChartResponse> calculateChapterResourceType() {
        List<ChapterResourceCount> chapterResources = chapterResourceRepository.countResourceByType();
        List<QueryPieChartResponse> result = new ArrayList<>();

        for (int i = 0; i < ResourceType.values().length; i++) {
            QueryPieChartResponse queryPieChartResponse = QueryPieChartResponse.builder()
                    .index(i)
                    .label(chapterResources.get(i).getResourceType().name())
                    .value(chapterResources.get(i).getCount())
                    .build();
            result.add(queryPieChartResponse);
        }

        return result;
    }

    @Transactional(readOnly = true)
    public QueryAllCertificateCourseWithPageResponse queryAllCertificateCourse(Integer pageNo, Integer pageSize, String searchName) {
        Page<CertificateCourse> certificateCourses = certificateCourseRepository.findAllCertificateCourses(pageNo, pageSize, searchName);

        log.info("All certificate courses queried: {}", certificateCourses);
        return certificateCourseDataMapper.certificateCoursesPageToQueryAllCertificateCourseWithPageResponse(certificateCourses);
    }
}





















