package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.ChapterResource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChapterResourceRepository {
    ChapterResource saveChapterResource(ChapterResource chapterResource);
    List<ChapterResource> findAllChapterResourcesByChapterId(UUID chapterId);
    Optional<ChapterResource> findFirstUncompletedResourceByCertificateCourseIdAndUserId(
            UUID certificateCourseId, UUID userId);
    Optional<ChapterResource> findChapterResourceById(UUID chapterResourceId);
}
