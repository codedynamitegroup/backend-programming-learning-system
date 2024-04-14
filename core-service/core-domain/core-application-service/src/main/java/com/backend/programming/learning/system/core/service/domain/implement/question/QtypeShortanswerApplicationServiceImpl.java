package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeShortanswerQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
public class QtypeShortanswerApplicationServiceImpl implements QtypeShortanswerQuestionApplicationService {
    private final QtypeShortanswerCreateCommandHandler qtypeShortanswerCreateCommandHandler;

    public QtypeShortanswerApplicationServiceImpl(QtypeShortanswerCreateCommandHandler qtypeShortanswerCreateCommandHandler) {
        this.qtypeShortanswerCreateCommandHandler = qtypeShortanswerCreateCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQtypeShortanswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand) {
        return qtypeShortanswerCreateCommandHandler
                .createQtypeShortanswerQuestion(createQtypeShortanswerQuestionCommand);
    }
}
