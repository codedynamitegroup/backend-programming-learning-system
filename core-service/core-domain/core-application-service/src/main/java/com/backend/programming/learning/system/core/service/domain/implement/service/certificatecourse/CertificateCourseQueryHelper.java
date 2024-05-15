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
    public CertificateCourse queryCertificateCourseById(UUID certificateCourseId) {
        Optional<CertificateCourse> certificateCourseResult =
                certificateCourseRepository.findById(new CertificateCourseId(certificateCourseId));
        if (certificateCourseResult.isEmpty()) {
            log.warn("Could not find certificate course with id: {}",
                    certificateCourseId);
            throw new CertificateCourseNotFoundException("Could not find certificate course with id: " +
                    certificateCourseId);
        }
        CertificateCourse certificateCourse = certificateCourseResult.get();
        log.info("Certificate course queried with id: {}", certificateCourse.getId().getValue());
        return certificateCourse;
    }

    @Transactional(readOnly = true)
    public List<CertificateCourse> queryAllCertificateCourses(
            String courseName,
            List<UUID> filterTopicIds
    ) {
        return certificateCourseRepository.findAllCertificateCourses(
                courseName,
                filterTopicIds
        );
    }

    @Transactional(readOnly = true)
    public List<CertificateCourse> queryAllCertificateCoursesFilterByIsRegistered(
            String courseName,
            List<UUID> filterTopicIds,
            boolean isRegistered,
            String username
    ) {
        UserId userId = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Could not find user with username: " + username))
                .getId();
        return certificateCourseRepository.findAllCertificateCoursesByIsRegistered(
                courseName,
                filterTopicIds,
                isRegistered,
                userId.getValue()
        );
    }

    @Transactional(readOnly = true)
    public List<CertificateCourse> queryMostEnrolledCertificateCourses(
            String courseName,
            List<UUID> filterTopicIds
    ) {
        return certificateCourseRepository.findMostEnrolledCertificateCourses(
                courseName,
                filterTopicIds
        );
    }

    @Transactional(readOnly = true)
    public List<CertificateCourse> queryMostEnrolledCertificateCoursesFilterByIsRegistered(
            String courseName,
            List<UUID> filterTopicIds,
            boolean isRegistered,
            String username
    ) {
        UserId userId = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Could not find user with username: " + username))
                .getId();
        return certificateCourseRepository.findMostEnrolledCertificateCoursesByIsRegistered(
                courseName,
                filterTopicIds,
                isRegistered,
                userId.getValue()
        );
    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }

}





















