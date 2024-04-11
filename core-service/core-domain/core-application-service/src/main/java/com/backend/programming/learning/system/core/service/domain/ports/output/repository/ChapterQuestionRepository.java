package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.ChapterQuestion;

public interface ChapterQuestionRepository {
    ChapterQuestion saveChapterQuestion(ChapterQuestion chapterQuestion);
}
