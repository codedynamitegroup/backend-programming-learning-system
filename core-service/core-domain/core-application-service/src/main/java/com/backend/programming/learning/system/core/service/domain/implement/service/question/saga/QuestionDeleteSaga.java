package com.backend.programming.learning.system.core.service.domain.implement.service.question.saga;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.DomainConstants;
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
public class QuestionDeleteSaga implements SagaStep<QuestionResponse> {
    private final QuestionRepository questionRepository;
    private final QuestionSagaHelper questionSagaHelper;
    private final QuestionOutboxHelper questionOutboxHelper;
    private final CoreDomainService coreDomainService;

    public QuestionDeleteSaga(
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
    @Transactional
    public void process(QuestionResponse questionResponse) {
        Optional<QuestionOutboxMessage> questionOutboxMessage = questionOutboxHelper
                .getQuestionOutboxMessageBySagaIdAndSagaStatusAndCopyState(UUID.fromString(questionResponse.getSagaId()),
                        CopyState.DELETING,
                        SagaStatus.STARTED);

        if (questionOutboxMessage.isEmpty()) {
            log.info("Processing question delete saga for question id: {}", questionResponse.getId());
            return;
        }

        log.info("Processing question delete saga for question id: {}", questionResponse.getId());

        QuestionOutboxMessage outboxMessage = questionOutboxMessage.get();
        SagaStatus sagaStatus = questionSagaHelper.questionStatusToSagaStatus(CopyState.DELETED);

        questionOutboxHelper.saveQuestionOutboxMessage(updateOutboxMessage(outboxMessage, CopyState.DELETED, sagaStatus));

        log.info("Question delete saga for question id: {} has been processed", questionResponse.getId());
    }

    // TODO: Implement rollback method for question delete saga
    @Override
    public void rollback(QuestionResponse questionResponse) {
        log.info("Rollback question delete saga for question id: {}", questionResponse.getId());
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
