package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.QuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllQuestionByCategoryIdCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllQuestionByCategoryIdResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface QuestionApplicationService {
    QuestionResponseEntity queryQuestionById(UUID questionId);
    List<QuestionResponseEntity> queryAllQuestion();
    QuestionDeleteResponse deleteQuestionById(UUID questionId);

    QueryAllQuestionByCategoryIdResponse queryAllQuestionByCategory(
            UUID categoryId,
            @Valid QueryAllQuestionByCategoryIdCommand queryAllQuestionByCategoryIdCommand);
}
