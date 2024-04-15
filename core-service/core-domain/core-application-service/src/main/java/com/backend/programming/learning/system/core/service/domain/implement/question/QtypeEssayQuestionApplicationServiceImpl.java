package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeEssayQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.implement.question.handler.QtypeEssayQuestionCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeEssayQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
public class QtypeEssayQuestionApplicationServiceImpl implements QtypeEssayQuestionApplicationService {
    private final QtypeEssayQuestionCommandHandler qtypeEssayQuestionCommandHandler;

    public QtypeEssayQuestionApplicationServiceImpl(QtypeEssayQuestionCommandHandler qtypeEssayQuestionCommandHandler) {
        this.qtypeEssayQuestionCommandHandler = qtypeEssayQuestionCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQtypeEssayQuestion(CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand) {
        return qtypeEssayQuestionCommandHandler
                .createQtypeEssayQuestion(createQtypeEssayQuestionCommand);
    }

    @Override
    public QueryQtypeEssayQuestionResponse queryQtypeEssayQuestionById(UUID qtEssayQuestionId) {
        return qtypeEssayQuestionCommandHandler.queryQtypeEssayQuestionById(qtEssayQuestionId);
    }
}
