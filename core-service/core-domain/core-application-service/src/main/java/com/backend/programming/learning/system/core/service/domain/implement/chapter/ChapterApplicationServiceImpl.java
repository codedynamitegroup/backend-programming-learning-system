package com.backend.programming.learning.system.core.service.domain.implement.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter.DeleteChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.chapter.DeleteChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.chapter.QueryChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.chapter.UpdateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.chapter.ChapterResponseEntity;
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

    @Override
    public DeleteChapterResponse deleteChapter(DeleteChapterCommand deleteChapterCommand) {
        return chapterCommandHandler.deleteChapterResponse(deleteChapterCommand);
    }

    @Override
    public QueryAllChaptersResponse queryAllChapters(QueryAllChaptersCommand queryAllChaptersCommand) {
        return chapterCommandHandler.queryAllChaptersResponse(queryAllChaptersCommand);
    }

    @Override
    public ChapterResponseEntity queryChapter(QueryChapterCommand queryChapterCommand) {
        return chapterCommandHandler.queryChapterResponse(queryChapterCommand);
    }

    @Override
    public UpdateChapterResponse updateChapter(UpdateChapterCommand updateChapterCommand) {
        return chapterCommandHandler.updateChapterResponse(updateChapterCommand);
    }
}
