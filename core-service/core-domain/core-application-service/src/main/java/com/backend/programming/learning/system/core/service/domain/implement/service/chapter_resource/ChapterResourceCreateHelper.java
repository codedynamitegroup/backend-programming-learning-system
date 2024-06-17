package com.backend.programming.learning.system.core.service.domain.implement.service.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterResourceRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterResourceUserRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterResourceUserId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ResourceType;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class ChapterResourceCreateHelper {
    private final UserRepository userRepository;
    private final ChapterResourceRepository chapterResourceRepository;

    public ChapterResourceCreateHelper(UserRepository userRepository,
                                       ChapterResourceRepository chapterResourceRepository1) {
        this.userRepository = userRepository;
        this.chapterResourceRepository = chapterResourceRepository1;
    }

    @Transactional
    public ChapterResource persistChapterResource(
            CreateChapterResourceCommand createChapterResourceCommand) {

        Integer topNo = findTopNoOfChapterResourceByChapterId(createChapterResourceCommand.getChapterId());

        ChapterResource chapterResource = ChapterResource.builder()
                .id(new ChapterResourceId(UUID.randomUUID()))
                .chapter(Chapter.builder()
                        .id(new ChapterId(createChapterResourceCommand.getChapterId()))
                        .build())
                .no(topNo + 1)
                .title(createChapterResourceCommand.getTitle())
                .resourceType(ResourceType.valueOf(createChapterResourceCommand.getResourceType()))
                .question(
                        createChapterResourceCommand.getResourceType().equals(ResourceType.CODE.name())
                                ? Question.builder()
                                    .questionId(new QuestionId(UUID.randomUUID()))
                                    .build()
                                : null
                )
                .lessonHtml(
                        createChapterResourceCommand.getResourceType().equals(ResourceType.LESSON.name())
                                ? createChapterResourceCommand.getLessonHtml()
                                : null
                )
                .youtubeVideoUrl(
                        createChapterResourceCommand.getResourceType().equals(ResourceType.VIDEO.name())
                                ? createChapterResourceCommand.getLessonVideo()
                                : null
                )
                .build();

        ChapterResource chapterResourceResult = saveChapterResource(chapterResource);

        log.info("Chapter Resource saved with id: {}", chapterResourceResult.getId().getValue());
        return chapterResourceResult;
    }

    private Integer findTopNoOfChapterResourceByChapterId(UUID chapterId) {
        return chapterResourceRepository.findTopNoOfChapterResourceByChapterId(chapterId);
    }

    private ChapterResource saveChapterResource(ChapterResource chapterResource) {
        ChapterResource savedChapterResource = chapterResourceRepository
                .saveChapterResource(chapterResource);

        if (savedChapterResource == null) {
            log.error("Could not save chapter resource");

            throw new CoreDomainException("Could not save chapter resource");
        }
        log.info("Chapter resource saved with id: {}", savedChapterResource.getId().getValue());
        return savedChapterResource;
    }

}





















