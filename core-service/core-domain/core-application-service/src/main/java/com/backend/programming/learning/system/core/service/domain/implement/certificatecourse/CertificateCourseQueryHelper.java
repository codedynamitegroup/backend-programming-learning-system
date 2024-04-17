package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
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

    public CertificateCourseQueryHelper(CertificateCourseRepository certificateCourseRepository,
                                        UserRepository userRepository) {
        this.certificateCourseRepository = certificateCourseRepository;
        this.userRepository = userRepository;
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
        User createdBy = getUser(certificateCourseResult.get().getCreatedBy().getId().getValue());
        User updatedBy = getUser(certificateCourseResult.get().getUpdatedBy().getId().getValue());

        CertificateCourse certificateCourse = certificateCourseResult.get();
        certificateCourse.setCreatedBy(createdBy);
        certificateCourse.setUpdatedBy(updatedBy);

        log.info("Certificate course queried with id: {}", certificateCourseResult.get().getId().getValue());
        return certificateCourseResult.get();
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    @Transactional(readOnly = true)
    public Page<CertificateCourse> queryAllCertificateCourses(
            Integer pageNo, Integer pageSize
    ) {
        return certificateCourseRepository.findAll(pageNo, pageSize);
    }

    @Transactional(readOnly = true)
    public Page<CertificateCourseUser> queryAllCertificateCourseUsers(
            UUID certificateCourseId,
            Integer pageNo,
            Integer pageSize,
            Boolean fetchAll) {
        return certificateCourseRepository.findAllByCertificateCourseId(certificateCourseId, pageNo, pageSize, fetchAll);
    }

}





















