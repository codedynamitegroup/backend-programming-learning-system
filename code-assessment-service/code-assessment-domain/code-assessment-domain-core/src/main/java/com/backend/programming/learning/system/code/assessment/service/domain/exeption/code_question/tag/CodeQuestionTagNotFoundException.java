package com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question.tag;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CodeQuestionTagNotFoundException extends DomainException {
    public CodeQuestionTagNotFoundException(String message) {
        super(message);
    }

    public CodeQuestionTagNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}