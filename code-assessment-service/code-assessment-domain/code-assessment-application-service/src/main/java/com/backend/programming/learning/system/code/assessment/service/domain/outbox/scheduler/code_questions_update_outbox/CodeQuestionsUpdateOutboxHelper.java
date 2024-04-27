package com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_questions_update_outbox;

import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdatePayload;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionsUpdateOutboxRepository;
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
    public Optional<List<CodeQuestionsUpdateOutboxMessage>>
            getCodeQuestionsUpdateOutboxMessageByOutboxStatusAndSagaStatus(
                    OutboxStatus outboxStatus, SagaStatus... sagaStatus){
        return codeQuestionsUpdateOutboxRepository.findByTypeAndOutboxStatusAndSagaStatus(
                SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME, outboxStatus, sagaStatus
        );
    }

    @Transactional(readOnly = true)
    public Optional<CodeQuestionsUpdateOutboxMessage>
            getCodeQuestionsUpdateOutboxMessageBySagaIdAndSagaStatus(UUID sagaId, SagaStatus ...sagaStatus){
        return codeQuestionsUpdateOutboxRepository.findByTypeAndSagaIdAndSagaStatus(
                SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME,
                sagaId, sagaStatus
        );
    }
    @Transactional
    public void save(CodeQuestionsUpdateOutboxMessage outboxMessage){
        CodeQuestionsUpdateOutboxMessage response =
        codeQuestionsUpdateOutboxRepository.save(outboxMessage);

        if(response == null){
            log.error("Could not save CodeQuestionsUpdateOutboxMessage with outbox id: {}", outboxMessage.getId());
            throw new CodeAssessmentDomainException("Could not save CodeQuestionsUpdateOutboxMessage with outbox id: {}"+ outboxMessage.getId());
        }
        log.info("Save CodeQuestionsUpdateOutboxMessage with outbox id: {}", outboxMessage.getId());
    }
    @Transactional
    public void deleteCodeQuestionsUpdateOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus outboxStatus,
                                                                      SagaStatus... sagaStatus) {
        codeQuestionsUpdateOutboxRepository
                .deleteByTypeAndOutboxStatusAndSagaStatus(SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME, outboxStatus, sagaStatus);
    }

    @Transactional
    public void saveCodeQuestionsUpdateOutboxMessage(CodeQuestionsUpdatePayload payload,
                                                     CopyState copyState,
                                                     SagaStatus sagaStatus,
                                                     OutboxStatus outboxStatus,
                                                     UUID sagaId){
        save(CodeQuestionsUpdateOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .type(SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME)
                .payload(createPayload(payload))
                .copyState(copyState)
                .sagaStatus(sagaStatus)
                .outboxStatus(outboxStatus)
                .build());

    }

    private String createPayload(CodeQuestionsUpdatePayload payload) {
        try {
            return objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            log.error("Could not create CodeQuestionsUpdatePayload object for id: {}",
                    payload.getId(), e);
            throw new CodeAssessmentDomainException("Could not create CodeQuestionsUpdatePayload object for id: " +
                    payload.getId(), e);
        }
    }

}
