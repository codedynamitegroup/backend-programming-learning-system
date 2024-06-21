package com.backend.programming.learning.system.course.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class ExamSubmissionNotFoundException extends DomainException {
    public ExamSubmissionNotFoundException(String message) {
        super(message);
    }

    public ExamSubmissionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
