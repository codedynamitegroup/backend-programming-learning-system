package com.backend.programming.learning.system.core.service.domain.implement.service.chapter;

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
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter.ChapterDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.ChapterId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
public class ChapterCommandHandler {
    private final ChapterCreateHelper chapterCreateHelper;
    private final ChapterDeleteHelper chapterDeleteHelper;
    private final ChapterQueryHelper chapterQueryHelper;
    private final ChapterUpdateHelper chapterUpdateHelper;
    private final ChapterDataMapper chapterDataMapper;

    public ChapterCommandHandler(ChapterCreateHelper chapterCreateHelper,
                                 ChapterDeleteHelper chapterDeleteHelper,
                                 ChapterQueryHelper chapterQueryHelper,
                                 ChapterUpdateHelper chapterUpdateHelper,
                                 ChapterDataMapper chapterDataMapper) {
        this.chapterCreateHelper = chapterCreateHelper;
        this.chapterDeleteHelper = chapterDeleteHelper;
        this.chapterQueryHelper = chapterQueryHelper;
        this.chapterUpdateHelper = chapterUpdateHelper;
        this.chapterDataMapper = chapterDataMapper;
    }

    @Transactional
    public CreateChapterResponse createChapterResponse(
            CreateChapterCommand createChapterCommand) {
        Chapter chapter = chapterCreateHelper
                .persistChapter(createChapterCommand);

        log.info("Chapter created with id: {}", chapter.getId().getValue());

        return chapterDataMapper.chapterToCreateChapterResponse(chapter,
                "Chapter created successfully");
    }

    @Transactional
    public DeleteChapterResponse deleteChapterResponse(
            DeleteChapterCommand deleteChapterCommand) {
        chapterDeleteHelper
                .deleteChapterById(deleteChapterCommand.getChapterId());

        log.info("Chapter deleted with id: {}", deleteChapterCommand.getChapterId());

        return DeleteChapterResponse.builder()
                .chapterId(deleteChapterCommand.getChapterId())
                .message("Chapter deleted successfully")
                .build();
    }

    @Transactional(readOnly = true)
    public QueryAllChaptersResponse queryAllChaptersResponse(
            QueryAllChaptersCommand queryAllChaptersCommand) {
        List<Chapter> chapters = chapterQueryHelper
                .queryAllChapters(
                        queryAllChaptersCommand.getCertificateCourseId(),
                        queryAllChaptersCommand.getEmail());

        log.info("Returning all chapters: {}", chapters);

        return chapterDataMapper.chaptersToQueryAllChaptersResponse(chapters);
    }

    @Transactional(readOnly = true)
    public ChapterResponseEntity queryChapterResponse(
            QueryChapterCommand queryChapterCommand) {
        Chapter chapter = chapterQueryHelper
                .queryChapterById(
                        queryChapterCommand.getChapterId(),
                        queryChapterCommand.getEmail());

        log.info("Returning chapter: {}", chapter);

        return chapterDataMapper.chapterToQueryChapterResponse(chapter);
    }

    @Transactional
    public UpdateChapterResponse updateChapterResponse(
            UpdateChapterCommand updateChapterCommand) {
//        chapterUpdateHelper.persistChapter(updateChapterCommand);
//
//        log.info("Chapter updated with id: {}", updateChapterCommand.getChapterId());
//
//        return chapterDataMapper.chapterToUpdateChapterResponse(
//                new ChapterId(updateChapterCommand.getChapterId()),
//                "Chapter updated successfully");
        return null;

    }

}
