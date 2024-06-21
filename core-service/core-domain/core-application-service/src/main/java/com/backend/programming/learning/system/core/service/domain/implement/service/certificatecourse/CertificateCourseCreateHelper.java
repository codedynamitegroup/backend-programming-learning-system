package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import com.backend.programming.learning.system.core.service.domain.valueobject.TopicId;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
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
    private final ChapterRepository chapterRepository;
    private final ChapterResourceRepository chapterResourceRepository;
    private final QuestionRepository questionRepository;

    public CertificateCourseCreateHelper(CoreDomainService coreDomainService,
                                         CertificateCourseRepository certificateCourseRepository,
                                         UserRepository userRepository,
                                         TopicRepository topicRepository,
                                         CertificateCourseDataMapper certificateCourseDataMapper,
                                         ChapterRepository chapterRepository,
                                         ChapterResourceRepository chapterResourceRepository,
                                         QuestionRepository questionRepository) {
        this.coreDomainService = coreDomainService;
        this.certificateCourseRepository = certificateCourseRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.certificateCourseDataMapper = certificateCourseDataMapper;
        this.chapterRepository = chapterRepository;
        this.chapterResourceRepository = chapterResourceRepository;
        this.questionRepository = questionRepository;
    }

    @Transactional
    public CertificateCourse persistCertificateCourse(CreateCertificateCourseCommand createCertificateCourseCommand) {
        User createdBy = getUserByEmail(createCertificateCourseCommand.getEmail());
        User updatedBy = getUserByEmail(createCertificateCourseCommand.getEmail());
        Topic topic = getTopic(createCertificateCourseCommand.getTopicId());

        checkCertificateCourseByNameExists(createCertificateCourseCommand.getName());

        CertificateCourse certificateCourse = certificateCourseDataMapper.
                createCertificateCourseCommandToCertificateCourse(createCertificateCourseCommand);
        coreDomainService.createCertificateCourse(certificateCourse);
        certificateCourse.setCreatedBy(createdBy);
        certificateCourse.setUpdatedBy(updatedBy);
        certificateCourse.setTopic(topic);

        CertificateCourse certificateCourseResult = saveCertificateCourse(certificateCourse);

        List<CreateChapterCommand> chapters = createCertificateCourseCommand.getChapters();
        for (CreateChapterCommand createChapterCommand : chapters) {
            Chapter newChapter = Chapter.builder()
                    .id(new ChapterId(UUID.randomUUID()))
                    .certificateCourseId(certificateCourseResult.getId())
                    .no(createChapterCommand.getNo())
                    .title(createChapterCommand.getTitle())
                    .description(createChapterCommand.getDescription())
                    .chapterResources(new ArrayList<>())
                    .createdBy(createdBy)
                    .updatedBy(updatedBy)
                    .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                    .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                    .build();
            Chapter savedChapter = saveChapter(newChapter);
            List<CreateChapterResourceCommand> chapterResources = createChapterCommand.getResources();
            for (CreateChapterResourceCommand createChapterResourceCommand : chapterResources) {
                if (createChapterResourceCommand.getResourceType().equals(ResourceType.CODE.name())
                     && createChapterResourceCommand.getQuestionId() == null) {
                    log.warn("Question id is required for resource type CODE");
                    throw new CoreDomainException("Question id is required for resource type CODE");
                }
            }

            for (CreateChapterResourceCommand createChapterResourceCommand : chapterResources) {
                if (createChapterResourceCommand.getResourceType().equals(ResourceType.CODE.name())) {
                    checkQuestionExists(createChapterResourceCommand.getQuestionId());
                }
                ChapterResource chapterResource = ChapterResource.builder()
                        .id(new ChapterResourceId(UUID.randomUUID()))
                        .chapter(savedChapter)
                        .no(createChapterResourceCommand.getNo())
                        .resourceType(ResourceType.valueOf(createChapterResourceCommand.getResourceType()))
                        .title(createChapterResourceCommand.getTitle())
                        .lessonHtml(createChapterResourceCommand.getLessonHtml())
                        .youtubeVideoUrl(createChapterResourceCommand.getLessonVideo())
                        .question(
                                createChapterResourceCommand.getResourceType().equals(ResourceType.CODE.name())
                                        ? Question.builder()
                                            .questionId(new QuestionId(createChapterResourceCommand.getQuestionId()))
                                            .build()
                                        : null
                        )
                        .build();
                saveChapterResource(chapterResource);
            }
        }

        log.info("Certificate course created with id: {}", certificateCourseResult.getId().getValue());
        return certificateCourseResult;
    }

    private void checkCertificateCourseByNameExists(String name) {
        Optional<CertificateCourse> certificateCourse = certificateCourseRepository.findByName(name);
        if (certificateCourse.isPresent()) {
            log.warn("Certificate course with name: {} is already exists", name);
            throw new CoreDomainException("Certificate course with name: " + name + " is already exists");
        }
    }

    private Topic getTopic(UUID topicId) {
        Optional<Topic> topic = topicRepository.findById(new TopicId(topicId));
        if (topic.isEmpty()) {
            log.warn("Topic with id: {} not found", topicId);
            throw new TopicNotFoundException("Could not find topic with id: " + topicId);
        }
        return topic.get();
    }

    private User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email: {} not found", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
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

    private Chapter saveChapter(Chapter chapter) {
        Chapter savedChapter = chapterRepository.saveChapter(chapter);

        if (savedChapter == null) {
            log.error("Could not save chapter");

            throw new CoreDomainException("Could not save chapter");
        }
        log.info("Chapter saved with id: {}", savedChapter.getId().getValue());
        return savedChapter;
    }

    private ChapterResource saveChapterResource(ChapterResource chapterResource) {
        ChapterResource savedChapterResource = chapterResourceRepository.saveChapterResource(chapterResource);

        if (savedChapterResource == null) {
            log.error("Could not save chapter resource");

            throw new CoreDomainException("Could not save chapter resource");
        }
        log.info("Chapter resource saved with id: {}", savedChapterResource.getId().getValue());
        return savedChapterResource;
    }

    private void checkQuestionExists(UUID questionId) {
        Optional<Question> question = questionRepository.findQuestion(questionId);
        if (question.isEmpty()) {
            log.warn("Question with id: {} not found", questionId);
            throw new QuestionNotFoundException("Could not find question with id: " + questionId);
        }
    }
}





















