package com.backend.programming.learning.system.core.service.domain.ports;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.CoreApplicationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class CoreApplicationServiceImpl implements CoreApplicationService {
    private final QuestionCreateCommandHandler questionCreateCommandHandler;

    public CoreApplicationServiceImpl(QuestionCreateCommandHandler questionCreateCommandHandler) {
        this.questionCreateCommandHandler = questionCreateCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQuestion(CreateQuestionCommand createQuestionCommand) {
        return questionCreateCommandHandler.createQuestion(createQuestionCommand);
    }
}
