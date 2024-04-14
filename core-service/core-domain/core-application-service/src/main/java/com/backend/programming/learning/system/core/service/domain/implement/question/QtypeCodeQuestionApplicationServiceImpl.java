package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.implement.question.handler.QtypeCodeQuestionCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeCodeQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
public class QtypeCodeQuestionApplicationServiceImpl implements QtypeCodeQuestionApplicationService {
    private final QtypeCodeQuestionCommandHandler qtypeCodeQuestionCommandHandler;

    public QtypeCodeQuestionApplicationServiceImpl(QtypeCodeQuestionCommandHandler qtypeCodeQuestionCommandHandler) {
        this.qtypeCodeQuestionCommandHandler = qtypeCodeQuestionCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQtypeCodeQuestion(CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand) {
        return qtypeCodeQuestionCommandHandler.createQtypeCodeQuestion(createQtypeCodeQuestionCommand);
    }
}
