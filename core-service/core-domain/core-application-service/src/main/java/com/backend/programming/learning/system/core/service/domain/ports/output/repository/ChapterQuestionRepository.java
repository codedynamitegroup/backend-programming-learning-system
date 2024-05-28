package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.ChapterQuestion;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChapterQuestionRepository {
    ChapterQuestion saveChapterQuestion(ChapterQuestion chapterQuestion);
    List<ChapterQuestion> findAllChapterQuestionsByChapterId(UUID chapterId);
    Optional<ChapterQuestion> findFirstUncompletedQuestionByCertificateCourseIdAndUserId(
            UUID certificateCourseId, UUID userId);
}
