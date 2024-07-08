package com.backend.programming.learning.system.course.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class QuestionSubmissionFileNotFoundException extends DomainException {
    public QuestionSubmissionFileNotFoundException(String message) {
        super(message);
    }

    public QuestionSubmissionFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
