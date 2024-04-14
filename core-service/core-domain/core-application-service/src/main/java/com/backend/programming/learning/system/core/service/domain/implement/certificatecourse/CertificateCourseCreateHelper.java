package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CertificateCourseCreateHelper {
    private final CoreDomainService coreDomainService;
    private final CertificateCourseRepository certificateCourseRepository;
    private final CertificateCourseTopicRepository certificateCourseTopicRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final CertificateCourseDataMapper certificateCourseDataMapper;

    public CertificateCourseCreateHelper(CoreDomainService coreDomainService,
                                         CertificateCourseRepository certificateCourseRepository,
                                         CertificateCourseTopicRepository certificateCourseTopicRepository,
                                         UserRepository userRepository,
                                            TopicRepository topicRepository,
                                         CertificateCourseDataMapper certificateCourseDataMapper) {
        this.coreDomainService = coreDomainService;
        this.certificateCourseRepository = certificateCourseRepository;
        this.certificateCourseTopicRepository = certificateCourseTopicRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.certificateCourseDataMapper = certificateCourseDataMapper;
    }

    @Transactional
    public CertificateCourse persistCertificateCourse(CreateCertificateCourseCommand createCertificateCourseCommand) {
        checkUser(createCertificateCourseCommand.getCreatedBy());
        checkUser(createCertificateCourseCommand.getUpdatedBy());

        CertificateCourse certificateCourse = certificateCourseDataMapper.
                createCertificateCourseCommandToCertificateCourse(createCertificateCourseCommand);
        // Initialize certificate course with random UUID
        coreDomainService.createCertificateCourse(certificateCourse);
        CertificateCourse certificateCourseResult = saveCertificateCourse(certificateCourse);

        for (UUID topicId : createCertificateCourseCommand.getTopicIds()) {
            Topic checkTopic = checkTopic(topicId);
            CertificateCourseTopic certificateCourseTopic = CertificateCourseTopic.builder()
                    .certificateCourseId(certificateCourseResult.getId())
                    .topicId(new TopicId(topicId))
                    .build();
            certificateCourseTopic.initializeCertificateCourse();
            saveCertificateCourseTopic(certificateCourseTopic);
            certificateCourseResult.addTopic(checkTopic);
        }

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

    private Topic checkTopic(UUID topicId) {
        Optional<Topic> topic = topicRepository.findByID(new TopicId(topicId));
        if (topic.isEmpty()) {
            log.warn("Topic with id: {} not found", topicId);
            throw new TopicNotFoundException("Could not find topic with id: " + topicId);
        }
        return topic.get();
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

    private void saveCertificateCourseTopic(CertificateCourseTopic certificateCourseTopic) {
        Optional<CertificateCourseTopic> certificateCourseTopicOptional = certificateCourseTopicRepository
                .findByCertificateCourseIdAndTopicId(certificateCourseTopic.getCertificateCourseId(),
                        certificateCourseTopic.getTopicId());
        // Check if certificate course topic already exists with certificate_course_id and topic_id
        if (certificateCourseTopicOptional.isPresent()) {
            log.warn("Certificate course topic already exists with certificate_course_id: {} and topic_id: {}",
                    certificateCourseTopic.getCertificateCourseId().getValue(),
                    certificateCourseTopic.getTopicId().getValue());
            return;
        }
        CertificateCourseTopic savedCertificateCourseTopic = certificateCourseTopicRepository
                .saveCertificateCourseTopic(certificateCourseTopic);
        if (savedCertificateCourseTopic == null) {
            log.error("Could not save certificate_course_topic");
            throw new CoreDomainException("Could not save certificate_course_topic");
        }
        log.info("certificate_course_topic saved with id: {}", savedCertificateCourseTopic.getId().getValue());
    }
}





















