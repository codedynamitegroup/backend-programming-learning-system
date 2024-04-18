package com.backend.programming.learning.system.ports.input.service.question;

import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.dto.method.query.question.QueryAllQuestionCommand;
import com.backend.programming.learning.system.dto.method.query.question.QueryAllQuestionResponse;

import javax.validation.Valid;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.ports.input.service.question
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 10:54 PM
 * Description: ...
 */
public interface QuestionApplicationService {
    CreateQuestionResponse createQuestion(
            @Valid CreateQuestionCommand createQuestionCommand);

    QueryAllQuestionResponse findAllQuestions(
            @Valid QueryAllQuestionCommand queryAllQuestionCommand);
}