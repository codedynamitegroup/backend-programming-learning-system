package com.backend.programming.learning.system.core.service.domain.implement.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeMultichoiceQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.create.QtypeMultichoiceQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.query.QtypeMultichoiceQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class QtypeMultichoiceQuestionCommandHandler {
    private final QtypeMultichoiceQuestionCreateHelper qtypeMultichoiceQuestionCreateHelper;
    private final QtypeMultichoiceQuestionQueryHelper qtypeMultichoiceQuestionQueryHelper;
    private final QuestionDataMapper questionDataMapper;

    public QtypeMultichoiceQuestionCommandHandler(QtypeMultichoiceQuestionCreateHelper qtypeMultichoiceQuestionCreateHelper,
                                                  QtypeMultichoiceQuestionQueryHelper qtypeMultichoiceQuestionQueryHelper,
                                                  QuestionDataMapper questionDataMapper) {
        this.qtypeMultichoiceQuestionCreateHelper = qtypeMultichoiceQuestionCreateHelper;
        this.qtypeMultichoiceQuestionQueryHelper = qtypeMultichoiceQuestionQueryHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeMultichoiceQuestion(CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeMultichoiceQuestionCreateHelper.persistQtypeMultichoiceQuestion(createQtypeMultichoiceQuestionCommand);

        return questionDataMapper.questionToCreateQuestionResponse(questionCreatedEvent.getQuestion(),
                "Qtype Multichoice Question created successfully");
    }

    public QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionById(UUID qtMultichoiceQuestionId) {
        return qtypeMultichoiceQuestionQueryHelper.queryQtypeMultichoiceQuestionById(qtMultichoiceQuestionId);
    }

    public List<QueryQtypeMultichoiceQuestionResponse> queryAllQtypeMultichoiceQuestion() {
        return qtypeMultichoiceQuestionQueryHelper.queryAllQtypeMultichoiceQuestion();
    }
}
