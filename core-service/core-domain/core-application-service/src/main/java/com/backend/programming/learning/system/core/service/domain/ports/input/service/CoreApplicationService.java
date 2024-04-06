package com.backend.programming.learning.system.core.service.domain.ports.input.service;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import jakarta.validation.Valid;

public interface CoreApplicationService {
    // Question
    CreateQuestionResponse createQuestion(@Valid  CreateQuestionCommand createQuestionCommand);

    //
}
