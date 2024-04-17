package com.backend.programming.learning.system.code.assessment.service.domain.implement.codequestion;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.codequestion.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Question;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionCreatedEvent;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.codequestion.CodeQuestionDomainException;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.CodeQuestionDataMaper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CodeQuestionCreateHelper {
    private final CodeAssessmentDomainService codeAssessmentDomainService;


    private final CodeQuestionRepository codeQuestionRepository;
    private final QuestionRepository   questionRepository;
    private final CodeQuestionDataMaper codeQuestionDataMaper;

    public CodeQuestionCreateHelper
            (CodeAssessmentDomainService codeAssessmentDomainService, CodeQuestionRepository codeQuestionRepository, QuestionRepository questionRepository,
                                    CodeQuestionDataMaper codeQuestionDataMaper) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.codeQuestionRepository = codeQuestionRepository;
        this.questionRepository = questionRepository;
        this.codeQuestionDataMaper = codeQuestionDataMaper;
    }
    @Transactional
    public CodeQuestionCreatedEvent persistCodeQuestion(CreateCodeQuestionCommand command){
        checkQuestion(command.getQuestionId());
        CodeQuestion codeQuestion = codeQuestionDataMaper.createCodeQuestionCommandToCodeQuestion(command);
        CodeQuestionCreatedEvent codeQuestionCreatedEvent
                = codeAssessmentDomainService.validateAndInitiateCodeQuestion(codeQuestion);
        saveCodeQuestion(codeQuestion);
        log.info("Code question is created, id: {}", codeQuestionCreatedEvent.getCodeQuestion().getId().getValue());

        return codeQuestionCreatedEvent;
    }
    private void checkQuestion(UUID questionId) {
        Optional<Question> question = questionRepository.findQuestionInformation(questionId);
        if(question.isEmpty()){
            log.warn("Could not find question id: {}", questionId);
            throw new CodeQuestionDomainException("Could not find question id: " + questionId);
        }
    }
    private CodeQuestion saveCodeQuestion(CodeQuestion codeQuestion){
        CodeQuestion codeQuestionResult = codeQuestionRepository.save(codeQuestion);
        if(codeQuestionResult == null){
            log.error("Can not save code question id");
            throw new CodeQuestionDomainException("Can not save code question");
        }
        log.info("Code question is save with id: {}", codeQuestionResult.getId().getValue());
        return codeQuestionResult;
    }
}
