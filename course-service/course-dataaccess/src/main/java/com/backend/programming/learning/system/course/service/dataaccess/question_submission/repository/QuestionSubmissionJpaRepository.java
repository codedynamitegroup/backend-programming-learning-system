package com.backend.programming.learning.system.course.service.dataaccess.question_submission.repository;

import com.backend.programming.learning.system.course.service.dataaccess.question_submission.entity.QuestionSubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface QuestionSubmissionJpaRepository extends JpaRepository<QuestionSubmissionEntity, UUID> {
    Optional<QuestionSubmissionEntity> findById(UUID id);
}
