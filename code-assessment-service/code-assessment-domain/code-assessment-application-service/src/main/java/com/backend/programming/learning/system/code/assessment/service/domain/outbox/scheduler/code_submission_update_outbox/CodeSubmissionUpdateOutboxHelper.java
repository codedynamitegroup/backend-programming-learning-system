package com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_submission_update_outbox;

import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdatePayload;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdatePayload;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion.CodeSubmissionUpdateOutboxRepository;
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
public class CodeSubmissionUpdateOutboxHelper {
    final ObjectMapper objectMapper;
    final CodeSubmissionUpdateOutboxRepository codeSubmissionUpdateOutboxRepository;

    public CodeSubmissionUpdateOutboxHelper(ObjectMapper objectMapper, CodeSubmissionUpdateOutboxRepository codeSubmissionUpdateOutboxRepository) {
        this.objectMapper = objectMapper;
        this.codeSubmissionUpdateOutboxRepository = codeSubmissionUpdateOutboxRepository;
    }

    @Transactional(readOnly = true)
    public Optional<List<CodeSubmissionUpdateOutboxMessage>> getCodeSubmissionUpdateOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus outboxStatus, SagaStatus ...sagaStatus) {
        return codeSubmissionUpdateOutboxRepository.findByTypeAndOutboxStatusAndSagaStatus(
                SagaConstants.CODE_SUBMISSION_UPDATE_SAGA_NAME, outboxStatus, sagaStatus
        );
    }

    @Transactional
    public void save(CodeSubmissionUpdateOutboxMessage outboxMessage) {
        CodeSubmissionUpdateOutboxMessage response =
                codeSubmissionUpdateOutboxRepository.save(outboxMessage);

        if(response == null){
            log.error("Could not save CodeSubmissionUpdateOutboxMessage with outbox id: {}", outboxMessage.getId());
            throw new CodeAssessmentDomainException("Could not save CodeSubmissionUpdateOutboxMessage with outbox id: {}"+ outboxMessage.getId());
        }
        log.info("Save CodeSubmissionUpdateOutboxMessage with outbox id: {}", outboxMessage.getId());
    }

    @Transactional
    public void deleteCodeSubmissionUpdateOutboxMessageByOutboxStatusAndSagaStatus(OutboxStatus outboxStatus, SagaStatus ...sagaStatus) {
        codeSubmissionUpdateOutboxRepository
                .deleteByTypeAndOutboxStatusAndSagaStatus(SagaConstants.CODE_SUBMISSION_UPDATE_SAGA_NAME, outboxStatus, sagaStatus);
    }

    @Transactional
    public void saveCodeSubmissionUpdateOutboxMessage(
            CodeSubmissionUpdatePayload payload,
            CopyState copyState,
            SagaStatus sagaStatus,
            OutboxStatus outboxStatus,
            UUID sagaId) {
        save(CodeSubmissionUpdateOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .type(SagaConstants.CODE_SUBMISSION_UPDATE_SAGA_NAME)
                .payload(createPayload(payload))
                .copyState(copyState)
                .sagaStatus(sagaStatus)
                .outboxStatus(outboxStatus)
                .build());
    }

    private String createPayload(CodeSubmissionUpdatePayload payload) {
        try {
            return objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            log.error("Could not create CodeSubmissionUpdatePayload object for id: {}",
                    payload.getId(), e);
            throw new CodeAssessmentDomainException("Could not create CodeSubmissionUpdatePayload object for id: " +
                    payload.getId(), e);
        }
    }
}
