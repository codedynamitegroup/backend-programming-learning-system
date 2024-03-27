package com.backend.programming.learning.system.course.service.dataaccess.repository.question;

import com.backend.programming.learning.system.course.service.dataaccess.entity.question.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.repository.question
 * Create by Dang Ngoc Tien
 * Date 3/26/2024 - 10:37 PM
 * Description: ...
 */
@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, Long> {

    @Query("""
            SELECT q
            FROM QuestionEntity q
            JOIN ExamQuestionEntity eq ON q.id = eq.questionId
            WHERE eq.examId = :examId
    """)
    List<QuestionEntity> getQuestionsByExamId(Long examId);
}
