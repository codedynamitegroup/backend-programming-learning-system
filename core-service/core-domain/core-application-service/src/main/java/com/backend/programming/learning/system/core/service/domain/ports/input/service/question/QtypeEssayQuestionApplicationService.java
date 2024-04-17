package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeEssayQuestionResponse;

import java.util.List;
import java.util.UUID;

public interface QtypeEssayQuestionApplicationService {
    CreateQuestionResponse createQtypeEssayQuestion(CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand);
    QueryQtypeEssayQuestionResponse queryQtypeEssayQuestionById(UUID qtEssayQuestionId);
    List<QueryQtypeEssayQuestionResponse> queryAllQtypeEssayQuestion();
}
