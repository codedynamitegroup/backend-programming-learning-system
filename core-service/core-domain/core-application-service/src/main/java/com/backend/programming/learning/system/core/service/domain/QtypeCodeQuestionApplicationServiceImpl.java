package com.backend.programming.learning.system.core.service.domain;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.QtypeCodeQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
public class QtypeCodeQuestionApplicationServiceImpl implements QtypeCodeQuestionApplicationService {
    private final QtypeCodeQuestionCreateCommandHandler qtypeCodeQuestionCreateCommandHandler;

    public QtypeCodeQuestionApplicationServiceImpl(QtypeCodeQuestionCreateCommandHandler qtypeCodeQuestionCreateCommandHandler) {
        this.qtypeCodeQuestionCreateCommandHandler = qtypeCodeQuestionCreateCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQtypeCodeQuestion(CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand) {
        return qtypeCodeQuestionCreateCommandHandler.createQtypeCodeQuestion(createQtypeCodeQuestionCommand);
    }
}
