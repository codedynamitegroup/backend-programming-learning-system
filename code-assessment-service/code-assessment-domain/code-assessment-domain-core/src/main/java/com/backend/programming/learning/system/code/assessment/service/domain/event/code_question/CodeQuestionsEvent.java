package com.backend.programming.learning.system.code.assessment.service.domain.event.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;


public abstract class CodeQuestionsEvent implements DomainEvent<CodeQuestion> {
    private final CodeQuestion codeQuestion;
    private final ZonedDateTime createdAt;

    public CodeQuestionsEvent(CodeQuestion codeQuestion, ZonedDateTime createdAt) {
        this.codeQuestion = codeQuestion;
        this.createdAt = createdAt;
    }

    public CodeQuestion getCodeQuestion() {
        return codeQuestion;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
    public void fire(){}

}
