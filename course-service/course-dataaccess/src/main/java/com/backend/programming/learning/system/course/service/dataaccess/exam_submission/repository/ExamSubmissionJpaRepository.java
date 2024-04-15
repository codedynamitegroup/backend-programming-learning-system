package com.backend.programming.learning.system.course.service.dataaccess.exam_submission.repository;

import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.entity.ExamSubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ExamSubmissionJpaRepository extends JpaRepository<ExamSubmissionEntity, UUID> {
    Optional<ExamSubmissionEntity> findById(UUID id);
}
