package com.backend.programming.learning.system.core.service.domain.implement.service.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.create.QtypeCodeQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QtypeCodeQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.update.QtypeCodeQuestionUpdateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.question.QuestionCreatedMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.question.QuestionUpdatedMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class QtypeCodeQuestionCommandHandler {
    private final QtypeCodeQuestionCreateHelper qtypeCodeQuestionCreateHelper;
    private final QtypeCodeQuestionQueryHelper qtypeCodeQuestionQueryHelper;
    private final QtypeCodeQuestionUpdateHelper qtypeCodeQuestionUpdateHelper;

    private final QuestionUpdatedMessagePublisher questionUpdatedMessagePublisher;
    private final QuestionCreatedMessagePublisher questionCreatedMessagePublisher;

    private final QuestionDataMapper questionDataMapper;


    public QtypeCodeQuestionCommandHandler(QtypeCodeQuestionCreateHelper qtypeCodeQuestionCreateHelper,
                                           QtypeCodeQuestionQueryHelper qtypeCodeQuestionQueryHelper,
                                           QtypeCodeQuestionUpdateHelper qtypeCodeQuestionUpdateHelper,
                                           QuestionDataMapper questionDataMapper,
                                           QuestionUpdatedMessagePublisher questionUpdatedMessagePublisher,
                                           QuestionCreatedMessagePublisher questionCreatedMessagePublisher) {
        this.qtypeCodeQuestionCreateHelper = qtypeCodeQuestionCreateHelper;
        this.qtypeCodeQuestionQueryHelper = qtypeCodeQuestionQueryHelper;
        this.qtypeCodeQuestionUpdateHelper = qtypeCodeQuestionUpdateHelper;
        this.questionDataMapper = questionDataMapper;
        this.questionUpdatedMessagePublisher = questionUpdatedMessagePublisher;
        this.questionCreatedMessagePublisher = questionCreatedMessagePublisher;
    }

    public CreateQuestionResponse createQtypeCodeQuestion(CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeCodeQuestionCreateHelper.persistQtypeCodeQuestion(createQtypeCodeQuestionCommand);
        questionCreatedMessagePublisher.publish(questionCreatedEvent);

        return questionDataMapper.questionCreatedEventToCreateQuestionResponse(questionCreatedEvent, "Qtype Code Question created successfully");
    }

    public QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionById(UUID qtypeCodeQuestionId) {
        return qtypeCodeQuestionQueryHelper.queryQtypeCodeQuestionById(qtypeCodeQuestionId);
    }

    public List<QueryQtypeCodeQuestionResponse> queryAllQtypeCodeQuestion() {
        return qtypeCodeQuestionQueryHelper.queryAllQtypeCodeQuestions();
    }

    public UpdateQuestionResponse updateQtypeCodeQuestion(UpdateQtypeCodeQuestionCommand updateQtypeCodeQuestionCommand) {
        QuestionUpdatedEvent questionUpdatedEvent = qtypeCodeQuestionUpdateHelper.updateQtypeCodeQuestionInDb(updateQtypeCodeQuestionCommand);

        questionUpdatedMessagePublisher.publish(questionUpdatedEvent);

        return questionDataMapper.questionUpdatedEventToUpdateQuestionRespond(questionUpdatedEvent, "Qtype Code Question updated successfully");
    }
}
