package com.backend.programming.learning.system.core.service.domain.implement.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.create.QtypeCodeQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.query.QtypeCodeQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class QtypeCodeQuestionCommandHandler {
    private final QtypeCodeQuestionCreateHelper qtypeCodeQuestionCreateHelper;
    private final QtypeCodeQuestionQueryHelper qtypeCodeQuestionQueryHelper;
    private final QuestionDataMapper questionDataMapper;

    public QtypeCodeQuestionCommandHandler(QtypeCodeQuestionCreateHelper qtypeCodeQuestionCreateHelper,
                                           QtypeCodeQuestionQueryHelper qtypeCodeQuestionQueryHelper,
                                           QuestionDataMapper questionDataMapper) {
        this.qtypeCodeQuestionCreateHelper = qtypeCodeQuestionCreateHelper;
        this.qtypeCodeQuestionQueryHelper = qtypeCodeQuestionQueryHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeCodeQuestion(CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeCodeQuestionCreateHelper.persistQtypeCodeQuestion(createQtypeCodeQuestionCommand);

        return questionDataMapper.questionToCreateQuestionResponse(questionCreatedEvent.getQuestion(),
                "Qtype Code Question created successfully");
    }

    public QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionById(UUID qtypeCodeQuestionId) {
        return qtypeCodeQuestionQueryHelper.queryQtypeCodeQuestionById(qtypeCodeQuestionId);
    }

    public List<QueryQtypeCodeQuestionResponse> queryAllQtypeCodeQuestion() {
        return qtypeCodeQuestionQueryHelper.queryAllQtypeCodeQuestions();
    }
}
