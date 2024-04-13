package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Question;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionCreatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.CodeAssessmentDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.CodeQuestionDataMaper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class CodeQuestionCreateCommandHandler {
    private final CodeAssessmentDomainService codeAssessmentDomainService;
    private final CodeQuestionRepository codeQuestionRepository;
    private final CodeQuestionDataMaper codeQuestionDataMaper;
    private final QuestionRepository questionRepository;

    public CodeQuestionCreateCommandHandler(CodeAssessmentDomainService codeAssessmentDomainService, CodeQuestionRepository codeQuestionRepository, CodeQuestionDataMaper codeQuestionDataMaper, QuestionRepository questionRepository) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.codeQuestionRepository = codeQuestionRepository;
        this.codeQuestionDataMaper = codeQuestionDataMaper;
        this.questionRepository = questionRepository;
    }

    @Transactional
    public CreateCodeQuestionResponse createCodeQuestion(CreateCodeQuestionCommand command){
        checkQuestion(command.getQuestionId());
        CodeQuestion codeQuestion = codeQuestionDataMaper.createCodeQuestionCommandToCodeQuestion(command);
        CodeQuestionCreatedEvent codeQuestionCreatedEvent
                = codeAssessmentDomainService.validateAndInitiateCodeQuestion(codeQuestion);
        CodeQuestion codeQuestionResult = saveCodeQuestion(codeQuestion);
        log.info("Code question is created, id: {}", codeQuestionResult.getId().getValue());
        return codeQuestionDataMaper.codeQuestionToCreateCodeQuestionReponse(codeQuestionResult);

    }

    private void checkQuestion(UUID questionId) {
        Optional<Question> question = questionRepository.findQuestionInformation(questionId);
        if(question.isEmpty()){
            log.warn("Could not find question id: {}", questionId);
            throw new CodeAssessmentDomainException("Could not find question id: " + questionId);
        }
    }
    private CodeQuestion saveCodeQuestion(CodeQuestion codeQuestion){
        CodeQuestion codeQuestionResult = codeQuestionRepository.save(codeQuestion);
        if(codeQuestionResult == null){
            log.error("Can not save code question id");
            throw new CodeAssessmentDomainException("Can not save code question");
        }
        log.info("Code question is save with id: {}", codeQuestionResult.getId().getValue());
        return codeQuestionResult;
    }
}
