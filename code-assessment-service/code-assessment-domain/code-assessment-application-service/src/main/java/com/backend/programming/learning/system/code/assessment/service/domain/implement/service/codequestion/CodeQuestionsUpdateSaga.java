package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.codequestion;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.CodeQuestionsUpdateResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.codequestion.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_questions_update_outbox.CodeQuestionsUpdateOutboxHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
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
public class CodeQuestionsUpdateSaga implements SagaStep<CodeQuestionsUpdateResponse> {
    private final CodeAssessmentDomainService codeAssessmentDomainService;
    private final CodeQuestionRepository codeQuestionRepository;
    private final CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper;

    public CodeQuestionsUpdateSaga(
            CodeAssessmentDomainService codeAssessmentDomainService,
            CodeQuestionRepository codeQuestionRepository,
            CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.codeQuestionRepository = codeQuestionRepository;
        this.codeQuestionsUpdateOutboxHelper = codeQuestionsUpdateOutboxHelper;
    }

    @Override
    @Transactional
    public void process(CodeQuestionsUpdateResponse codeQuestionsUpdateResponse) {
        Optional<CodeQuestionsUpdateOutboxMessage> codeQuestionsUpdateOutboxMessageResponse =
                codeQuestionsUpdateOutboxHelper.getCodeQuestionsUpdateOutboxMessageBySagaIdAndSagaStatus(
                        codeQuestionsUpdateResponse.getSagaId(),
                        SagaStatus.STARTED);

        if (codeQuestionsUpdateOutboxMessageResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already created!", codeQuestionsUpdateResponse.getSagaId());
            return;
        }

        CodeQuestionsUpdateOutboxMessage codeQuestionsUpdateOutboxMessage = codeQuestionsUpdateOutboxMessageResponse.get();

        //update code question status
        switch (codeQuestionsUpdateResponse.getState()){
            case CREATING ->
            {
                completeCodeQuestionUpdateOrCreate(codeQuestionsUpdateResponse, CopyState.CREATED);
                //update outbox
                codeQuestionsUpdateOutboxHelper.save(updateOutboxMessage(codeQuestionsUpdateOutboxMessage,
                        CopyState.CREATED, SagaStatus.SUCCEEDED
                ));
            }
            case UPDATING ->
            {
                completeCodeQuestionUpdateOrCreate(codeQuestionsUpdateResponse, CopyState.UPDATED);
                codeQuestionsUpdateOutboxHelper.save(updateOutboxMessage(codeQuestionsUpdateOutboxMessage,
                        CopyState.UPDATED, SagaStatus.SUCCEEDED
                ));
            }
            //deleting case is can not be set due to no object found
            case DELETING ->
                    codeQuestionsUpdateOutboxHelper.save(updateOutboxMessage(codeQuestionsUpdateOutboxMessage,
                    CopyState.DELETED, SagaStatus.SUCCEEDED));
        }

        log.info("Code question with id {} is updated", codeQuestionsUpdateResponse.getId());
    }
    private CodeQuestionsUpdateOutboxMessage
    updateOutboxMessage(CodeQuestionsUpdateOutboxMessage message,
                        CopyState copyState, SagaStatus sagaStatus){
        message.setCopyState(copyState);
        message.setSagaStatus(sagaStatus);
        message.setProcessedAt(ZonedDateTime.now(ZoneId.of("UTC")));
        return message;
    }
    private CodeQuestion findCodeQuestion(UUID id){
        Optional<CodeQuestion> response = codeQuestionRepository.findById(new CodeQuestionId(id));
        if (response.isEmpty()) {
            log.error("CodeQuestion with id: {} could not be found!", id);
            throw new CodeQuestionNotFoundException("CodeQuestion with id " + id + " could not be found!");
        }
        return response.get();
    }

    private void completeCodeQuestionUpdateOrCreate(CodeQuestionsUpdateResponse response, CopyState state){
        CodeQuestion codeQuestion = findCodeQuestion(response.getId());
        log.info("Completing save code question with id to core-service: {}", response.getId());
        codeQuestion.setCopyState(state);
        codeQuestionRepository.save(codeQuestion);

    }

    @Override
    public void rollback(CodeQuestionsUpdateResponse data) {

    }
}
