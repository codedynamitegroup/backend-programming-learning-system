package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;

import java.util.List;

public interface ChapterRepository {
    Chapter saveChapter(Chapter chapter);
    List<Chapter> findAllByCertificateCourseId(CertificateCourseId certificateCourseId);
    Integer findTopNoByCertificateCourseId(CertificateCourseId certificateCourseId);
}
