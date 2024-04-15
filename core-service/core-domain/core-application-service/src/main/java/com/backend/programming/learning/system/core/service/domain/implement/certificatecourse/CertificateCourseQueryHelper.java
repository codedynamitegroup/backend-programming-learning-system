package com.backend.programming.learning.system.core.service.domain.implement.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.TopicRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
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
public class CertificateCourseQueryHelper {
    private final CoreDomainService coreDomainService;
    private final CertificateCourseRepository certificateCourseRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final ChapterRepository chapterRepository;
    private final CertificateCourseDataMapper certificateCourseDataMapper;

    public CertificateCourseQueryHelper(CoreDomainService coreDomainService,
                                        CertificateCourseRepository certificateCourseRepository,
                                        UserRepository userRepository,
                                        TopicRepository topicRepository,
                                        ChapterRepository chapterRepository,
                                        CertificateCourseDataMapper certificateCourseDataMapper) {
        this.coreDomainService = coreDomainService;
        this.certificateCourseRepository = certificateCourseRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.chapterRepository = chapterRepository;
        this.certificateCourseDataMapper = certificateCourseDataMapper;
    }

    @Transactional(readOnly = true)
    public CertificateCourse getCertificateCourse(QueryCertificateCourseCommand queryCertificateCourseCommand) {
        Optional<CertificateCourse> certificateCourseResult =
                certificateCourseRepository.findById(new CertificateCourseId(
                        queryCertificateCourseCommand.getCertificateCourseId()));
        if (certificateCourseResult.isEmpty()) {
            log.warn("Could not find certificate course with id: {}",
                    queryCertificateCourseCommand.getCertificateCourseId());
            throw new CertificateCourseNotFoundException("Could not find certificate course with id: " +
                    queryCertificateCourseCommand.getCertificateCourseId());
        }
        User createdBy = getUser(certificateCourseResult.get().getCreatedBy().getId().getValue());
        User updatedBy = getUser(certificateCourseResult.get().getUpdatedBy().getId().getValue());
        List<Chapter> chapters = getAllChaptersByCertificateCourseId(
                certificateCourseResult.get().getId().getValue());

        CertificateCourse certificateCourse = certificateCourseResult.get();
        certificateCourse.setCreatedBy(createdBy);
        certificateCourse.setUpdatedBy(updatedBy);
        certificateCourse.setChapters(chapters);

        log.info("Query certificate course with id: {}", certificateCourseResult.get().getId().getValue());
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

    private List<Chapter> getAllChaptersByCertificateCourseId(UUID certificateCourseId) {
        return chapterRepository.findAllByCertificateCourseId(
                new CertificateCourseId(certificateCourseId));
    }

}





















