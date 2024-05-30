package com.backend.programming.learning.system.core.service.domain.implement.service.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeShortanswerQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.create.QtypeShortanswerQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QtypeShortanswerQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.update.QtypeShortanswerQuestionUpdateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.saga.QuestionSagaHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class QtypeShortanswerQuestionCommandHandler {
    private final QtypeShortanswerQuestionCreateHelper qtypeShortanswerCreateHelper;
    private final QtypeShortanswerQuestionQueryHelper qtypeShortanswerQuestionQueryHelper;
    private final QtypeShortanswerQuestionUpdateHelper qtypeShortanswerQuestionUpdateHelper;
    private final QuestionOutboxHelper questionOutboxHelper;
    private final QuestionSagaHelper questionSagaHelper;
    private final QuestionDataMapper questionDataMapper;

    public QtypeShortanswerQuestionCommandHandler(QtypeShortanswerQuestionCreateHelper qtypeShortanswerCreateHelper,
                                                  QtypeShortanswerQuestionQueryHelper qtypeShortanswerQuestionQueryHelper,
                                                  QtypeShortanswerQuestionUpdateHelper qtypeShortanswerQuestionUpdateHelper,
                                                  QuestionOutboxHelper questionOutboxHelper,
                                                  QuestionSagaHelper questionSagaHelper,
                                                  QuestionDataMapper questionDataMapper) {
        this.qtypeShortanswerCreateHelper = qtypeShortanswerCreateHelper;
        this.qtypeShortanswerQuestionQueryHelper = qtypeShortanswerQuestionQueryHelper;
        this.qtypeShortanswerQuestionUpdateHelper = qtypeShortanswerQuestionUpdateHelper;
        this.questionOutboxHelper = questionOutboxHelper;
        this.questionSagaHelper = questionSagaHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeShortanswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeShortanswerCreateHelper.persistQtypeShortanswerQuestion(createQtypeShortanswerQuestionCommand);

        questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionCreatedEventToQuestionEventPayload(questionCreatedEvent),
                questionCreatedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionCreatedEvent.getQuestion().getCopyState()),
                ServiceName.COURSE_SERVICE,
                UUID.randomUUID(), null);

        return questionDataMapper.questionCreatedEventToCreateQuestionResponse(questionCreatedEvent, "Qtype Shortanswer Question created successfully");
    }

    public QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionById(UUID qtShortanswerQuestionId) {
        return qtypeShortanswerQuestionQueryHelper.queryQtypeShortanswerQuestionById(qtShortanswerQuestionId);
    }

    public List<QueryQtypeShortanswerQuestionResponse> queryAllQtypeShortanswerQuestions() {
        return qtypeShortanswerQuestionQueryHelper.queryAllQtypeShortanswerQuestions();
    }

    public UpdateQuestionResponse updateQtypeShortanswerQuestion(UpdateQtypeShortanswerQuestionCommand updateQtypeShortanswerQuestionCommand) {
        QuestionUpdatedEvent questionUpdatedEvent = qtypeShortanswerQuestionUpdateHelper.updateQtypeShortanswerQuestionInDb(updateQtypeShortanswerQuestionCommand);

        questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionUpdatedEventToQuestionEventPayload(questionUpdatedEvent),
                questionUpdatedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionUpdatedEvent.getQuestion().getCopyState()),
                ServiceName.COURSE_SERVICE,
                UUID.randomUUID(),
                questionDataMapper.questionUpdatedEventToQuestionEventPreviousPayload(questionUpdatedEvent));

        return questionDataMapper
                .questionUpdatedEventToUpdateQuestionRespond(questionUpdatedEvent, "Qtype Shortanswer Question updated successfully");
    }

    public QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionByQuestionId(UUID questionId) {
        return qtypeShortanswerQuestionQueryHelper.queryQtypeShortanswerQuestionByQuestionId(questionId);
    }
}
