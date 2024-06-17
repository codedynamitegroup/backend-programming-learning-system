package com.backend.programming.learning.system.core.service.domain.implement.service.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResourceUser;
import com.backend.programming.learning.system.core.service.domain.implement.service.chapter_resource_user.ChapterResourceUserUpsertHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter_resource.ChapterResourceDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter_resource_user.ChapterResourceUserDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class ChapterResourceCommandHandler {
    private final ChapterResourceCreateHelper chapterResourceCreateHelper;
    private final ChapterResourceDataMapper chapterResourceDataMapper;

    public ChapterResourceCommandHandler(ChapterResourceCreateHelper chapterResourceCreateHelper,
                                         ChapterResourceDataMapper chapterResourceDataMapper) {
        this.chapterResourceCreateHelper = chapterResourceCreateHelper;
        this.chapterResourceDataMapper = chapterResourceDataMapper;
    }

    @Transactional
    public CreateChapterResourceResponse createChapterResourceResponse(
            CreateChapterResourceCommand createChapterResourceCommand) {
        ChapterResource chapterResource  = chapterResourceCreateHelper
                .persistChapterResource(createChapterResourceCommand);

        log.info("Chapter Resource saved with id: {}", chapterResource.getId().getValue());
        return chapterResourceDataMapper.chapterResourceToCreateChapterResourceResponse(chapterResource);
    }

}
