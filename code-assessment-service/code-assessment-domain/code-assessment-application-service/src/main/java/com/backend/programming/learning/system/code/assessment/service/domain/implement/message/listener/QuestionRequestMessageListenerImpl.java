package com.backend.programming.learning.system.code.assessment.service.domain.implement.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.QuestionRequest;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.QuestionRequestMessageListener;

public class QuestionRequestMessageListenerImpl implements QuestionRequestMessageListener {
    private final CodeAssessmentDomainService codeAssessmentDomainService;

    public QuestionRequestMessageListenerImpl(CodeAssessmentDomainService codeAssessmentDomainService) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
    }


    @Override
    public void deleteQuestion(QuestionRequest questionRequest) {

    }
}
