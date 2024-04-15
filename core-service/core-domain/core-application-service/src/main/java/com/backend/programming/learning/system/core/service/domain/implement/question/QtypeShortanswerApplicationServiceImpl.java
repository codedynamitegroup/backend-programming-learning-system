package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeShortanswerQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.implement.question.handler.QtypeShortanswerQuestionCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeShortanswerQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@Validated
@Slf4j
public class QtypeShortanswerApplicationServiceImpl implements QtypeShortanswerQuestionApplicationService {
    private final QtypeShortanswerQuestionCommandHandler qtypeShortanswerQuestionCommandHandler;

    public QtypeShortanswerApplicationServiceImpl(QtypeShortanswerQuestionCommandHandler qtypeShortanswerQuestionCommandHandler) {
        this.qtypeShortanswerQuestionCommandHandler = qtypeShortanswerQuestionCommandHandler;
    }

    @Override
    public CreateQuestionResponse createQtypeShortanswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand) {
        return qtypeShortanswerQuestionCommandHandler
                .createQtypeShortanswerQuestion(createQtypeShortanswerQuestionCommand);
    }

    @Override
    public QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionById(UUID qtShortanswerQuestionId) {
        return qtypeShortanswerQuestionCommandHandler.queryQtypeShortanswerQuestionById(qtShortanswerQuestionId);
    }

    @Override
    public List<QueryQtypeShortanswerQuestionResponse> queryAllQtypeShortanswerQuestions() {
        return qtypeShortanswerQuestionCommandHandler.queryAllQtypeShortanswerQuestions();
    }
}
