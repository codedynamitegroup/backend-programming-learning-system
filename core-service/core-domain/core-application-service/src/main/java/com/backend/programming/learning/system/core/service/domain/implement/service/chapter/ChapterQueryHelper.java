package com.backend.programming.learning.system.core.service.domain.implement.service.chapter;

import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.ChapterNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Component
public class ChapterQueryHelper {
    private final ChapterRepository chapterRepository;
    private final ChapterResourceRepository chapterResourceRepository;
    private final ChapterResourceUserRepository chapterResourceUserRepository;
    private final CodeSubmissionRepository codeSubmissionRepository;
    private final UserRepository userRepository;

    public ChapterQueryHelper(ChapterRepository chapterRepository,
                              ChapterResourceRepository chapterResourceRepository,
                              ChapterResourceUserRepository chapterResourceUserRepository,
                              CodeSubmissionRepository codeSubmissionRepository,
                              UserRepository userRepository) {
        this.chapterRepository = chapterRepository;
        this.chapterResourceRepository = chapterResourceRepository;
        this.chapterResourceUserRepository = chapterResourceUserRepository;
        this.codeSubmissionRepository = codeSubmissionRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<Chapter> queryAllChapters(UUID certificateCourseId,
                                          String email) {
        List<Chapter> chapters = chapterRepository.findAllByCertificateCourseId(
                new CertificateCourseId(certificateCourseId));

        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            for (Chapter chapter : chapters) {
                List<ChapterResource> chapterResources = getAllChapterResourcesForChapter(chapter.getId().getValue());

                for (ChapterResource chapterResource : chapterResources) {
                    if (!chapterResource.getResourceType().equals(ResourceType.CODE)) {
                        chapterResource.setCompleted(
                                getCompletedStatusForChapterResource(
                                        chapterResource.getId().getValue(),
                                        user.get().getId().getValue()
                                )
                        );
                    } else if (chapterResource.getQuestion() != null && chapterResource.getResourceType().equals(ResourceType.CODE)) {
                        Question q = chapterResource.getQuestion();
                        q.setPass(checkCodeQuestionIsPassed(
                                user.get().getId().getValue(),
                                q.getId().getValue(),
                                chapterResource.getChapter().getCertificateCourseId().getValue()
                        ));
                        chapterResource.setCompleted(q.getPass());
                    }
                }
                chapter.setChapterResources(chapterResources);
            }
        } else {
            for (Chapter chapter : chapters) {
                List<ChapterResource> chapterResources = getAllChapterResourcesForChapter(chapter.getId().getValue());
                chapter.setChapterResources(chapterResources);
            }
        }

        log.info("All chapters queried for certificate course with id: {}", certificateCourseId);
        return chapters;
    }

    @Transactional(readOnly = true)
    public Chapter queryChapterById(UUID chapterId, String email) {
        Optional<Chapter> chapter = chapterRepository.findById(chapterId);

        if (chapter.isEmpty()) {
            log.error("Chapter not found with id: {}", chapterId);
            throw new ChapterNotFoundException("Chapter not found with id: " + chapterId);
        }

        Chapter chapterWithResources = chapter.get();

        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            List<ChapterResource> chapterResources = getAllChapterResourcesForChapter(chapterId);

            for (ChapterResource chapterResource : chapterResources) {
                if (!chapterResource.getResourceType().equals(ResourceType.CODE)) {
                    chapterResource.setCompleted(
                            getCompletedStatusForChapterResource(
                                    chapterResource.getId().getValue(),
                                    user.get().getId().getValue()
                            )
                    );
                } else if (chapterResource.getQuestion() != null && chapterResource.getResourceType().equals(ResourceType.CODE)) {
                    Question q = chapterResource.getQuestion();
                    q.setPass(checkCodeQuestionIsPassed(
                            user.get().getId().getValue(),
                            q.getId().getValue(),
                            chapterWithResources.getCertificateCourseId().getValue()
                    ));
                    chapterResource.setCompleted(q.getPass());
                }
            }

            chapterWithResources.setChapterResources(chapterResources);
        } else {
            List<ChapterResource> chapterResources = getAllChapterResourcesForChapter(chapterId);
            chapterWithResources.setChapterResources(chapterResources);
        }

        log.info("Chapter queried with id: {}", chapterId);
        return chapterWithResources;
    }

    private Boolean getCompletedStatusForChapterResource(
            UUID chapterResourceId, UUID userId) {
        Boolean test = chapterResourceUserRepository.checkChapterResourceIsCompleted(
                chapterResourceId, userId);
        return test;
    }

    private Boolean checkCodeQuestionIsPassed(UUID userId, UUID questionId, UUID certificateCourseId) {
        List<CodeSubmission> codeSubmissions = codeSubmissionRepository
                .findAllCodeSubmissionsByUserIdAndQuestionIdAndCertificateCourseId(
                        userId, questionId, certificateCourseId);
        return codeSubmissions.stream()
                .anyMatch(CodeSubmission::getPass);
    }

    private List<ChapterResource> getAllChapterResourcesForChapter(UUID chapterId) {
        List<ChapterResource> chapterResources = chapterResourceRepository
                .findAllChapterResourcesByChapterId(chapterId);

        log.info("All resources queried for chapter with id: {}", chapterId);
        return chapterResources;
    }
}





















