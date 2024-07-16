package com.backend.programming.learning.system.core.service.domain.implement.service.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllAdminCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllAdminQtypeCodeQuestionsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.create.QtypeCodeQuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QtypeCodeQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.update.QtypeCodeQuestionUpdateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.saga.QuestionSagaHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeCodeQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    private final QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper;


    public QtypeCodeQuestionCommandHandler(QtypeCodeQuestionCreateHelper qtypeCodeQuestionCreateHelper,
                                           QtypeCodeQuestionQueryHelper qtypeCodeQuestionQueryHelper,
                                           QtypeCodeQuestionUpdateHelper qtypeCodeQuestionUpdateHelper,
                                           QuestionOutboxHelper questionOutboxHelper,
                                           QuestionSagaHelper questionSagaHelper,
                                           QuestionDataMapper questionDataMapper,
                                           QtypeCodeQuestionDataMapper qtypeCodeQuestionDataMapper) {
        this.qtypeCodeQuestionCreateHelper = qtypeCodeQuestionCreateHelper;
        this.qtypeCodeQuestionQueryHelper = qtypeCodeQuestionQueryHelper;
        this.qtypeCodeQuestionUpdateHelper = qtypeCodeQuestionUpdateHelper;
        this.questionOutboxHelper = questionOutboxHelper;
        this.questionSagaHelper = questionSagaHelper;
        this.questionDataMapper = questionDataMapper;
        this.qtypeCodeQuestionDataMapper = qtypeCodeQuestionDataMapper;
    }

    public CreateQuestionResponse createQtypeCodeQuestion(CreateQtypeCodeQuestionCommand command) {
        QuestionCreatedEvent questionCreatedEvent = qtypeCodeQuestionCreateHelper.persistQtypeCodeQuestion(command);

        questionOutboxHelper.saveNewQuestionOutboxMessage(
                questionDataMapper.codeQuestionCreatedEventToQuestionEventPayload(questionCreatedEvent, command),
                questionCreatedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionCreatedEvent.getQuestion().getCopyState()),
                ServiceName.COURSE_SERVICE,
                UUID.randomUUID(), null);

        return questionDataMapper.questionCreatedEventToCreateQuestionResponse(questionCreatedEvent, "Qtype Code Question created successfully");
    }

    public QueryQtypeCodeQuestionResponse queryQtypeCodeQuestionById(UUID qtypeCodeQuestionId) {
        return qtypeCodeQuestionQueryHelper.queryQtypeCodeQuestionById(qtypeCodeQuestionId);
    }

    public List<QueryQtypeCodeQuestionResponse> queryAllQtypeCodeQuestion() {
        return qtypeCodeQuestionQueryHelper.queryAllQtypeCodeQuestions();
    }

    @Transactional(readOnly = true)
    public QueryAllAdminQtypeCodeQuestionsResponse queryAllQtypeCodeQuestionsForAdmin
            (QueryAllAdminCodeQuestionCommand queryAllAdminCodeQuestionCommand) {
        Page<QtypeCodeQuestion> qtypeCodeQuestions = qtypeCodeQuestionQueryHelper
                .queryAllQtypeCodeQuestionsForAdmin(
                        queryAllAdminCodeQuestionCommand.getSearch(),
                        queryAllAdminCodeQuestionCommand.getDifficulty(),
                        queryAllAdminCodeQuestionCommand.getIsPublic(),
                        queryAllAdminCodeQuestionCommand.getPageNum(),
                        queryAllAdminCodeQuestionCommand.getPageSize(),
                        queryAllAdminCodeQuestionCommand.getEmail());

        log.info("Returning all code questions for admin");

        return qtypeCodeQuestionDataMapper
                .qtypeCodeQuestionsToQueryAllAdminQtypeCodeQuestionsResponse(qtypeCodeQuestions);
    }

    @Transactional(readOnly = true)
    public QueryAllAdminQtypeCodeQuestionsResponse queryAllQtypeCodeQuestionsForOrgAdmin
            (QueryAllAdminCodeQuestionCommand queryAllAdminCodeQuestionCommand) {
        Page<QtypeCodeQuestion> qtypeCodeQuestions = qtypeCodeQuestionQueryHelper
                .queryAllQtypeCodeQuestionsForOrgAdmin(
                        queryAllAdminCodeQuestionCommand.getOrgId(),
                        queryAllAdminCodeQuestionCommand.getSearch(),
                        queryAllAdminCodeQuestionCommand.getDifficulty(),
                        queryAllAdminCodeQuestionCommand.getIsPublic(),
                        queryAllAdminCodeQuestionCommand.getPageNum(),
                        queryAllAdminCodeQuestionCommand.getPageSize(),
                        queryAllAdminCodeQuestionCommand.getEmail());

        log.info("Returning all code questions for org admin");

        return qtypeCodeQuestionDataMapper
                .qtypeCodeQuestionsToQueryAllAdminQtypeCodeQuestionsResponse(qtypeCodeQuestions);
    }

    @Transactional(readOnly = true)
    public QueryAllAdminQtypeCodeQuestionsResponse queryAllAllowedToImportQtypeCodeQuestionsForOrgAdmin
            (QueryAllAdminCodeQuestionCommand queryAllAdminCodeQuestionCommand) {
        Page<QtypeCodeQuestion> qtypeCodeQuestions = qtypeCodeQuestionQueryHelper
                .queryAllAllowedToImportQtypeCodeQuestionsForOrgAdmin(
                        queryAllAdminCodeQuestionCommand.getOrgId(),
                        queryAllAdminCodeQuestionCommand.getSearch(),
                        queryAllAdminCodeQuestionCommand.getDifficulty(),
                        queryAllAdminCodeQuestionCommand.getIsPublic(),
                        queryAllAdminCodeQuestionCommand.getPageNum(),
                        queryAllAdminCodeQuestionCommand.getPageSize(),
                        queryAllAdminCodeQuestionCommand.getEmail());

        log.info("Returning all allowed to import code questions for org admin");

        return qtypeCodeQuestionDataMapper
                .qtypeCodeQuestionsToQueryAllAdminQtypeCodeQuestionsResponse(qtypeCodeQuestions);
    }

    public UpdateQuestionResponse updateQtypeCodeQuestion(UpdateQtypeCodeQuestionCommand updateQtypeCodeQuestionCommand) {
        QuestionUpdatedEvent questionUpdatedEvent = qtypeCodeQuestionUpdateHelper.updateQtypeCodeQuestionInDb(updateQtypeCodeQuestionCommand);

        questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionUpdatedEventToQuestionEventPayload(questionUpdatedEvent),
                questionUpdatedEvent.getQuestion().getCopyState(),
                OutboxStatus.STARTED,
                questionSagaHelper.questionStatusToSagaStatus(questionUpdatedEvent.getQuestion().getCopyState()),
                ServiceName.COURSE_SERVICE,
                UUID.randomUUID(),
                questionDataMapper.questionUpdatedEventToQuestionEventPreviousPayload(questionUpdatedEvent));

        return questionDataMapper.questionUpdatedEventToUpdateQuestionRespond(questionUpdatedEvent, "Qtype Code Question updated successfully");
    }
}
