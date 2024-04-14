package com.backend.programming.learning.system.core.service.domain.ports.input.service.chapter;

import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.chapter.CreateChapterResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;

import javax.validation.Valid;

public interface ChapterApplicationService {
    CreateChapterResponse createChapter(
            @Valid CreateChapterCommand createChapterCommand);
}
