package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeCodeQuestionResponse;

import javax.validation.Valid;
import java.util.UUID;

public interface QtypeCodeQuestionApplicationService {
    CreateQuestionResponse createQtypeCodeQuestion(@Valid CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand);
    QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionById(UUID qtCodeQuestionId);
}
