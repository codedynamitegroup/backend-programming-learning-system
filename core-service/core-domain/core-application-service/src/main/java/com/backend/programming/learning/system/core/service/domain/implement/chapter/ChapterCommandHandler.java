package com.backend.programming.learning.system.core.service.domain.implement.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
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

@Component
@Slf4j
public class ChapterCommandHandler {
    private final ChapterCreateHelper chapterCreateHelper;
    private final ChapterDataMapper chapterDataMapper;
    private final ChapterRepository chapterRepository;

    public ChapterCommandHandler(ChapterCreateHelper chapterCreateHelper,
                                 ChapterDataMapper chapterDataMapper,
                                 ChapterRepository chapterRepository) {
        this.chapterCreateHelper = chapterCreateHelper;
        this.chapterDataMapper = chapterDataMapper;
        this.chapterRepository = chapterRepository;
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

}
