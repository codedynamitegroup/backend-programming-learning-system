package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;


import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;

import java.util.UUID;

public interface AnswerOfQuestionApplicationService {
    AnswerOfQuestionDeleteResponse deleteAnswerOfQuestionById(UUID answerId);
}
