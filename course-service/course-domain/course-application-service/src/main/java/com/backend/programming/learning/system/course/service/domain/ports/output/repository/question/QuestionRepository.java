package com.backend.programming.learning.system.course.service.domain.ports.output.repository.question;

import com.backend.programming.learning.system.course.service.domain.entity.question.Question;

/**
 * com.backend.programming.learning.system.course.service.domain.ports.output.repository.question
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:56 PM
 * Description: ...
 */
public interface QuestionRepository {
    Question createQuestion(Question question);
}
