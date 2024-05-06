package com.backend.programming.learning.system.core.service.domain.outbox.scheduler.code_questions;

import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionDeleteEventPayload;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdatePayload;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CodeQuestionsUpdateOutboxRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import com.backend.programming.learning.system.saga.code_assessment.SagaConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CodeQuestionsUpdateOutboxHelper {
    private final CodeQuestionsUpdateOutboxRepository codeQuestionsUpdateOutboxRepository;
    private final ObjectMapper objectMapper;

    public CodeQuestionsUpdateOutboxHelper(
            CodeQuestionsUpdateOutboxRepository codeQuestionsUpdateOutboxRepository,
            ObjectMapper objectMapper) {
        this.codeQuestionsUpdateOutboxRepository = codeQuestionsUpdateOutboxRepository;
        this.objectMapper = objectMapper;
    }
    @Transactional(readOnly = true)
    public Optional<CodeQuestionsUpdateOutboxMessage>
    getCompletedCodeQuestionsUpdateOutboxMessageBySagaIdAndCopyState(
            UUID sagaId,
            CopyState copyState) {
        return codeQuestionsUpdateOutboxRepository
                .findByTypeAndSagaIdAndCopyStateAndOutboxStatus(
                        SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME,
                        sagaId,
                        copyState,
                        OutboxStatus.COMPLETED);
    }

    @Transactional(readOnly = true)
    public Optional<List<CodeQuestionsUpdateOutboxMessage>>
            getCodeQuestionsUpdateOutboxMessageByOutboxStatus(
                    OutboxStatus outboxStatus){
        return codeQuestionsUpdateOutboxRepository.findByTypeAndOutboxStatus(
                SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME, outboxStatus
        );
    }

    @Transactional
    public void save(CodeQuestionsUpdateOutboxMessage outboxMessage){
        CodeQuestionsUpdateOutboxMessage response =
        codeQuestionsUpdateOutboxRepository.save(outboxMessage);

        if(response == null){
            log.error("Could not save CodeQuestionsUpdateOutboxMessage with outbox id: {}", outboxMessage.getId());
            throw new CoreDomainException("Could not save CodeQuestionsUpdateOutboxMessage with outbox id: {}"+ outboxMessage.getId());
        }
        log.info("Save CodeQuestionsUpdateOutboxMessage with outbox id: {}", outboxMessage.getId());
    }
    @Transactional
    public void deleteCodeQuestionsUpdateOutboxMessageByOutboxStatus(OutboxStatus outboxStatus) {
        codeQuestionsUpdateOutboxRepository
                .deleteByTypeAndOutboxStatus(SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME, outboxStatus);
    }

    @Transactional
    public void saveCodeQuestionsUpdateOutboxMessage(CodeQuestionsUpdatePayload payload,
                                                     CopyState copyState,
                                                     OutboxStatus outboxStatus,
                                                     UUID sagaId){
        save(CodeQuestionsUpdateOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .processedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .type(SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME)
                .payload(createPayload(payload))
                .copyState(copyState)
                .outboxStatus(outboxStatus)
                .build());

    }

    @Transactional
    public void saveCodeQuestionsDeleteOutboxMessage(
            CodeQuestionDeleteEventPayload payload,
            CopyState copyState,
            OutboxStatus outboxStatus,
            UUID sagaId){
        save(CodeQuestionsUpdateOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .processedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .type(SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME)
                .payload(createPayload(payload))
                .copyState(copyState)
                .outboxStatus(outboxStatus)
                .build());

    }

    private String createPayload(CodeQuestionsUpdatePayload payload) {
        try {
            return objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            log.error("Could not create CodeQuestionsUpdatePayload object for id: {}",
                    payload.getId(), e);
            throw new CoreDomainException("Could not create CodeQuestionsUpdatePayload object for id: " +
                    payload.getId(), e);
        }
    }

    private String createPayload(CodeQuestionDeleteEventPayload payload) {
        try {
            return objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            log.error("Could not create CodeQuestionsUpdatePayload object for id: {}",
                    payload.getId(), e);
            throw new CoreDomainException("Could not create CodeQuestionsUpdatePayload object for id: " +
                    payload.getId(), e);
        }
    }

    @Transactional
    public void updateOutboxMessage(CodeQuestionsUpdateOutboxMessage outboxMessage, OutboxStatus outboxStatus) {
        outboxMessage.setOutboxStatus(outboxStatus);
        save(outboxMessage);
        log.info("code question outbox table status is updated as: {}", outboxStatus.name());
    }

}
