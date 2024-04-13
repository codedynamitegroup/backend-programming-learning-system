package com.backend.programming.learning.system.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class ExamNotFoundException extends DomainException {
    public ExamNotFoundException(String message) {
        super(message);
    }

    public ExamNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
