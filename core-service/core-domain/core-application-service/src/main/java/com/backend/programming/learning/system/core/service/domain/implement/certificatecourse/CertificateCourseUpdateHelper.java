package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.DomainConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CertificateCourseUpdateHelper {
    private final CertificateCourseRepository certificateCourseRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;

    public CertificateCourseUpdateHelper(CertificateCourseRepository certificateCourseRepository,
                                         UserRepository userRepository,
                                         TopicRepository topicRepository) {
        this.certificateCourseRepository = certificateCourseRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
    }

    @Transactional
    public void persistCertificateCourse(UpdateCertificateCourseCommand updateCertificateCourseCommand) {
        CertificateCourse certificateCourse = getCertificateCourse(
                updateCertificateCourseCommand.getCertificateCourseId());

        User updatedBy = getUser(updateCertificateCourseCommand.getUpdatedBy());
        certificateCourse.setUpdatedBy(updatedBy);
        certificateCourse.setUpdatedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));

        if (updateCertificateCourseCommand.getName() != null) {
            checkCertificateCourseByNameExists(updateCertificateCourseCommand.getName());
            certificateCourse.setName(updateCertificateCourseCommand.getName());
        }

        if (updateCertificateCourseCommand.getDescription() != null) {
            certificateCourse.setDescription(updateCertificateCourseCommand.getDescription());
        }

        if (updateCertificateCourseCommand.getSkillLevel() != null) {
            certificateCourse.setSkillLevel(
                    SkillLevel.valueOf(updateCertificateCourseCommand.getSkillLevel().toUpperCase()));
        }

        if (updateCertificateCourseCommand.getStartTime() != null) {
            certificateCourse.setStartTime(updateCertificateCourseCommand.getStartTime());
        }

        if (updateCertificateCourseCommand.getEndTime() != null) {
            certificateCourse.setEndTime(updateCertificateCourseCommand.getEndTime());
        }

        if (updateCertificateCourseCommand.getTopicId() != null) {
            Topic topic = getTopic(updateCertificateCourseCommand.getTopicId());
            certificateCourse.setTopic(topic);
        }

        updateCertificateCourse(certificateCourse);

        log.info("Certificate course updated with id: {}", certificateCourse.getId().getValue());
    }

    private void checkCertificateCourseByNameExists(String name) {
        Optional<CertificateCourse> certificateCourse = certificateCourseRepository.findByName(name);
        if (certificateCourse.isPresent()) {
            log.warn("Certificate course with name: {} is already exists", name);
            throw new CoreDomainException("Certificate course with name: " + name + " is already exists");
        }
    }

    private CertificateCourse getCertificateCourse(UUID certificateCourseId) {
        Optional<CertificateCourse> certificateCourse = certificateCourseRepository.findById(new CertificateCourseId(certificateCourseId));
        if (certificateCourse.isEmpty()) {
            log.warn("Certificate course with id: {} not found", certificateCourseId);
            throw new CertificateCourseNotFoundException("Could not find certificate course with id: " + certificateCourseId);
        }
        return certificateCourse.get();
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    private Topic getTopic(UUID topicId) {
        Optional<Topic> topic = topicRepository.findById(new TopicId(topicId));
        if (topic.isEmpty()) {
            log.warn("Topic with id: {} not found", topicId);
            throw new TopicNotFoundException("Could not find topic with id: " + topicId);
        }
        return topic.get();
    }

    private void updateCertificateCourse(CertificateCourse certificateCourse) {
        int updatedRows = certificateCourseRepository
                .updateCertificateCourse(certificateCourse);

        if (updatedRows == 0) {
            log.error("Could not update certificate course");

            throw new CoreDomainException("Could not update certificate course");
        }
        log.info("Certificate course updated with id: {}", certificateCourse.getId().getValue());
    }
}





















