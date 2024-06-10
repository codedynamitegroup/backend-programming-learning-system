package com.backend.programming.learning.system.core.service.domain.implement.service.chapter_resource_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserResponse;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResourceUser;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter_resource_user.ChapterResourceUserDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class ChapterResourceUserCommandHandler {
    private final ChapterResourceUserUpsertHelper chapterResourceUserUpsertHelper;
    private final ChapterResourceUserDataMapper chapterResourceUserDataMapper;

    public ChapterResourceUserCommandHandler(ChapterResourceUserUpsertHelper chapterResourceUserUpsertHelper,
                                             ChapterResourceUserDataMapper chapterResourceUserDataMapper) {
        this.chapterResourceUserUpsertHelper = chapterResourceUserUpsertHelper;
        this.chapterResourceUserDataMapper = chapterResourceUserDataMapper;
    }

    @Transactional
    public CreateChapterResourceUserResponse createChapterResourceUserResponse(
            CreateChapterResourceUserCommand createChapterResourceUserCommand) {
        ChapterResourceUser chapterResourceUser  = chapterResourceUserUpsertHelper
                .persistChapterResourceUser(createChapterResourceUserCommand);

        log.info("ChapterResourceUser saved with id: {}", chapterResourceUser.getId().getValue());
        return chapterResourceUserDataMapper.chapterResourceUserToChapterResourceUserResponse(chapterResourceUser);
    }

}
