package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
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

}
