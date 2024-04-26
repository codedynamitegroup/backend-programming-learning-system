package com.backend.programming.learning.system.course.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CourseDomainException extends DomainException {
    public CourseDomainException(String message) {
        super(message);
    }

    public CourseDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
