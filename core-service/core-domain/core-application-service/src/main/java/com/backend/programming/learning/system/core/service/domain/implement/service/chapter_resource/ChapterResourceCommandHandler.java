package com.backend.programming.learning.system.core.service.domain.implement.service.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter_resource.DeleteChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter_resource.DeleteChapterResourceResponse;
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
    private final ChapterResourceDeleteHelper chapterResourceDeleteHelper;
    private final ChapterResourceDataMapper chapterResourceDataMapper;
    private final ChapterResourceCreateHelper chapterResourceCreateHelper;

    public ChapterResourceCommandHandler(ChapterResourceDeleteHelper chapterResourceDeleteHelper,
                                         ChapterResourceDataMapper chapterResourceDataMapper,
                                         ChapterResourceCreateHelper chapterResourceCreateHelper) {
        this.chapterResourceDeleteHelper = chapterResourceDeleteHelper;
        this.chapterResourceDataMapper = chapterResourceDataMapper;
        this.chapterResourceCreateHelper = chapterResourceCreateHelper;
    }

    @Transactional
    public CreateChapterResourceResponse createChapterResourceResponse(
            CreateChapterResourceCommand createChapterResourceCommand) {
        ChapterResource chapterResource  = chapterResourceCreateHelper
                .persistChapterResource(createChapterResourceCommand);

        log.info("Chapter Resource saved with id: {}", chapterResource.getId().getValue());
        return chapterResourceDataMapper.chapterResourceToCreateChapterResourceResponse(chapterResource);
    }

    @Transactional
    public DeleteChapterResourceResponse deleteChapterResourceResponse(
            DeleteChapterResourceCommand deleteChapterResourceCommand) {
        chapterResourceDeleteHelper.deleteChapterResourceById(
                deleteChapterResourceCommand.getChapterResourceId()
        );
        return DeleteChapterResourceResponse.builder()
                .chapterResourceId(deleteChapterResourceCommand.getChapterResourceId())
                .message("Chapter Resource deleted successfully")
                .build();
    }
}
