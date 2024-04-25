package com.backend.programming.learning.system.core.service.domain.exception.question;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class QtypeCodeQuestionDomainException extends DomainException {
    public QtypeCodeQuestionDomainException(String message) {
        super(message);
    }

    public QtypeCodeQuestionDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}