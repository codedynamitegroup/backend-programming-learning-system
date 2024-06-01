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
            SELECT COUNT(es)
            FROM ExamSubmissionEntity es
            WHERE es.exam.id = :examId
            """)
    Integer countSubmission(UUID examId);
}
