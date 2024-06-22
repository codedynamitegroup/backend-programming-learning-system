package com.backend.programming.learning.system.course.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class QuestionSubmissionNotFoundException extends DomainException {
    public QuestionSubmissionNotFoundException(String message) {
        super(message);
    }

    public QuestionSubmissionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
