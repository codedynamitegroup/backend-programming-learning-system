package com.backend.programming.learning.system.core.service.dataaccess.chapter_question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.chapter_question.entity.ChapterQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChapterQuestionJpaRepository extends JpaRepository<ChapterQuestionEntity, UUID> {
    Optional<ChapterQuestionEntity> findById(UUID id);
}
