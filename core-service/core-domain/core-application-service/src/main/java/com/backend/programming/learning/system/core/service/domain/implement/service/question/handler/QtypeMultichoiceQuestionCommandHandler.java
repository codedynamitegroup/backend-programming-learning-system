package com.backend.programming.learning.system.core.service.domain.implement.service.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeMultichoiceQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.create.QtypeMultichoiceQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QtypeMultichoiceQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.update.QtypeMultichoiceQuestionUpdateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.saga.QuestionSagaHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class QtypeMultichoiceQuestionCommandHandler {
    private final QtypeMultichoiceQuestionCreateHelper qtypeMultichoiceQuestionCreateHelper;
    private final QtypeMultichoiceQuestionQueryHelper qtypeMultichoiceQuestionQueryHelper;
    private final QtypeMultichoiceQuestionUpdateHelper qtypeMultichoiceQuestionUpdateHelper;

    private final QuestionOutboxHelper questionOutboxHelper;
    private final QuestionSagaHelper questionSagaHelper;

    private final QuestionDataMapper questionDataMapper;

    public QtypeMultichoiceQuestionCommandHandler(QtypeMultichoiceQuestionCreateHelper qtypeMultichoiceQuestionCreateHelper,
                                                  QtypeMultichoiceQuestionQueryHelper qtypeMultichoiceQuestionQueryHelper,
                                                  QtypeMultichoiceQuestionUpdateHelper qtypeMultichoiceQuestionUpdateHelper,
                                                  QuestionOutboxHelper questionOutboxHelper,
                                                  QuestionSagaHelper questionSagaHelper,
                                                  QuestionDataMapper questionDataMapper) {
        this.qtypeMultichoiceQuestionCreateHelper = qtypeMultichoiceQuestionCreateHelper;
        this.qtypeMultichoiceQuestionQueryHelper = qtypeMultichoiceQuestionQueryHelper;
        this.qtypeMultichoiceQuestionUpdateHelper = qtypeMultichoiceQuestionUpdateHelper;
        this.questionOutboxHelper = questionOutboxHelper;
        this.questionSagaHelper = questionSagaHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeMultichoiceQuestion(CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeMultichoiceQuestionCreateHelper.persistQtypeMultichoiceQuestion(createQtypeMultichoiceQuestionCommand);

        questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionCreatedEventToQuestionEventPayload(questionCreatedEvent),
                questionCreatedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionCreatedEvent.getQuestion().getCopyState()),
                UUID.randomUUID());

        return questionDataMapper.questionCreatedEventToCreateQuestionResponse(questionCreatedEvent, "Qtype Multichoice Question created successfully");
    }

    public QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionById(UUID qtMultichoiceQuestionId) {
        return qtypeMultichoiceQuestionQueryHelper.queryQtypeMultichoiceQuestionById(qtMultichoiceQuestionId);
    }

    public List<QueryQtypeMultichoiceQuestionResponse> queryAllQtypeMultichoiceQuestion() {
        return qtypeMultichoiceQuestionQueryHelper.queryAllQtypeMultichoiceQuestion();
    }

    public UpdateQuestionResponse updateQtypeMultichoiceQuestion(UpdateQtypeMultichoiceQuestionCommand updateQtypeMultichoiceQuestionCommand) {
        QuestionUpdatedEvent questionUpdatedEvent = qtypeMultichoiceQuestionUpdateHelper.updateQtypeMultichoiceQuestionInDb(updateQtypeMultichoiceQuestionCommand);

        questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionUpdatedEventToQuestionEventPayload(questionUpdatedEvent),
                questionUpdatedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionUpdatedEvent.getQuestion().getCopyState()),
                UUID.randomUUID());

        return questionDataMapper.questionUpdatedEventToUpdateQuestionRespond(questionUpdatedEvent,
                "Qtype Multichoice Question updated successfully");
    }
}
