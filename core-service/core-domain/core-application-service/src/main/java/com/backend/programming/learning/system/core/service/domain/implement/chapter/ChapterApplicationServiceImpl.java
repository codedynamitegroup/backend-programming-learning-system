package com.backend.programming.learning.system.core.service.domain.implement.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter.ChapterApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class ChapterApplicationServiceImpl implements ChapterApplicationService {
    private final ChapterCommandHandler chapterCommandHandler;

    public ChapterApplicationServiceImpl(ChapterCommandHandler chapterCommandHandler) {
        this.chapterCommandHandler = chapterCommandHandler;
    }

    @Override
    public CreateChapterResponse createChapter(CreateChapterCommand createChapterCommand) {
        return chapterCommandHandler.createChapterResponse(createChapterCommand);
    }
}
