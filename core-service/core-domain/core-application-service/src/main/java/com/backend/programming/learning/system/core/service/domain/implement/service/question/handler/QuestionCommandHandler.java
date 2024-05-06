package com.backend.programming.learning.system.core.service.domain.implement.service.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.QuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.delete.QuestionDeleteHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.saga.QuestionSagaHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionEventPreviousPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.code_questions.CodeQuestionsUpdateOutboxHelper;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class QuestionCommandHandler {
    private final QuestionQueryHelper questionQueryHelper;
    private final QuestionDeleteHelper questionDeleteHelper;
    private final QuestionOutboxHelper questionOutboxHelper;
    private final QuestionSagaHelper questionSagaHelper;
    private final QuestionDataMapper questionDataMapper;
    private final CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper;

    public QuestionCommandHandler(QuestionQueryHelper questionQueryHelper, QuestionDeleteHelper questionDeleteHelper,
                                  QuestionOutboxHelper questionOutboxHelper, QuestionSagaHelper questionSagaHelper,
                                  QuestionDataMapper questionDataMapper,
                                  CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper) {
        this.questionQueryHelper = questionQueryHelper;
        this.questionDeleteHelper = questionDeleteHelper;
        this.questionOutboxHelper = questionOutboxHelper;
        this.questionSagaHelper = questionSagaHelper;
        this.questionDataMapper = questionDataMapper;
        this.codeQuestionsUpdateOutboxHelper = codeQuestionsUpdateOutboxHelper;
    }

    public QuestionResponseEntity queryQuestionById(UUID questionId) {
        return questionQueryHelper
                .queryQuestionById(questionId);
    }

    public List<QuestionResponseEntity> queryAllQuestion() {
        return questionQueryHelper
                .queryAllQuestion();
    }

    public QuestionDeleteResponse deleteQuestionById(UUID questionId) {
        QuestionDeletedEvent questionDeletedEvent = questionDeleteHelper.deleteQuestionById(questionId);
        QuestionEventPayload questionEventPayload = questionDataMapper.questionDeletedEventToQuestionEventPayload(questionDeletedEvent);
        QuestionEventPreviousPayload previousPayload = questionDataMapper.questionDeletedEventToQuestionEventPreviousPayload(questionDeletedEvent);

        questionOutboxHelper.saveNewQuestionOutboxMessage(questionEventPayload,
                questionDeletedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionDeletedEvent.getQuestion().getCopyState()),
                ServiceName.COURSE_SERVICE,
                UUID.randomUUID(),
                previousPayload);

        questionOutboxHelper.saveNewQuestionOutboxMessage(questionEventPayload,
                questionDeletedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionDeletedEvent.getQuestion().getCopyState()),
                ServiceName.CODE_ASSESSMENT_SERVICE,
                UUID.randomUUID(),
                previousPayload);

        return QuestionDeleteResponse.builder()
                .questionId(questionId)
                .qtypeId(questionDeletedEvent.getQtypeID())
                .message("Question deleted successfully")
                .build();
    }
}
