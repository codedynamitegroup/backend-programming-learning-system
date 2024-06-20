package com.backend.programming.learning.system.core.service.domain.implement.service.certificatecourse;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.certificatecourse.UpdateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter_resource.UpdateChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.TopicNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.certificatecourse.CertificateCourseDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.*;
import com.backend.programming.learning.system.domain.DomainConstants;
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
public class CertificateCourseUpdateHelper {
    private final CertificateCourseRepository certificateCourseRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final ChapterRepository chapterRepository;
    private final ChapterResourceRepository chapterResourceRepository;
    private final QuestionRepository questionRepository;

    public CertificateCourseUpdateHelper(CertificateCourseRepository certificateCourseRepository,
                                         UserRepository userRepository,
                                         TopicRepository topicRepository,
                                         ChapterRepository chapterRepository,
                                         ChapterResourceRepository chapterResourceRepository,
                                         QuestionRepository questionRepository) {
        this.certificateCourseRepository = certificateCourseRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.chapterRepository = chapterRepository;
        this.chapterResourceRepository = chapterResourceRepository;
        this.questionRepository = questionRepository;
    }

    @Transactional
    public void persistCertificateCourse(UpdateCertificateCourseCommand updateCertificateCourseCommand) {
        CertificateCourse certificateCourse = getCertificateCourse(
                updateCertificateCourseCommand.getCertificateCourseId());

        User createdBy = getUserByEmail(updateCertificateCourseCommand.getEmail());
        User updatedBy = getUserByEmail(updateCertificateCourseCommand.getEmail());
        certificateCourse.setUpdatedBy(updatedBy);
        certificateCourse.setUpdatedAt(ZonedDateTime.now(ZoneId.of("UTC")));

        if (updateCertificateCourseCommand.getName() != null) {
            if (!certificateCourse.getName().equals(updateCertificateCourseCommand.getName())) {
                checkCertificateCourseByNameExists(updateCertificateCourseCommand.getName());
            }
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

        deleteChaptersByCertificateCourseId(updateCertificateCourseCommand.getCertificateCourseId());

        if (updateCertificateCourseCommand.getChapters() != null && !updateCertificateCourseCommand.getChapters().isEmpty()) {
            log.info("Updating chapters for certificate course with id: {}", certificateCourse.getId().getValue());
            List<UpdateChapterCommand> chapters = updateCertificateCourseCommand.getChapters();
            for (UpdateChapterCommand updateChapterCommand : chapters) {
                Chapter newChapter = Chapter.builder()
                        .id(new ChapterId(UUID.randomUUID()))
                        .certificateCourseId(new CertificateCourseId(updateCertificateCourseCommand.getCertificateCourseId()))
                        .no(updateChapterCommand.getNo())
                        .title(updateChapterCommand.getTitle())
                        .description(updateChapterCommand.getDescription())
                        .chapterResources(new ArrayList<>())
                        .createdBy(createdBy)
                        .updatedBy(updatedBy)
                        .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                        .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                        .build();
                Chapter savedChapter = saveChapter(newChapter);
                List<UpdateChapterResourceCommand> chapterResources = updateChapterCommand.getResources();
                for (UpdateChapterResourceCommand updateChapterResourceCommand : chapterResources) {
                    if (updateChapterResourceCommand.getResourceType().equals(ResourceType.CODE.name())) {
                        checkQuestionExists(updateChapterResourceCommand.getQuestionId());
                    }
                    ChapterResource chapterResource = ChapterResource.builder()
                            .id(new ChapterResourceId(UUID.randomUUID()))
                            .chapter(savedChapter)
                            .no(updateChapterResourceCommand.getNo())
                            .resourceType(ResourceType.valueOf(updateChapterResourceCommand.getResourceType()))
                            .title(updateChapterResourceCommand.getTitle())
                            .lessonHtml(updateChapterResourceCommand.getLessonHtml())
                            .youtubeVideoUrl(updateChapterResourceCommand.getLessonVideo())
                            .question(
                                    updateChapterResourceCommand.getResourceType().equals(ResourceType.CODE.name())
                                            ? Question.builder()
                                            .questionId(new QuestionId(updateChapterResourceCommand.getQuestionId()))
                                            .build()
                                            : null
                            )
                            .build();

                    saveChapterResource(chapterResource);
                }
            }
        }

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

    private User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email: {} not found", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
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
        CertificateCourse updatedCertificateCourse = certificateCourseRepository
                .saveCertificateCourse(certificateCourse);

        if (updatedCertificateCourse == null) {
            log.error("Could not update certificate course");

            throw new CoreDomainException("Could not update certificate course");
        }
        log.info("Certificate course updated with id: {}", updatedCertificateCourse.getId().getValue());
    }

    private void deleteChaptersByCertificateCourseId(UUID certificateCourseId) {
        chapterRepository.deleteChaptersByCertificateCourseId(certificateCourseId);
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





















