package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.codequestion.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.codequestion.CreateCodeQuestionResponse;

import jakarta.validation.Valid;

public interface CodeQuestionApplicationService {
    CreateCodeQuestionResponse createCodeQuestion(@Valid CreateCodeQuestionCommand command);
}
