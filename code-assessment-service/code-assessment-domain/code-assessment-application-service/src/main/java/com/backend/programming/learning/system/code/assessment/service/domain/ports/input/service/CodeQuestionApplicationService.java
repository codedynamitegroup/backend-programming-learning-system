package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.CreateCodeQuestionResponse;

import javax.validation.Valid;

public interface CodeQuestionApplicationService {
    CreateCodeQuestionResponse createCodeQuestion(@Valid CreateCodeQuestionCommand command);
}
