package com.backend.programming.learning.system.core.service.domain.implement.service.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionCloneCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionCloneResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.QuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllQuestionByCategoryIdCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllQuestionByCategoryIdResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryByIdsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryByIdsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.create.QuestionCreateHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.delete.QuestionDeleteHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QtypeCodeQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QtypeEssayQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QtypeMultichoiceQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QtypeShortanswerQuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.query.QuestionQueryHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.saga.QuestionSagaHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionEventPreviousPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.code_questions.CodeQuestionsUpdateOutboxHelper;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.backend.programming.learning.system.domain.valueobject.QuestionType.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class QuestionCommandHandler {
    private final QtypeEssayQuestionQueryHelper qtypeEssayQuestionQueryHelper;
    private final QtypeCodeQuestionQueryHelper qtypeCodeQuestionQueryHelper;
    private final QtypeMultichoiceQuestionQueryHelper qtypeMultichoiceQuestionQueryHelper;
    private final QtypeShortanswerQuestionQueryHelper qtypeShortanswerQuestionQueryHelper;

    private final QuestionQueryHelper questionQueryHelper;
    private final QuestionDeleteHelper questionDeleteHelper;
    private final QuestionCreateHelper questionCreateHelper;
    private final QuestionOutboxHelper questionOutboxHelper;
    private final QuestionSagaHelper questionSagaHelper;
    private final QuestionDataMapper questionDataMapper;
    private final CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper;

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

        if (questionDeletedEvent.getQuestion().getqtype() == QuestionType.CODE)
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

    public QueryAllQuestionByCategoryIdResponse queryAllQuestionByCategory(UUID categoryId, QueryAllQuestionByCategoryIdCommand queryAllQuestionByCategoryIdCommand) {
        Page<QuestionResponseEntity> questionResponseEntities = questionQueryHelper
                .queryAllQuestionByCategory(categoryId, queryAllQuestionByCategoryIdCommand);

        return QueryAllQuestionByCategoryIdResponse.builder()
                .questionResponses(questionResponseEntities.getContent())
                .currentPage(questionResponseEntities.getNumber())
                .totalItems(questionResponseEntities.getTotalElements())
                .totalPages(questionResponseEntities.getTotalPages())
                .build();
    }

    public QueryByIdsResponse queryAllQuestionDetail(QueryByIdsCommand ids) {
        List<Object> responses = new ArrayList<>();
        ids.questionCommands().forEach(questionCommand -> {
            switch (questionCommand.qtype()) {
                case "ESSAY":
                    responses.add(qtypeEssayQuestionQueryHelper.queryQuestionById(questionCommand.questionId()));
                    break;
                case "CODE":
                    responses.add(qtypeCodeQuestionQueryHelper.queryQuestionById(questionCommand.questionId()));
                    break;
                case "MULTIPLE_CHOICE":
                    responses.add(qtypeMultichoiceQuestionQueryHelper.queryQuestionById(questionCommand.questionId()));
                    break;
                case "TRUE_FALSE":
                    responses.add(qtypeMultichoiceQuestionQueryHelper.queryQuestionTrueFalseById(questionCommand.questionId()));
                    break;
                case "SHORT_ANSWER":
                    responses.add(qtypeShortanswerQuestionQueryHelper.queryQuestionById(questionCommand.questionId()));
                    break;
            }
        });
        return new QueryByIdsResponse(responses);
    }


    public CreateQuestionCloneResponse cloneQuestion(CreateQuestionCloneCommand createQuestionCloneCommand) {
        List<Question> questions = questionCreateHelper.cloneQuestion(createQuestionCloneCommand.questions());
       return questionDataMapper.questionListToCreateQuestionCloneResponse(questions);
    }
}
