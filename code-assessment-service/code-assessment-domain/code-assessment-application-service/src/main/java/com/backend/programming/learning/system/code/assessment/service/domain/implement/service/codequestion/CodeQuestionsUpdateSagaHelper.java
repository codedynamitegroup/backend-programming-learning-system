package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.codequestion;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.codequestion.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.UUID;

@Slf4j
public class CodeQuestionsUpdateSagaHelper {

    private final CodeQuestionRepository codeQuestionRepository;

    public CodeQuestionsUpdateSagaHelper(CodeQuestionRepository codeQuestionRepository) {
        this.codeQuestionRepository = codeQuestionRepository;
    }

    CodeQuestion findCodeQuestion(String id){
        Optional<CodeQuestion> orderResponse = codeQuestionRepository.findById(new CodeQuestionId(UUID.fromString(id)));
        if (orderResponse.isEmpty()) {
            log.error("Order with id: {} could not be found!", id);
            throw new CodeQuestionNotFoundException("Order with id " + id + " could not be found!");
        }
        return orderResponse.get();
    }

    SagaStatus copyStateToSagaStatus(CopyState copyState){
        return switch (copyState){
            case CREATING -> SagaStatus.STARTED;
            case UPDATING -> SagaStatus.STARTED;
            case DELETING -> SagaStatus.STARTED;//correct

            case CREATED -> SagaStatus.PROCESSING;
            case UPDATED -> SagaStatus.PROCESSING;
            case DELETED -> SagaStatus.PROCESSING;

            case CREATE_FAILED -> SagaStatus.COMPENSATED;
            case UPDATE_FAILED -> SagaStatus.COMPENSATED;
            case DELETE_FAILED -> SagaStatus.COMPENSATED;//correct
        };
    }
}
