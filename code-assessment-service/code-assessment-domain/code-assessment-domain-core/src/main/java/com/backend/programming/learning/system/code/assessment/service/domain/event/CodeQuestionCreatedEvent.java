package com.backend.programming.learning.system.code.assessment.service.domain.event;


import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;

import java.time.ZonedDateTime;

public class CodeQuestionCreatedEvent extends CodeQuestionEvent {

    public CodeQuestionCreatedEvent(CodeQuestion codeQuestion, ZonedDateTime createdAt) {
        super(codeQuestion, createdAt);
    }
}
