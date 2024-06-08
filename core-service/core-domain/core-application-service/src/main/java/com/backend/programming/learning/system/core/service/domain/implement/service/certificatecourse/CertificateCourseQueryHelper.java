package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.IsRegisteredFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    public CertificateCourseQueryHelper(CertificateCourseRepository certificateCourseRepository,
                                        UserRepository userRepository,
                                        CertificateCourseUserRepository certificateCourseUserRepository,
                                        ChapterResourceRepository chapterResourceRepository,
                                        TopicRepository topicRepository) {
        this.certificateCourseRepository = certificateCourseRepository;
        this.userRepository = userRepository;
        this.certificateCourseUserRepository = certificateCourseUserRepository;
        this.chapterResourceRepository = chapterResourceRepository;
        this.topicRepository = topicRepository;
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
                List<CertificateCourse> certificateCourseList = certificateCourseRepository.findAllCertificateCourses(
                        courseName,
                        filterTopicId
                );
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
                    currentChapterResource.ifPresent(
                            certificateCourse::setCurrentResource
                    );
                }
                return certificateCourseList;
            }
            case NOT_REGISTERED: {
                User user = getUserByEmail(email);
                List<CertificateCourse> certificateCourseList =
                        certificateCourseRepository.findAllCertificateCoursesByIsRegistered(
                        courseName,
                        filterTopicId,
                        false,
                        user.getId().getValue()
                );
                for (CertificateCourse certificateCourse : certificateCourseList) {
                    certificateCourse.setRegistered(false);
                    certificateCourse.setNumOfResources(countNumOfResources(certificateCourse.getId().getValue()));
                    certificateCourse.setNumOfStudents(countNumOfStudents(certificateCourse.getId().getValue()));
                    certificateCourse.setNumOfReviews(countNumOfReviews(certificateCourse.getId().getValue()));
                }
                return certificateCourseList;
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
            log.info("Topic ids of registered courses by user: {}", topicIdsList);
            certificateCourseList = certificateCourseRepository
                    .findMostEnrolledCertificateCoursesByTopicIds(topicIdsList);
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

}





















