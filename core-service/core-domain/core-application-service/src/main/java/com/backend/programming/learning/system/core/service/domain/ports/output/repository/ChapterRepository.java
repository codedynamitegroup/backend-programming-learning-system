package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChapterRepository {
    Chapter saveChapter(Chapter chapter);
    Optional<Chapter> findById(UUID chapterId);
    List<Chapter> findAllByCertificateCourseId(CertificateCourseId certificateCourseId);
    Integer findTopNoByCertificateCourseId(CertificateCourseId certificateCourseId);
    void deleteChapter(UUID chapterId);
}
