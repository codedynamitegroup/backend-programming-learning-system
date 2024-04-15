package com.backend.programming.learning.system.core.service.domain.exception.question;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class QtypeMultichoiceQuestionNotFoundException extends DomainException {
    public QtypeMultichoiceQuestionNotFoundException(String message) {
        super(message);
    }

    public QtypeMultichoiceQuestionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
