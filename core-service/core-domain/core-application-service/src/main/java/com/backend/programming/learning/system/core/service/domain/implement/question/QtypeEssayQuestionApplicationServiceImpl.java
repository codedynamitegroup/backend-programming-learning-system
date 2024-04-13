package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeEssayQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
public class QtypeEssayQuestionApplicationServiceImpl implements QtypeEssayQuestionApplicationService {
    private final QtypeEssayQuestionCreateCommandHandler qtypeEssayQuestionCreateCommandHandler;

    public QtypeEssayQuestionApplicationServiceImpl(QtypeEssayQuestionCreateCommandHandler qtypeEssayQuestionCreateCommandHandler) {
        this.qtypeEssayQuestionCreateCommandHandler = qtypeEssayQuestionCreateCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQtypeEssayQuestion(CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand) {
        return qtypeEssayQuestionCreateCommandHandler
                .createQtypeEssayQuestion(createQtypeEssayQuestionCommand);
    }
}
