package com.backend.programming.learning.system.course.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.question.get.QuestionResponse;

/**
 * com.backend.programming.learning.system.course.service.domain.ports.input.service.question
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:00 PM
 * Description: ...
 */
public interface QuestionApplicationService {
    CreateQuestionResponse createQuestion(Long examId, CreateQuestionCommand createQuestionCommand);

    QuestionResponse getQuestions(Long examId);

    void deleteQuestion(Long examId, Long questionId);

    CreateQuestionResponse getQuestion(Long questionId);

    CreateQuestionResponse updateQuestion(Long examId, Long questionId, CreateQuestionCommand createQuestionCommand);
}
