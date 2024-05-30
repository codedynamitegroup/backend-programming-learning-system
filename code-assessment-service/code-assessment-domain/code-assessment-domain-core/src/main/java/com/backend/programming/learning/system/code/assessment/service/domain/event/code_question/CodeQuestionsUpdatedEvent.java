package com.backend.programming.learning.system.code.assessment.service.domain.event.code_question;


import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;

import java.time.ZonedDateTime;

public class CodeQuestionsUpdatedEvent extends CodeQuestionsEvent {

    public CodeQuestionsUpdatedEvent(CodeQuestion codeQuestion, ZonedDateTime createdAt) {
        super(codeQuestion, createdAt);
    }
}
