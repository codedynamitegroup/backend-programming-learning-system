package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.IsRegisteredFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CertificateCourseQueryHelper {
    private final CertificateCourseRepository certificateCourseRepository;
    private final UserRepository userRepository;
    private final CertificateCourseUserRepository certificateCourseUserRepository;

    public CertificateCourseQueryHelper(CertificateCourseRepository certificateCourseRepository,
                                        UserRepository userRepository,
                                        CertificateCourseUserRepository certificateCourseUserRepository) {
        this.certificateCourseRepository = certificateCourseRepository;
        this.userRepository = userRepository;
        this.certificateCourseUserRepository = certificateCourseUserRepository;
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
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            Optional<CertificateCourseUser> certificateCourseUser =
                    certificateCourseUserRepository.findByCertificateCourseIdAndUserId(
                            certificateCourseId,
                            user.get().getId().getValue()
                    );
            if (certificateCourseUser.isPresent()) {
                certificateCourse.setRegistered(true);
                certificateCourse.setNumOfCompletedQuestions(
                        countNumOfCompletedQuestions(certificateCourseId, user.get().getId().getValue())
                );
            } else {
                certificateCourse.setRegistered(false);
                certificateCourse.setNumOfCompletedQuestions(0);
            }
        }
        log.info("Certificate course queried with id: {}", certificateCourse.getId().getValue());
        return certificateCourse;
    }

    @Transactional(readOnly = true)
    public List<CertificateCourse> queryAllCertificateCourses(
            String courseName,
            List<UUID> filterTopicIds,
            IsRegisteredFilter isRegisteredFilter,
            String email
    ) {
        switch (isRegisteredFilter) {
            case ALL:
                return certificateCourseRepository.findAllCertificateCourses(
                        courseName,
                        filterTopicIds
                );
            case REGISTERED: {
                User user = getUserByEmail(email);
                List<CertificateCourse> certificateCourseList =
                        certificateCourseRepository.findAllCertificateCoursesByIsRegistered(
                        courseName,
                        filterTopicIds,
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
                        certificateCourse.setNumOfCompletedQuestions(
                                countNumOfCompletedQuestions(
                                        certificateCourse.getId().getValue(),
                                        user.getId().getValue())
                        );
                    } else {
                        certificateCourse.setRegistered(false);
                        certificateCourse.setNumOfCompletedQuestions(0);
                    }
                }
                return certificateCourseList;
            }
            case NOT_REGISTERED: {
                User user = getUserByEmail(email);
                List<CertificateCourse> certificateCourseList =
                        certificateCourseRepository.findAllCertificateCoursesByIsRegistered(
                        courseName,
                        filterTopicIds,
                        false,
                        user.getId().getValue()
                );
                for (CertificateCourse certificateCourse : certificateCourseList) {
                    certificateCourse.setRegistered(false);
                }
                return certificateCourseList;
            }
            default:
                throw new CoreDomainException("Invalid isRegisteredFilter: " + isRegisteredFilter);
        }
    }

    @Transactional(readOnly = true)
    public List<CertificateCourse> queryMostEnrolledCertificateCourses(
            String courseName,
            List<UUID> filterTopicIds,
            IsRegisteredFilter isRegisteredFilter,
            String email
    ) {
        switch (isRegisteredFilter) {
            case ALL:
                return certificateCourseRepository.findMostEnrolledCertificateCourses(
                        courseName,
                        filterTopicIds
                );
            case REGISTERED: {
                User user = getUserByEmail(email);
                List<CertificateCourse> certificateCourseList =
                        certificateCourseRepository.findMostEnrolledCertificateCoursesByIsRegistered(
                        courseName,
                        filterTopicIds,
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
                        certificateCourse.setNumOfCompletedQuestions(
                                countNumOfCompletedQuestions(
                                        certificateCourse.getId().getValue(),
                                        user.getId().getValue())
                        );
                    } else {
                        certificateCourse.setRegistered(false);
                        certificateCourse.setNumOfCompletedQuestions(0);
                    }
                }
                return certificateCourseList;

            }
            case NOT_REGISTERED: {
                User user = getUserByEmail(email);
                List<CertificateCourse> certificateCourseList =
                        certificateCourseRepository.findMostEnrolledCertificateCoursesByIsRegistered(
                        courseName,
                        filterTopicIds,
                        false,
                        user.getId().getValue()
                );
                for (CertificateCourse certificateCourse : certificateCourseList) {
                    certificateCourse.setRegistered(false);
                }
                return certificateCourseList;
            }
            default:
                throw new CoreDomainException("Invalid isRegisteredFilter: " + isRegisteredFilter);
        }
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

    private int countNumOfCompletedQuestions(UUID certificateCourseId, UUID userId) {
        return certificateCourseRepository.countNumOfCompletedQuestions(certificateCourseId, userId);
    }

}





















