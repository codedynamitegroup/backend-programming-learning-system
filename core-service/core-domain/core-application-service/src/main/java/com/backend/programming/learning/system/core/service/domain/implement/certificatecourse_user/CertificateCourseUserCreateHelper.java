package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse_user;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse_user.CreateCertificateCourseUserCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourseUser;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse_user.CertificateCourseUserDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseUserRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
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
        checkUser(createCertificateCourseUserCommand.getUserId());
        checkCertificateCourse(createCertificateCourseUserCommand.getCertificateCourseId());

        CertificateCourseUser certificateCourseUser = certificateCourseUserDataMapper.
                createCertificateCourseUserCommandToCertificateCourseUser(createCertificateCourseUserCommand);
        coreDomainService.createCertificateCourseUser(certificateCourseUser);
        CertificateCourseUser certificateCourseUserResult = saveCertificateCourseUser(certificateCourseUser);

        log.info("Certificate course user created with id: {}", certificateCourseUserResult.getId().getValue());
        return certificateCourseUserResult;
    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }

    private void checkCertificateCourse(UUID certificateCourseId) {
        Optional<CertificateCourse> certificateCourse = certificateCourseRepository
                .findById(new CertificateCourseId(certificateCourseId));
        if (certificateCourse.isEmpty()) {
            log.warn("Certificate course with id: {} not found", certificateCourseId);
            throw new TopicNotFoundException("Could not find Certificate course with id: " + certificateCourseId);
        }
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





















