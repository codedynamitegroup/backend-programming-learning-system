package com.backend.programming.learning.system.course.service.dataaccess.question_submission.repository;

import com.backend.programming.learning.system.course.service.dataaccess.question_submission.entity.QuestionSubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface QuestionSubmissionJpaRepository extends JpaRepository<QuestionSubmissionEntity, UUID> {
    Optional<QuestionSubmissionEntity> findById(UUID id);

    List<QuestionSubmissionEntity> findByExamSubmissionId(UUID submissionId);

    Optional<QuestionSubmissionEntity> findByExamSubmissionIdAndQuestionId(UUID examSubmissionId, UUID questionId);

    @Query("""
           SELECT qs
           FROM QuestionSubmissionEntity qs
           WHERE qs.user.id = :userId
                AND qs.examSubmission.exam.id = :examId
           """)
    List<QuestionSubmissionEntity> findByExamIdAndUserId(UUID examId, UUID userId);

    @Query(value = """
           SELECT *
           FROM question_submission
           WHERE exam_submission_id = :examSubmissionId
                AND question_id IN :questionIdList
           """, nativeQuery = true)
    List<QuestionSubmissionEntity> findAllByExamSubmissionIdAndQuestionIdList(UUID examSubmissionId, List<UUID> questionIdList);
}
