package com.backend.programming.learning.system.course.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class SubmissionAssignmentNotFoundException extends DomainException {
    public SubmissionAssignmentNotFoundException(String message) {
        super(message);
    }

    public SubmissionAssignmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
