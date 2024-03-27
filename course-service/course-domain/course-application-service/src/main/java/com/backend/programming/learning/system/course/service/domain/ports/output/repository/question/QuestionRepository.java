package com.backend.programming.learning.system.course.service.domain.ports.output.repository.question;

import com.backend.programming.learning.system.course.service.domain.entity.question.Question;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.ports.output.repository.question
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:56 PM
 * Description: ...
 */
public interface QuestionRepository {
    Question createQuestion(Long examId, Question question);


    List<Question> getQuestionsByExamId(Long examId);

    void deleteQuestion(Long examId, Long questionId);

    Question getQuestionById(Long questionId);

    Question updateQuestion(Long examId, Long questionId, Question question);
}
