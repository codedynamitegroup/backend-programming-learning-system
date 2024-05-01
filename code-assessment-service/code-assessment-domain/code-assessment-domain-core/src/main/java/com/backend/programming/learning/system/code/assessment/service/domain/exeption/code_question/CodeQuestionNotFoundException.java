package com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CodeQuestionNotFoundException extends DomainException {
    public CodeQuestionNotFoundException(String message) {
        super(message);
    }

    public CodeQuestionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}