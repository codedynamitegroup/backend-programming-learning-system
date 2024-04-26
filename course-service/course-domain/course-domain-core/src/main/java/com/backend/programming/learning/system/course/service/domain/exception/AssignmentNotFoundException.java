package com.backend.programming.learning.system.course.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class AssignmentNotFoundException extends DomainException {
    public AssignmentNotFoundException(String message) {
        super(message);
    }

    public AssignmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
