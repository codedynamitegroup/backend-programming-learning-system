package com.backend.programming.learning.system.course.service.dataaccess.question_submission_file.repository;

import com.backend.programming.learning.system.course.service.dataaccess.question_submission_file.entity.QuestionSubmissionFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionSubmissionFileJpaRepository extends JpaRepository<QuestionSubmissionFileEntity, UUID> {
    @Query(value = """
            SELECT qsf
            FROM question_submission_file qsf
            WHERE qsf.id = ?1
            """, nativeQuery = true)
    Optional<QuestionSubmissionFileEntity> findByQuestionSubmissionFileIdAndUserId(UUID questionSubmissionFileId);
}
