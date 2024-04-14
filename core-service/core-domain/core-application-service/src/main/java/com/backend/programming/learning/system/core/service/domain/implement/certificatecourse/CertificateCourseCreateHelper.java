package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CertificateCourseCreateHelper {
    private final CoreDomainService coreDomainService;
    private final CertificateCourseRepository certificateCourseRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final CertificateCourseDataMapper certificateCourseDataMapper;

    public CertificateCourseCreateHelper(CoreDomainService coreDomainService,
                                         CertificateCourseRepository certificateCourseRepository,
                                         UserRepository userRepository,
                                            TopicRepository topicRepository,
                                         CertificateCourseDataMapper certificateCourseDataMapper) {
        this.coreDomainService = coreDomainService;
        this.certificateCourseRepository = certificateCourseRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.certificateCourseDataMapper = certificateCourseDataMapper;
    }

    @Transactional
    public CertificateCourse persistCertificateCourse(CreateCertificateCourseCommand createCertificateCourseCommand) {
        checkUser(createCertificateCourseCommand.getCreatedBy());
        checkUser(createCertificateCourseCommand.getUpdatedBy());
        checkTopic(createCertificateCourseCommand.getTopicId());

        CertificateCourse certificateCourse = certificateCourseDataMapper.
                createCertificateCourseCommandToCertificateCourse(createCertificateCourseCommand);
        coreDomainService.createCertificateCourse(certificateCourse);
        CertificateCourse certificateCourseResult = saveCertificateCourse(certificateCourse);

        log.info("Certificate course created with id: {}", certificateCourseResult.getId().getValue());
        return certificateCourseResult;
    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }

    private void checkTopic(UUID topicId) {
        Optional<Topic> topic = topicRepository.findByID(new TopicId(topicId));
        if (topic.isEmpty()) {
            log.warn("Topic with id: {} not found", topicId);
            throw new TopicNotFoundException("Could not find topic with id: " + topicId);
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





















