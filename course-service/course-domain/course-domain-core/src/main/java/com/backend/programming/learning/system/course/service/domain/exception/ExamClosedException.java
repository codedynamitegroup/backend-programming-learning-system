package com.backend.programming.learning.system.course.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class ExamClosedException extends DomainException {
    public ExamClosedException(String message) {
        super(message);
    }

    public ExamClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}
