package com.backend.programming.learning.system.core.service.domain.implement.service.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeEssayQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.create.QtypeEssayQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QtypeEssayQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.update.QtypeEssayQuestionUpdateHelper;
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
public class QtypeEssayQuestionCommandHandler {
    private final QtypeEssayQuestionCreateHelper qtypeEssayQuestionCreateHelper;
    private final QtypeEssayQuestionQueryHelper qtypeEssayQuestionQueryHelper;
    private final QtypeEssayQuestionUpdateHelper qtypeEssayQuestionUpdateHelper;

    private final QuestionOutboxHelper questionOutboxHelper;
    private final QuestionSagaHelper questionSagaHelper;

    private final QuestionDataMapper questionDataMapper;


    public QtypeEssayQuestionCommandHandler(QtypeEssayQuestionCreateHelper qtypeEssayQuestionCreateHelper,
                                            QtypeEssayQuestionQueryHelper qtypeEssayQuestionQueryHelper,
                                            QtypeEssayQuestionUpdateHelper qtypeEssayQuestionUpdateHelper,
                                            QuestionOutboxHelper questionOutboxHelper,
                                            QuestionSagaHelper questionSagaHelper,
                                            QuestionDataMapper questionDataMapper) {
        this.qtypeEssayQuestionCreateHelper = qtypeEssayQuestionCreateHelper;
        this.qtypeEssayQuestionQueryHelper = qtypeEssayQuestionQueryHelper;
        this.qtypeEssayQuestionUpdateHelper = qtypeEssayQuestionUpdateHelper;
        this.questionOutboxHelper = questionOutboxHelper;
        this.questionSagaHelper = questionSagaHelper;
        this.questionDataMapper = questionDataMapper;
    }

    public CreateQuestionResponse createQtypeEssayQuestion(CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand) {
        QuestionCreatedEvent questionCreatedEvent = qtypeEssayQuestionCreateHelper.persistQtypeEssayQuestion(createQtypeEssayQuestionCommand);

        questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionCreatedEventToQuestionEventPayload(questionCreatedEvent),
                questionCreatedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionCreatedEvent.getQuestion().getCopyState()),
                ServiceName.COURSE_SERVICE,
                UUID.randomUUID(), null);

        return questionDataMapper.questionCreatedEventToCreateQuestionResponse(questionCreatedEvent, "Qtype Essay Question created successfully");
    }

    public QueryQtypeEssayQuestionResponse queryQtypeEssayQuestionById(UUID qtEssayQuestionId) {
        return qtypeEssayQuestionQueryHelper.queryQtypeEssayQuestionById(qtEssayQuestionId);
    }

    public List<QueryQtypeEssayQuestionResponse> queryAllQtypeEssayQuestion() {
        return qtypeEssayQuestionQueryHelper.queryAllQtypeEssayQuestion();
    }

    public UpdateQuestionResponse updateQtypeEssayQuestion(UpdateQtypeEssayQuestionCommand updateQtypeEssayQuestionCommand) {
        QuestionUpdatedEvent questionUpdatedEvent = qtypeEssayQuestionUpdateHelper.updateQtypeEssayQuestion(updateQtypeEssayQuestionCommand);

        questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionUpdatedEventToQuestionEventPayload(questionUpdatedEvent),
                questionUpdatedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionUpdatedEvent.getQuestion().getCopyState()),
                ServiceName.COURSE_SERVICE,
                UUID.randomUUID(),
                questionDataMapper.questionUpdatedEventToQuestionEventPreviousPayload(questionUpdatedEvent));

        return questionDataMapper.questionUpdatedEventToUpdateQuestionRespond(questionUpdatedEvent, "Qtype Essay Question updated successfully");
    }
}
