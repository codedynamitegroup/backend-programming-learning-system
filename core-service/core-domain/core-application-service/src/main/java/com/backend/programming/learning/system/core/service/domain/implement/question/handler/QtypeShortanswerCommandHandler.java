package com.backend.programming.learning.system.core.service.domain.implement.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.create.QtypeShortanswerQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QtypeShortanswerCommandHandler {
    private final QtypeShortanswerQuestionCreateHelper qtypeShortanswerCreateHelper;
    private final QuestionDataMapper questionDataMapper;

    public QtypeShortanswerCommandHandler(QtypeShortanswerQuestionCreateHelper qtypeShortanswerCreateHelper,
                                          QuestionDataMapper questionDataMapper) {
        this.qtypeShortanswerCreateHelper = qtypeShortanswerCreateHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeShortanswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeShortanswerCreateHelper.persistQtypeShortanswerQuestion(createQtypeShortanswerQuestionCommand);

        return questionDataMapper.questionToCreateQuestionResponse(questionCreatedEvent.getQuestion(),
                "Qtype Shortanswer Question created successfully");
    }
}
