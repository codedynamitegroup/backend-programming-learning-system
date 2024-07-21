package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.question;

import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.question.QuestionOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.outbox.QuestionOutboxRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
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
    public Optional<List<QuestionOutboxMessage>> getQuestionOutboxMessagesByOutboxStatus(OutboxStatus outboxStatus) {
        return questionOutboxRepository.findByTypeAndOutboxStatus(QUESTION_SAGA_NAME, outboxStatus);
    }

    @Transactional(readOnly = true)
    public Optional<QuestionOutboxMessage> getQuestionOutboxMessageBySagaId(UUID sagaId) {
        return questionOutboxRepository.findByTypeAndSagaId(QUESTION_SAGA_NAME, sagaId);
    }

    @Transactional
    public void saveQuestionOutboxMessage(QuestionOutboxMessage questionOutboxMessage) {
        QuestionOutboxMessage response = questionOutboxRepository.save(questionOutboxMessage);

        if (response == null) {
            log.error("Failed to save question outbox message: {}", questionOutboxMessage);
            throw new CourseDomainException("Failed to save question outbox message with id: " + questionOutboxMessage.getId());
        }

        log.info("Question outbox message with id: {} has been saved to outbox", questionOutboxMessage.getId());
    }

    @Transactional
    public void saveNewQuestionOutboxMessage(QuestionEventPayload questionEventPayload, CopyState copyState, OutboxStatus outboxStatus, UUID sagaId) {
        questionOutboxRepository.save(QuestionOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .createdAt(questionEventPayload.getCreatedAt())
                .type(QUESTION_SAGA_NAME)
                .payload(createPayload(questionEventPayload))
                .outboxStatus(outboxStatus)
                .copyState(copyState)
                .version(1)
                .build());
    }

    @Transactional
    public void deleteByOutboxStatus(OutboxStatus outboxStatus) {
        questionOutboxRepository.deleteByTypeAndOutboxStatus(QUESTION_SAGA_NAME, outboxStatus);
    }

    private String createPayload(QuestionEventPayload questionEventPayload) {
        try {
            return objectMapper.writeValueAsString(questionEventPayload);
        } catch (Exception e) {
            log.error("Failed to create payload object for question event: {}", questionEventPayload, e);
            throw new CourseDomainException("Failed to create payload object for question event: " + questionEventPayload, e);
        }
    }
}