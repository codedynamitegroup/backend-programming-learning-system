package com.backend.programming.learning.system.core.service.domain.implement.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.create.QtypeCodeQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QtypeCodeQuestionCommandHandler {
    private final QtypeCodeQuestionCreateHelper qtypeCodeQuestionCreateHelper;
    private final QuestionDataMapper questionDataMapper;

    public QtypeCodeQuestionCommandHandler(QtypeCodeQuestionCreateHelper qtypeCodeQuestionCreateHelper,
                                           QuestionDataMapper questionDataMapper) {
        this.qtypeCodeQuestionCreateHelper = qtypeCodeQuestionCreateHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeCodeQuestion(CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeCodeQuestionCreateHelper.persistQtypeCodeQuestion(createQtypeCodeQuestionCommand);


        return questionDataMapper.questionToCreateQuestionResponse(questionCreatedEvent.getQuestion(),
                "Qtype Code Question created successfully");
    }
}
