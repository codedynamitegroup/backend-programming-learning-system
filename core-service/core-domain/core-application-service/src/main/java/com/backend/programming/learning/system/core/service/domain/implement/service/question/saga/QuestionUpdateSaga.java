package com.backend.programming.learning.system.core.service.domain.implement.service.question.saga;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.saga.SagaStatus;
import com.backend.programming.learning.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class QuestionUpdateSaga implements SagaStep<QuestionResponse> {
    private final QuestionRepository questionRepository;
    private final QuestionSagaHelper questionSagaHelper;
    private final QuestionOutboxHelper questionOutboxHelper;
    private final CoreDomainService coreDomainService;

    public QuestionUpdateSaga(
            QuestionRepository questionRepository,
            QuestionSagaHelper questionSagaHelper,
            QuestionOutboxHelper questionOutboxHelper,
            CoreDomainService coreDomainService) {
        this.questionRepository = questionRepository;
        this.questionSagaHelper = questionSagaHelper;
        this.questionOutboxHelper = questionOutboxHelper;
        this.coreDomainService = coreDomainService;
    }

    @Override
    public void process(QuestionResponse questionResponse) {
        Optional<QuestionOutboxMessage> questionOutboxMessage = questionOutboxHelper
                .getQuestionOutboxMessageBySagaIdAndSagaStatusAndCopyState(UUID.fromString(questionResponse.getSagaId()),
                        CopyState.UPDATING,
                        SagaStatus.STARTED);

        if (questionOutboxMessage.isEmpty()) {
            log.error("An outbox message with saga id: {} have already been processed", questionResponse.getId());
            return;
        }

        QuestionOutboxMessage outboxMessage = questionOutboxMessage.get();
        Question question = questionSagaHelper.findQuestionById(UUID.fromString(questionResponse.getId()));

        question.setCopyState(questionResponse.getCopyState());
        questionRepository.saveQuestion(question);

        SagaStatus sagaStatus = questionSagaHelper.questionStatusToSagaStatus(question.getCopyState());

        questionOutboxHelper.saveQuestionOutboxMessage(updateOutboxMessage(outboxMessage,
                question.getCopyState(),
                sagaStatus));
        log.info("Processing question update saga for question id: {}", questionResponse.getId());
    }

    @Override
    public void rollback(QuestionResponse questionResponse) {
        log.info("Rollback question update saga for question id: {}", questionResponse.getId());
    }

    private QuestionOutboxMessage updateOutboxMessage(QuestionOutboxMessage outboxMessage,
                                                      CopyState copyState,
                                                      SagaStatus sagaStatus) {
        outboxMessage.setProcessedAt(ZonedDateTime.now(ZoneId.of(DomainConstants.UTC)));
        outboxMessage.setCopyState(copyState);
        outboxMessage.setSagaStatus(sagaStatus);

        return outboxMessage;
    }
}
