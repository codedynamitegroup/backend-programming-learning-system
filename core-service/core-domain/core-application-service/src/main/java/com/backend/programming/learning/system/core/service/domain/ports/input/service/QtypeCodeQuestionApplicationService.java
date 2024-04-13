package com.backend.programming.learning.system.core.service.domain.ports.input.service;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeCodeQuestionCommand;

import javax.validation.Valid;

public interface QtypeCodeQuestionApplicationService {
    CreateQuestionResponse createQtypeCodeQuestion(@Valid CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand);
}
