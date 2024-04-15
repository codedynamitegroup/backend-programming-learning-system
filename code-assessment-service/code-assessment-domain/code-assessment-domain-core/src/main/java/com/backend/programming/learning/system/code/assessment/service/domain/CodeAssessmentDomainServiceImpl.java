package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Question;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class CodeAssessmentDomainServiceImpl implements CodeAssessmentDomainService{
    @Override
    public CodeQuestionCreatedEvent 
    validateAndInitiateCodeQuestion(CodeQuestion codeQuestion) {

        codeQuestion.validateCodeQuestion();
        codeQuestion.initializeCodeQuestion();
        log.info("Code question with id: {} is initiated", codeQuestion.getId().getValue());
        return new CodeQuestionCreatedEvent(codeQuestion, ZonedDateTime.now(ZoneId.of("UTC")));
    }

}