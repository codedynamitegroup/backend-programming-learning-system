package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse_user.CertificateCourseUserDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseUserRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CertificateCourseUserCreateHelper {
    private final CoreDomainService coreDomainService;
    private final CertificateCourseUserRepository certificateCourseUserRepository;
    private final UserRepository userRepository;
    private final CertificateCourseRepository certificateCourseRepository;
    private final CertificateCourseUserDataMapper certificateCourseUserDataMapper;

    public CertificateCourseUserCreateHelper(CoreDomainService coreDomainService,
                                             CertificateCourseUserRepository certificateCourseUserRepository,
                                             UserRepository userRepository,
                                             CertificateCourseRepository certificateCourseRepository,
                                             CertificateCourseUserDataMapper certificateCourseUserDataMapper) {
        this.coreDomainService = coreDomainService;
        this.certificateCourseUserRepository = certificateCourseUserRepository;
        this.userRepository = userRepository;
        this.certificateCourseRepository = certificateCourseRepository;
        this.certificateCourseUserDataMapper = certificateCourseUserDataMapper;
    }

    @Transactional
    public CertificateCourseUser persistCertificateCourseUser(
            CreateCertificateCourseUserCommand createCertificateCourseUserCommand) {
        checkIfCertificateCourseUserExists(createCertificateCourseUserCommand.getCertificateCourseId(),
                createCertificateCourseUserCommand.getUserId());
        User user = getUser(createCertificateCourseUserCommand.getUserId());
        CertificateCourse certificateCourse =
                getCertificateCourse(createCertificateCourseUserCommand.getCertificateCourseId());

        CertificateCourseUser certificateCourseUser = certificateCourseUserDataMapper.
                createCertificateCourseUserCommandToCertificateCourseUser(createCertificateCourseUserCommand);
        coreDomainService.createCertificateCourseUser(certificateCourseUser);
        certificateCourseUser.setCertificateCourse(certificateCourse);
        certificateCourseUser.setUser(user);
        CertificateCourseUser certificateCourseUserResult = saveCertificateCourseUser(certificateCourseUser);

        log.info("Certificate course user created with id: {}", certificateCourseUserResult.getId().getValue());
        return certificateCourseUserResult;
    }

    private void checkIfCertificateCourseUserExists(UUID certificateCourseId, UUID userId) {
        Optional<CertificateCourseUser> certificateCourseUser = certificateCourseUserRepository
                .findByCertificateCourseIdAndUserId(certificateCourseId, userId);
        if (certificateCourseUser.isPresent()) {
            log.warn("User with id: {} already enrolled in certificate course with id: {}",
                    certificateCourseId, userId);
            throw new CoreDomainException("User already enrolled in this course");
        }
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    private CertificateCourse getCertificateCourse(UUID certificateCourseId) {
        Optional<CertificateCourse> certificateCourse = certificateCourseRepository
                .findById(new CertificateCourseId(certificateCourseId));
        if (certificateCourse.isEmpty()) {
            log.warn("Certificate course with id: {} not found", certificateCourseId);
            throw new TopicNotFoundException("Could not find Certificate course with id: " + certificateCourseId);
        }
        return certificateCourse.get();
    }

    private CertificateCourseUser saveCertificateCourseUser(CertificateCourseUser certificateCourseUser) {
        CertificateCourseUser savedCertificateCourseUser = certificateCourseUserRepository
                .saveCertificateCourseUser(certificateCourseUser);

        if (savedCertificateCourseUser == null) {
            log.error("Could not save certificate course user");

            throw new CoreDomainException("Could not save certificate course user");
        }
        log.info("Certificate course user saved with id: {}", savedCertificateCourseUser.getId().getValue());
        return savedCertificateCourseUser;
    }
}





















