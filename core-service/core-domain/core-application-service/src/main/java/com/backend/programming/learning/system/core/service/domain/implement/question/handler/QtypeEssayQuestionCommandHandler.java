package com.backend.programming.learning.system.core.service.domain.implement.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeEssayQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.create.QtypeEssayQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.query.QtypeEssayQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class QtypeEssayQuestionCommandHandler {
    private final QtypeEssayQuestionCreateHelper qtypeEssayQuestionCreateHelper;
    private final QtypeEssayQuestionQueryHelper qtypeEssayQuestionQueryHelper;
    private final QuestionDataMapper questionDataMapper;


    public QtypeEssayQuestionCommandHandler(QtypeEssayQuestionCreateHelper qtypeEssayQuestionCreateHelper,
                                            QtypeEssayQuestionQueryHelper qtypeEssayQuestionQueryHelper,
                                            QuestionDataMapper questionDataMapper) {
        this.qtypeEssayQuestionCreateHelper = qtypeEssayQuestionCreateHelper;
        this.qtypeEssayQuestionQueryHelper = qtypeEssayQuestionQueryHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeEssayQuestion(CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeEssayQuestionCreateHelper.persistQtypeEssayQuestion(createQtypeEssayQuestionCommand);

        return questionDataMapper.questionCreatedEventToCreateQuestionResponse(questionCreatedEvent, "Qtype Essay Question created successfully");
    }

    public QueryQtypeEssayQuestionResponse queryQtypeEssayQuestionById(UUID qtEssayQuestionId) {
        return qtypeEssayQuestionQueryHelper.queryQtypeEssayQuestionById(qtEssayQuestionId);
    }

    public List<QueryQtypeEssayQuestionResponse> queryAllQtypeEssayQuestion() {
        return qtypeEssayQuestionQueryHelper.queryAllQtypeEssayQuestion();
    }
}
