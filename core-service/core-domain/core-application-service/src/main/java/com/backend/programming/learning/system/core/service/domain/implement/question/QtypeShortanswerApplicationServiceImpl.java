package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.implement.question.handler.QtypeShortanswerCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeShortanswerQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
public class QtypeShortanswerApplicationServiceImpl implements QtypeShortanswerQuestionApplicationService {
    private final QtypeShortanswerCommandHandler qtypeShortanswerCommandHandler;

    public QtypeShortanswerApplicationServiceImpl(QtypeShortanswerCommandHandler qtypeShortanswerCommandHandler) {
        this.qtypeShortanswerCommandHandler = qtypeShortanswerCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQtypeShortanswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand) {
        return qtypeShortanswerCommandHandler
                .createQtypeShortanswerQuestion(createQtypeShortanswerQuestionCommand);
    }
}
