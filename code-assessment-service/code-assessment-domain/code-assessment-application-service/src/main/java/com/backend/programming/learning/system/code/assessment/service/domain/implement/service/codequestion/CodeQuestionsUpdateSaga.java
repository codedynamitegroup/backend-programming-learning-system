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
            case CREATED ->
            {
                completeCodeQuestionsUpdateOrCreate(codeQuestionsUpdateResponse, CopyState.CREATED);
                //update outbox
                codeQuestionsUpdateOutboxHelper.save(updateOutboxMessage(codeQuestionsUpdateOutboxMessage,
                        CopyState.CREATED, SagaStatus.SUCCEEDED
                ));
            }
            case UPDATED ->
            {
                completeCodeQuestionsUpdateOrCreate(codeQuestionsUpdateResponse, CopyState.UPDATED);
                codeQuestionsUpdateOutboxHelper.save(updateOutboxMessage(codeQuestionsUpdateOutboxMessage,
                        CopyState.UPDATED, SagaStatus.SUCCEEDED
                ));
            }

            case DELETED ->
            {
                //actual delete
                codeQuestionRepository.deleteCodeQuestionById(codeQuestionsUpdateResponse.getId());
                codeQuestionsUpdateOutboxHelper.save(updateOutboxMessage(codeQuestionsUpdateOutboxMessage,
                        CopyState.DELETED, SagaStatus.SUCCEEDED));
            }

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

    private void completeCodeQuestionsUpdateOrCreate(CodeQuestionsUpdateResponse response, CopyState state){
        CodeQuestion codeQuestion = findCodeQuestion(response.getCodeQuestionId());
        log.info("Completing save or change code question with id to core-service: {} with state {}", response.getId(), response.getState().toString());
        codeQuestion.setCopyState(state);//domain service should do this job but it's quite short so I set it directly
        codeQuestionRepository.save(codeQuestion);

    }
    private void quitCodeQuestionsUpdateOrCreate(CodeQuestionsUpdateResponse response, CopyState state){
        CodeQuestion codeQuestion = findCodeQuestion(response.getCodeQuestionId());
        //codeQuestion attributes should be reassign by the value of the response since there is no update case in core service, we don't have to do that
        log.info("Quitting save or change code question with id to core-service: {} with state {}", response.getId(), response.getState().toString());
        codeAssessmentDomainService.cancelCopyCodeQuestions(codeQuestion, state, response.getFailureMessages());
        codeQuestionRepository.save(codeQuestion);
    }

    @Override
    @Transactional
    public void rollback(CodeQuestionsUpdateResponse codeQuestionsUpdateResponse) {
        //không có trờng hợp saga này ở trạng thái processing
        Optional<CodeQuestionsUpdateOutboxMessage> codeQuestionsUpdateOutboxMessageResponse =
                codeQuestionsUpdateOutboxHelper.getCodeQuestionsUpdateOutboxMessageBySagaIdAndSagaStatus(
                        codeQuestionsUpdateResponse.getSagaId(),
                        SagaStatus.STARTED);

        if (codeQuestionsUpdateOutboxMessageResponse.isEmpty()) {
            log.info("An outbox message with saga id: {} is already created!", codeQuestionsUpdateResponse.getSagaId());
            return;
        }
        CodeQuestionsUpdateOutboxMessage codeQuestionsUpdateOutboxMessage = codeQuestionsUpdateOutboxMessageResponse.get();

        //đổi state về failed, saga về COMPENSATED, outbox về FAILED
        switch (codeQuestionsUpdateResponse.getState()){
            case CREATE_FAILED ->
            {
                quitCodeQuestionsUpdateOrCreate(codeQuestionsUpdateResponse, CopyState.CREATE_FAILED);
                //update outbox
                codeQuestionsUpdateOutboxHelper.save(updateOutboxMessage(codeQuestionsUpdateOutboxMessage,
                        CopyState.CREATE_FAILED, SagaStatus.COMPENSATED
                ));
            }
            case UPDATE_FAILED ->
            {
                //codeQuestionsUpdateResponse sẽ chứa data cũ để lưu lại trong tác vụ này
                quitCodeQuestionsUpdateOrCreate(codeQuestionsUpdateResponse, CopyState.UPDATE_FAILED);
                codeQuestionsUpdateOutboxHelper.save(updateOutboxMessage(codeQuestionsUpdateOutboxMessage,
                        CopyState.UPDATE_FAILED, SagaStatus.COMPENSATED
                ));
            }

            case DELETE_FAILED ->
            {
                //delete record khi success, nên khi fail, ta k cần phải rollback thật sự mà chỉ cần chỉnh copy state
                quitCodeQuestionsUpdateOrCreate(codeQuestionsUpdateResponse, CopyState.DELETE_FAILED);
                codeQuestionsUpdateOutboxHelper.save(updateOutboxMessage(codeQuestionsUpdateOutboxMessage,
                        CopyState.DELETE_FAILED, SagaStatus.COMPENSATED));
            }

        }

        log.info("Code question with id {} is rollbacked", codeQuestionsUpdateResponse.getId());
    }
}
