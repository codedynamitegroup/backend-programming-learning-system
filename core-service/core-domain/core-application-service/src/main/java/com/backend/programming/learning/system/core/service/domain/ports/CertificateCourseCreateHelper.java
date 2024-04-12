package com.backend.programming.learning.system.core.service.domain.ports;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.mapper.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CertificateCourseCreateHelper {
    private final CertificateCourseRepository certificateCourseRepository;
    private final UserRepository userRepository;
    private final CertificateCourseDataMapper certificateCourseDataMapper;

    public CertificateCourseCreateHelper(CertificateCourseRepository certificateCourseRepository,
                                         UserRepository userRepository,
                                         CertificateCourseDataMapper certificateCourseDataMapper) {
        this.certificateCourseRepository = certificateCourseRepository;
        this.userRepository = userRepository;
        this.certificateCourseDataMapper = certificateCourseDataMapper;
    }

    @Transactional
    public CertificateCourse persistCertificateCourse(CreateCertificateCourseCommand createCertificateCourseCommand) {
        checkUser(createCertificateCourseCommand.getCreatedBy());
        checkUser(createCertificateCourseCommand.getUpdatedBy());

        CertificateCourse certificateCourse = certificateCourseDataMapper.
                createCertificateCourseCommandToCertificateCourse(createCertificateCourseCommand);
        CertificateCourse certificateCourseResult = saveCertificateCourse(certificateCourse);

        log.info("Question created with id: {}", certificateCourseResult.getId().getValue());
        return certificateCourseResult;
    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new CoreDomainException("Could not find user with id: " + userId);
        }
    }

    private CertificateCourse saveCertificateCourse(CertificateCourse certificateCourse) {
        CertificateCourse savedCertificateCourse = certificateCourseRepository
                .saveCertificateCourse(certificateCourse);

        if (savedCertificateCourse == null) {
            log.error("Could not save certificate course");

            throw new CoreDomainException("Could not save certificate course");
        }
        log.info("Certificate course saved with id: {}", savedCertificateCourse.getId().getValue());
        return savedCertificateCourse;
    }
}





















