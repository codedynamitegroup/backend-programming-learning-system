package com.backend.programming.learning.system.core.service.domain.ports.input.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeCodeQuestionCommand;

import javax.validation.Valid;

public interface QtypeCodeQuestionApplicationService {
    CreateQuestionResponse createQtypeCodeQuestion(@Valid CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand);
}
