package com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter;

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

import javax.validation.Valid;

public interface ChapterApplicationService {
    CreateChapterResponse createChapter(
            @Valid CreateChapterCommand createChapterCommand);

    DeleteChapterResponse deleteChapter(
            @Valid DeleteChapterCommand deleteChapterCommand);
    QueryAllChaptersResponse queryAllChapters(
            @Valid QueryAllChaptersCommand queryAllChaptersCommand);

    QueryChapterResponse queryChapter(
            @Valid QueryChapterCommand queryChapterCommand);
}
