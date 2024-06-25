package com.backend.programming.learning.system.course.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class ExamSubmissionConflictException extends DomainException {
    public ExamSubmissionConflictException(String message) {
        super(message);
    }

    public ExamSubmissionConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}
