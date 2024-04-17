package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.delete.question.QuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QuestionResponseEntity;

import java.util.List;
import java.util.UUID;

public interface QuestionApplicationService {
    QuestionResponseEntity queryQuestionById(UUID questionId);
    List<QuestionResponseEntity> queryAllQuestion();
    QuestionDeleteResponse deleteQuestionById(UUID questionId);
}
