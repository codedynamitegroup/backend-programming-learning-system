package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface QtypeCodeQuestionApplicationService {
    CreateQuestionResponse createQtypeCodeQuestion(@Valid CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand);
    QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionById(UUID qtCodeQuestionId);
    List<QueryQtypeCodeQuestionResponse> queryAllQtypeCodeQuestions();
    UpdateQuestionResponse updateQtypeCodeQuestion(UpdateQtypeCodeQuestionCommand updateQtypeCodeQuestionCommand);
}
