package com.backend.programming.learning.system.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class SubmissionAssignmentOnlineTextNotFoundException extends DomainException {
    public SubmissionAssignmentOnlineTextNotFoundException(String message) {
        super(message);
    }

    public SubmissionAssignmentOnlineTextNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
