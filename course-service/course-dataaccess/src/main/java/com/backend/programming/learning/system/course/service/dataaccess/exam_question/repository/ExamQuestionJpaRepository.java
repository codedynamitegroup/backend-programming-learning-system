package com.backend.programming.learning.system.course.service.dataaccess.exam_question.repository;

import com.backend.programming.learning.system.course.service.dataaccess.exam_question.entity.ExamQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ExamQuestionJpaRepository extends JpaRepository<ExamQuestionEntity, UUID> {
    Optional<ExamQuestionEntity> findById(UUID id);
}
