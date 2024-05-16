package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.IsRegisteredFilter;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
            String username) {
        Optional<CertificateCourse> certificateCourseResult =
                certificateCourseRepository.findById(new CertificateCourseId(certificateCourseId));
        if (certificateCourseResult.isEmpty()) {
            log.warn("Could not find certificate course with id: {}",
                    certificateCourseId);
            throw new CertificateCourseNotFoundException("Could not find certificate course with id: " +
                    certificateCourseId);
        }
        CertificateCourse certificateCourse = certificateCourseResult.get();
        Optional<User> user = userRepository.findByUsername(username);
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
            String username
    ) {
        switch (isRegisteredFilter) {
            case ALL:
                return certificateCourseRepository.findAllCertificateCourses(
                        courseName,
                        filterTopicIds
                );
            case REGISTERED: {
                Optional<User> user = userRepository.findByUsername(username);
                if (user.isPresent()) {
                    return certificateCourseRepository.findAllCertificateCoursesByIsRegistered(
                            courseName,
                            filterTopicIds,
                            true,
                            user.get().getId().getValue()
                    );
                } else {
                    throw new UserNotFoundException("Could not find user with username: " + username);
                }
            }
            case NOT_REGISTERED: {
                Optional<User> user = userRepository.findByUsername(username);
                if (user.isPresent()) {
                    return certificateCourseRepository.findAllCertificateCoursesByIsRegistered(
                            courseName,
                            filterTopicIds,
                            false,
                            user.get().getId().getValue()
                    );
                } else {
                    throw new UserNotFoundException("Could not find user with username: " + username);
                }
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
            String username
    ) {
        switch (isRegisteredFilter) {
            case ALL:
                return certificateCourseRepository.findMostEnrolledCertificateCourses(
                        courseName,
                        filterTopicIds
                );
            case REGISTERED: {
                Optional<User> user = userRepository.findByUsername(username);
                if (user.isPresent()) {
                    return certificateCourseRepository.findMostEnrolledCertificateCoursesByIsRegistered(
                            courseName,
                            filterTopicIds,
                            true,
                            user.get().getId().getValue()
                    );
                } else {
                    throw new UserNotFoundException("Could not find user with username: " + username);
                }
            }
            case NOT_REGISTERED: {
                Optional<User> user = userRepository.findByUsername(username);
                if (user.isPresent()) {
                    return certificateCourseRepository.findMostEnrolledCertificateCoursesByIsRegistered(
                            courseName,
                            filterTopicIds,
                            false,
                            user.get().getId().getValue()
                    );
                } else {
                    throw new UserNotFoundException("Could not find user with username: " + username);
                }
            }
            default:
                throw new CoreDomainException("Invalid isRegisteredFilter: " + isRegisteredFilter);
        }
    }

    private int countNumOfCompletedQuestions(UUID certificateCourseId, UUID userId) {
        return certificateCourseRepository.countNumOfCompletedQuestions(certificateCourseId, userId);
    }

}





















