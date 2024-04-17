package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeMultichoiceQuestionResponse;

import java.util.List;
import java.util.UUID;

public interface QtypeMultichoiceQuestionApplicationService {
    CreateQuestionResponse createQtypeMultichoiceQuestion(CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand);
    QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionById(UUID qtMultichoiceQuestionId);
    List<QueryQtypeMultichoiceQuestionResponse> queryAllQtypeMultichoiceQuestion();
}
