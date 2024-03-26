package com.backend.programming.learning.system.course.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionResponse;

/**
 * com.backend.programming.learning.system.course.service.domain.ports.input.service.question
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 11:00 PM
 * Description: ...
 */
public interface QuestionApplicationService {
    CreateQuestionResponse createQuestion(CreateQuestionCommand createQuestionCommand);
}
