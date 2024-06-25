package com.backend.programming.learning.system.course.service.dataaccess.exam_submission.repository;

import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import com.backend.programming.learning.system.course.service.dataaccess.exam_submission.entity.ExamSubmissionEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExamSubmissionJpaRepository extends JpaRepository<ExamSubmissionEntity, UUID> {
    Optional<ExamSubmissionEntity> findById(UUID id);

    Optional<List<ExamSubmissionEntity>> findByExamAndUser(ExamEntity examEntity, UserEntity userEntity);

    @Query("""
            SELECT COUNT(DISTINCT es.user)
            FROM ExamSubmissionEntity es
            WHERE es.exam.id = :examId AND es.user.roleMoodle.id = 5
            """)
    Integer countSubmission(UUID examId);

    Optional<List<ExamSubmissionEntity>> findByExamId(UUID examId);

    @Query("""
            SELECT es
            FROM ExamSubmissionEntity es
            WHERE es.exam.id = :examId AND es.user.id = :userId
            """)
    List<ExamSubmissionEntity> findByExamIdAndUserId(UUID examId, UUID userId);

    @Query(value = """
            SELECT * FROM exam_submission
            WHERE exam_id = :examId AND user_id = :userId
            ORDER BY submit_count DESC
            LIMIT 1
            """, nativeQuery = true)
    Optional<ExamSubmissionEntity> findLatestExamSubmission(UUID examId, UUID userId);
}
