package com.backend.programming.learning.system.core.service.domain.outbox.scheduler.question;

import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionEventPreviousPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionOutboxRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.backend.programming.learning.system.saga.question.SagaConstants.QUESTION_SAGA_NAME;

@Component
@Slf4j
public class QuestionOutboxHelper {
    private final QuestionOutboxRepository questionOutboxRepository;
    private final ObjectMapper objectMapper;

    public QuestionOutboxHelper(
            QuestionOutboxRepository questionOutboxRepository,
            ObjectMapper objectMapper) {
        this.questionOutboxRepository = questionOutboxRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional(readOnly = true)
    public Optional<List<QuestionOutboxMessage>> getQuestionOutboxMessagesByOutboxStatusAndSagaStatus(OutboxStatus outboxStatus,
                                                                                                      SagaStatus... sagaStatus) {
        return questionOutboxRepository.findByTypeAndOutboxStatusAndSagaStatus(QUESTION_SAGA_NAME, outboxStatus, sagaStatus);
    }

    @Transactional(readOnly = true)
    public Optional<QuestionOutboxMessage> getQuestionOutboxMessageBySagaIdAndSagaStatusAndCopyState(UUID sagaId,
                                                                                                     CopyState copyState,
                                                                                                     SagaStatus... sagaStatus) {
        return questionOutboxRepository.findByTypeAndSagaIdAndCopyStateAndSagaStatus(QUESTION_SAGA_NAME, sagaId, copyState, sagaStatus);
    }

    @Transactional
    public void saveQuestionOutboxMessage(QuestionOutboxMessage questionOutboxMessage) {
        QuestionOutboxMessage response = questionOutboxRepository.save(questionOutboxMessage);

        if (response == null) {
            log.error("Failed to save question outbox message: {}", questionOutboxMessage);
            throw new CoreDomainException("Failed to save question outbox message with id: " + questionOutboxMessage.getId());
        }

        log.info("Question outbox message with id: {} has been saved to outbox", questionOutboxMessage.getId());
    }

    @Transactional
    public void saveNewQuestionOutboxMessage(QuestionEventPayload questionEventPayload,
                                             CopyState copyState,
                                             OutboxStatus outboxStatus,
                                             SagaStatus sagaStatus,
                                             ServiceName serviceName,
                                             UUID sagaId, QuestionEventPreviousPayload previousPayload) {
        questionOutboxRepository.save(QuestionOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .createdAt(questionEventPayload.getCreatedAt())
                .type(QUESTION_SAGA_NAME)
                .payload(createPayload(questionEventPayload))
                .previousPayload(previousPayload != null ? createPayload(previousPayload) : null)
                .sagaStatus(sagaStatus)
                .outboxStatus(outboxStatus)
                .copyState(copyState)
                .serviceName(serviceName)
                .version(1)
                .build());
    }

    @Transactional
    public void deleteByOutboxStatusAndSagaStatus(OutboxStatus outboxStatus, SagaStatus... sagaStatus) {
        questionOutboxRepository.deleteByTypeAndOutboxStatusAndSagaStatus(QUESTION_SAGA_NAME,
                outboxStatus,
                sagaStatus);
    }

    private String createPayload(QuestionEventPayload questionEventPayload) {
        try {
            return objectMapper.writeValueAsString(questionEventPayload);
        } catch (Exception e) {
            log.error("Failed to create payload object for question event: {}", questionEventPayload, e);
            throw new CoreDomainException("Failed to create payload object for question event: " + questionEventPayload, e);
        }
    }

    private String createPayload(QuestionEventPreviousPayload questionEventPreviousPayload) {
        try {
            return objectMapper.writeValueAsString(questionEventPreviousPayload);
        } catch (Exception e) {
            log.error("Failed to create payload object for question event: {}", questionEventPreviousPayload, e);
            throw new CoreDomainException("Failed to create payload object for question event: " + questionEventPreviousPayload, e);
        }
    }
}