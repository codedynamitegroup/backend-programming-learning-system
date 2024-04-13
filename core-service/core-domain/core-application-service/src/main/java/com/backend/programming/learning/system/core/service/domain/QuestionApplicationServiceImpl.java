package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.QuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@Slf4j
class QuestionApplicationServiceImpl implements QuestionApplicationService {
    private final QuestionCreateCommandHandler questionCreateCommandHandler;

    public QuestionApplicationServiceImpl(QuestionCreateCommandHandler questionCreateCommandHandler) {
        this.questionCreateCommandHandler = questionCreateCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQuestion(@Valid CreateQuestionCommand createQuestionCommand) {
        return questionCreateCommandHandler.createQuestion(createQuestionCommand);
    }
}
