package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;
import com.backend.programming.learning.system.core.service.domain.entity.ChapterResourceUser;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChapterResourceUserRepository {
    Boolean checkChapterResourceIsCompleted(UUID chapterResourceId, UUID userId);
    Optional<ChapterResourceUser> findChapterResourceUserByChapterResourceIdAndUserId(UUID chapterResourceId, UUID userId);
    ChapterResourceUser saveChapterResourceUser(ChapterResourceUser chapterResourceUser);
}
