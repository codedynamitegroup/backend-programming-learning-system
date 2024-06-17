package com.backend.programming.learning.system.core.service.domain.implement.service.chapter_resource;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter_resource.CreateChapterResourceResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.CreateChapterResourceUserResponse;
import com.backend.programming.learning.system.core.service.domain.implement.service.chapter_resource_user.ChapterResourceUserCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter_resource.ChapterResourceApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter_resource_user.ChapterResourceUserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class ChapterResourceApplicationServiceImpl implements ChapterResourceApplicationService {
    private final ChapterResourceCommandHandler chapterResourceCommandHandler;

    public ChapterResourceApplicationServiceImpl(ChapterResourceCommandHandler chapterResourceCommandHandler) {
        this.chapterResourceCommandHandler = chapterResourceCommandHandler;
    }

    @Override
    public CreateChapterResourceResponse createChapterResource(CreateChapterResourceCommand createChapterResourceCommand) {
        return chapterResourceCommandHandler.createChapterResourceResponse(createChapterResourceCommand);
    }


}
