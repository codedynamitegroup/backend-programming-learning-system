package com.backend.programming.learning.system.code.assessment.service.domain.exeption.codequestion;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CodeQuestionDomainException extends DomainException {
    public CodeQuestionDomainException(String message) {
        super(message);
    }

    public CodeQuestionDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
