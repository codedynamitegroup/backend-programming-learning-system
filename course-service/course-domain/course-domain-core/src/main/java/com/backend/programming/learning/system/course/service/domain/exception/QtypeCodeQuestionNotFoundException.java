package com.backend.programming.learning.system.course.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class QtypeCodeQuestionNotFoundException extends DomainException {
    public QtypeCodeQuestionNotFoundException(String message) {
        super(message);
    }

    public QtypeCodeQuestionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
