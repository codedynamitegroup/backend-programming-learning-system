package com.backend.programming.learning.system.code.assessment.service.domain;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionsUpdatedEvent;

public interface CodeAssessmentDomainService {
    CodeQuestionsUpdatedEvent validateAndInitiateCodeQuestion(CodeQuestion codeQuestion);
}
