package com.backend.programming.learning.system.core.service.domain.implement.service.chapter_resource_user;

import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter_resource_user.ChapterResourceUserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class ChapterResourceUserApplicationServiceImpl implements ChapterResourceUserApplicationService {
    private final ChapterResourceUserCommandHandler chapterResourceUserCommandHandler;

    public ChapterResourceUserApplicationServiceImpl(ChapterResourceUserCommandHandler chapterResourceUserCommandHandler) {
        this.chapterResourceUserCommandHandler = chapterResourceUserCommandHandler;
    }

    @Override
    public CreateChapterResourceUserResponse createChapterResourceUser(
            CreateChapterResourceUserCommand createChapterResourceUserCommand) {
        return chapterResourceUserCommandHandler.createChapterResourceUserResponse(createChapterResourceUserCommand);
    }
}
