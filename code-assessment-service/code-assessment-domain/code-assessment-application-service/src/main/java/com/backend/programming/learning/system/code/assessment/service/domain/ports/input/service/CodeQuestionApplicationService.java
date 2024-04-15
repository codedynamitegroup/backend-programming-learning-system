package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.codequestion.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.codequestion.CreateCodeQuestionResponse;

import javax.validation.Valid;

public interface CodeQuestionApplicationService {
    CreateCodeQuestionResponse createCodeQuestion(@Valid CreateCodeQuestionCommand command);
}
