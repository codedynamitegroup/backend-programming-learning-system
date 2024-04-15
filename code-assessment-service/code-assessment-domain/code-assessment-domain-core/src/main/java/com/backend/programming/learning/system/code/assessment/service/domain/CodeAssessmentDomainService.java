package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Question;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionCreatedEvent;

public interface CodeAssessmentDomainService {
    CodeQuestionCreatedEvent validateAndInitiateCodeQuestion(CodeQuestion codeQuestion);
}
