package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;


import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAnswerOfQuestionResponse;

import java.util.List;
import java.util.UUID;

public interface AnswerOfQuestionApplicationService {
    AnswerOfQuestionDeleteResponse deleteAnswerOfQuestionById(UUID answerId);

    List<QueryAnswerOfQuestionResponse> getAnswerOfQuestionByQuestionId(UUID questionId);
}
