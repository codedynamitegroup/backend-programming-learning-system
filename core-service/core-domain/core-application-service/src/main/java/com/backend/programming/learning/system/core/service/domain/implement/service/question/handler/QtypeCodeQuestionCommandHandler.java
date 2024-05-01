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
import com.backend.programming.learning.system.core.service.domain.implement.service.question.saga.QuestionSagaHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.outbox.OutboxStatus;
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

    private final QuestionOutboxHelper questionOutboxHelper;
    private final QuestionSagaHelper questionSagaHelper;

    private final QuestionDataMapper questionDataMapper;


    public QtypeCodeQuestionCommandHandler(QtypeCodeQuestionCreateHelper qtypeCodeQuestionCreateHelper,
                                           QtypeCodeQuestionQueryHelper qtypeCodeQuestionQueryHelper,
                                           QtypeCodeQuestionUpdateHelper qtypeCodeQuestionUpdateHelper,
                                           QuestionOutboxHelper questionOutboxHelper,
                                           QuestionSagaHelper questionSagaHelper,
                                           QuestionDataMapper questionDataMapper) {
        this.qtypeCodeQuestionCreateHelper = qtypeCodeQuestionCreateHelper;
        this.qtypeCodeQuestionQueryHelper = qtypeCodeQuestionQueryHelper;
        this.qtypeCodeQuestionUpdateHelper = qtypeCodeQuestionUpdateHelper;
        this.questionOutboxHelper = questionOutboxHelper;
        this.questionSagaHelper = questionSagaHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeCodeQuestion(CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeCodeQuestionCreateHelper.persistQtypeCodeQuestion(createQtypeCodeQuestionCommand);

        questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionCreatedEventToQuestionEventPayload(questionCreatedEvent),
                questionCreatedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionCreatedEvent.getQuestion().getCopyState()),
                UUID.randomUUID());

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

        questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionUpdatedEventToQuestionEventPayload(questionUpdatedEvent),
                questionUpdatedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionUpdatedEvent.getQuestion().getCopyState()),
                UUID.randomUUID());

        return questionDataMapper.questionUpdatedEventToUpdateQuestionRespond(questionUpdatedEvent, "Qtype Code Question updated successfully");
    }
}
