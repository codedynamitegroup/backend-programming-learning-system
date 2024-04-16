package com.backend.programming.learning.system.core.service.domain.implement.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.chapter.DeleteChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.chapter.DeleteChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryAllChaptersCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryAllChaptersResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.chapter.QueryChapterResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.implement.contest.ContestCreateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.chapter.ChapterDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.contest.ContestDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ChapterRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
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
    private final ChapterDataMapper chapterDataMapper;

    public ChapterCommandHandler(ChapterCreateHelper chapterCreateHelper,
                                 ChapterDeleteHelper chapterDeleteHelper,
                                 ChapterQueryHelper chapterQueryHelper,
                                 ChapterDataMapper chapterDataMapper) {
        this.chapterCreateHelper = chapterCreateHelper;
        this.chapterDeleteHelper = chapterDeleteHelper;
        this.chapterQueryHelper = chapterQueryHelper;
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
                .queryAllChapters(queryAllChaptersCommand.getCertificateCourseId());

        log.info("Returning all chapters: {}", chapters);

        return chapterDataMapper.chaptersToQueryAllChaptersResponse(chapters);
    }

    @Transactional(readOnly = true)
    public QueryChapterResponse queryChapterResponse(
            QueryChapterCommand queryChapterCommand) {
        Chapter chapter = chapterQueryHelper
                .queryChapterById(queryChapterCommand.getChapterId());

        log.info("Returning chapter: {}", chapter);

        return chapterDataMapper.chapterToQueryChapterResponse(chapter);
    }

}
