package com.backend.programming.learning.system.domain.exception.question;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class QuestionNotFoundException extends DomainException {
    public QuestionNotFoundException(String message) {
        super(message);
    }

    public QuestionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
