package com.backend.programming.learning.system.core.service.domain.implement.chapter;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter.ChapterDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ChapterCreateHelper {
    private final CoreDomainService coreDomainService;
    private final ChapterRepository chapterRepository;
    private final UserRepository userRepository;
    private final CertificateCourseRepository certificateCourseRepository;
    private final ChapterDataMapper chapterDataMapper;

    public ChapterCreateHelper(CoreDomainService coreDomainService,
                               ChapterRepository chapterRepository,
                               UserRepository userRepository,
                               CertificateCourseRepository certificateCourseRepository,
                               ChapterDataMapper chapterDataMapper) {
        this.coreDomainService = coreDomainService;
        this.chapterRepository = chapterRepository;
        this.userRepository = userRepository;
        this.certificateCourseRepository = certificateCourseRepository;
        this.chapterDataMapper = chapterDataMapper;
    }

    @Transactional
    public Chapter persistChapter(CreateChapterCommand createChapterCommand) {
        User createdBy = getUser(createChapterCommand.getCreatedBy());
        User updatedBy = getUser(createChapterCommand.getUpdatedBy());
        checkCertificateCourse(createChapterCommand.getCertificateCourseId());
        Integer topNo = findTopNoOfChapterByCertificateCourseId(createChapterCommand.getCertificateCourseId());

        Chapter chapter = chapterDataMapper.
                createChapterCommandToChapter(createChapterCommand);
        coreDomainService.createChapter(chapter);
        chapter.setCreatedBy(createdBy);
        chapter.setUpdatedBy(updatedBy);
        chapter.setCertificateCourseId(new CertificateCourseId(createChapterCommand.getCertificateCourseId()));
        chapter.setNo(topNo + 1);

        Chapter chapterResult = saveChapter(chapter);

        log.info("Chapter created with id: {}", chapterResult.getId().getValue());
        return chapterResult;
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    private void checkCertificateCourse(UUID certificateCourseId) {
        Optional<CertificateCourse> certificateCourse =
                certificateCourseRepository.findById(new CertificateCourseId(certificateCourseId));
        if (certificateCourse.isEmpty()) {
            log.warn("Certificate course with id: {} not found", certificateCourseId);
            throw new CertificateCourseNotFoundException("Could not find certificate course with id: " + certificateCourseId);
        }
    }

    private Integer findTopNoOfChapterByCertificateCourseId(UUID certificateCourseId) {
        return chapterRepository.findTopNoByCertificateCourseId(new CertificateCourseId(certificateCourseId));
    }

    private Chapter saveChapter(Chapter chapter) {
        Chapter savedChapter = chapterRepository
                .saveChapter(chapter);

        if (savedChapter == null) {
            log.error("Could not save chapter");

            throw new CoreDomainException("Could not save chapter");
        }
        log.info("Chapter saved with id: {}", savedChapter.getId().getValue());
        return savedChapter;
    }
}





















