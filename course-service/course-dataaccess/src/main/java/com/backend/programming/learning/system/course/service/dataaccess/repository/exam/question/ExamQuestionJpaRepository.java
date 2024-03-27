package com.backend.programming.learning.system.course.service.dataaccess.repository.exam.question;

import com.backend.programming.learning.system.course.service.dataaccess.entity.exam.question.ExamQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.repository.exam.question
 * Create by Dang Ngoc Tien
 * Date 3/27/2024 - 10:27 PM
 * Description: ...
 */
@Repository
public interface ExamQuestionJpaRepository extends JpaRepository<ExamQuestionEntity, Long> {
    void deleteByExamIdAndQuestionId(Long examId, Long questionId);
}
