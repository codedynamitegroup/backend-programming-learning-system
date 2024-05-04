package com.backend.programming.learning.system.core.service.domain.implement.service.question.saga;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.saga.SagaStatus;
import com.backend.programming.learning.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class QuestionCreateSaga implements SagaStep<QuestionResponse> {
    private final QuestionRepository questionRepository;
    private final QuestionSagaHelper questionSagaHelper;
    private final QuestionOutboxHelper questionOutboxHelper;
    private final CoreDomainService coreDomainService;

    public QuestionCreateSaga(QuestionRepository questionRepository,
                              QuestionSagaHelper questionSagaHelper,
                              QuestionOutboxHelper questionOutboxHelper, CoreDomainService coreDomainService) {
        this.questionRepository = questionRepository;
        this.questionSagaHelper = questionSagaHelper;
        this.questionOutboxHelper = questionOutboxHelper;
        this.coreDomainService = coreDomainService;
    }

    @Override
    @Transactional
    public void process(QuestionResponse questionResponse) {
        Optional<QuestionOutboxMessage> questionOutboxMessage = questionOutboxHelper
                .getQuestionOutboxMessageBySagaIdAndSagaStatusAndCopyState(UUID.fromString(questionResponse.getSagaId()),
                        CopyState.CREATING,
                        SagaStatus.STARTED);

        if (questionOutboxMessage.isEmpty()) {
            log.error("An outbox message with saga id: {} have already been processed", questionResponse.getId());
            return;
        }

        log.info("Processing question create saga for question id: {}", questionResponse.getId());

        QuestionOutboxMessage outboxMessage = questionOutboxMessage.get();
        Question question = questionSagaHelper.findQuestionById(UUID.fromString(questionResponse.getId()));

        // set new state and save
        question.setCopyState(questionResponse.getCopyState());
        questionRepository.saveQuestion(question);

        SagaStatus sagaStatus = questionSagaHelper.questionStatusToSagaStatus(question.getCopyState());

        questionOutboxHelper.saveQuestionOutboxMessage(updateOutboxMessage(outboxMessage,
                        question.getCopyState(),
                        sagaStatus));

        log.info("A question with question id: {} have been processed", questionResponse.getId());
    }

    // TODO: Implement rollback for question create saga
    @Override
    @Transactional
    public void rollback(QuestionResponse questionResponse) {
        Optional<QuestionOutboxMessage> questionOutboxMessage =questionOutboxHelper
                .getQuestionOutboxMessageBySagaIdAndSagaStatusAndCopyState(UUID.fromString(questionResponse.getSagaId()),
                        CopyState.CREATE_FAILED,
                        getCurrentSagaStatus(questionResponse.getCopyState()));

        if (questionOutboxMessage.isEmpty()) {
            log.error("An outbox message with saga id: {} have already been rolled back", questionResponse.getId());
            return;
        }

        log.info("Rolling back question create saga for question id: {}", questionResponse.getId());

        QuestionOutboxMessage outboxMessage = questionOutboxMessage.get();
        Question question = questionSagaHelper.findQuestionById(UUID.fromString(questionResponse.getId()));

        // set new state and save
        question.setCopyState(CopyState.CREATE_ROLLBACKING);
        questionRepository.saveQuestion(question);

        SagaStatus sagaStatus = questionSagaHelper.questionStatusToSagaStatus(question.getCopyState());

        if(question.getCopyState().equals(CopyState.CREATE_FAILED)) {
            questionOutboxHelper.saveQuestionOutboxMessage(updateOutboxMessage(outboxMessage,
                    question.getCopyState(),
                    sagaStatus));
        }

        log.info("An question with question id: {} have been rolled back", questionResponse.getId());
    }

    private void rollbackQuestionCreate(QuestionResponse questionResponse) {
        log.info("Rolling back, deleting question with question id: {}", questionResponse.getId());

        Question question = findQuestion(questionResponse.getId());
        questionRepository.deleteQuestion(question.getId().getValue());
    }

    private QuestionOutboxMessage updateOutboxMessage(QuestionOutboxMessage outboxMessage,
                                                      CopyState copyState,
                                                      SagaStatus sagaStatus) {
        outboxMessage.setProcessedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.ASIA_HCM)));
        outboxMessage.setCopyState(copyState);
        outboxMessage.setSagaStatus(sagaStatus);

        return outboxMessage;
    }

    private SagaStatus[] getCurrentSagaStatus(CopyState copyState) {
        return switch (copyState) {
            case CREATING -> new SagaStatus[]{SagaStatus.STARTED};
            case CREATE_PROPAGATING -> new SagaStatus[]{SagaStatus.PROCESSING};
            case CREATE_ROLLBACKING -> new SagaStatus[]{SagaStatus.COMPENSATING};
            case CREATED -> new SagaStatus[]{SagaStatus.SUCCEEDED};
            case CREATE_FAILED -> new SagaStatus[]{SagaStatus.COMPENSATED};
            default -> new SagaStatus[]{};
        };
    }

    private Question findQuestion(String questionId) {
        Optional<Question> question = questionRepository.findQuestion(UUID.fromString(questionId));

        if (question.isEmpty()) {
            log.warn("Question not found with id: {}", questionId);
            throw new QuestionNotFoundException("Question not found with id: " + questionId);
        }

        return question.get();
    }
}
