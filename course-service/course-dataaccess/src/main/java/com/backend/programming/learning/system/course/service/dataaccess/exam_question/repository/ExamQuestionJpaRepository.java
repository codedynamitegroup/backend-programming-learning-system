package com.backend.programming.learning.system.course.service.dataaccess.exam_question.repository;

import com.backend.programming.learning.system.course.service.dataaccess.exam_question.entity.ExamQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ExamQuestionJpaRepository extends JpaRepository<ExamQuestionEntity, UUID> {
    Optional<ExamQuestionEntity> findById(UUID id);

    void deleteByExamIdAndQuestionIdIn(UUID examId, List<UUID> questionIds);

    void deleteAllByExamId(UUID examId);

    List<ExamQuestionEntity> findAllByExamId(UUID examId);

    @Query(
            value = "SELECT COUNT(*) FROM exam_question WHERE exam_id = ?1",
            nativeQuery = true
    )
    Float countByExamId(UUID value);
}
