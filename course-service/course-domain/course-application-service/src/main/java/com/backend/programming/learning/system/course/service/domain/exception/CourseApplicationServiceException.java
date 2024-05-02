package com.backend.programming.learning.system.course.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CourseApplicationServiceException extends DomainException {
    public CourseApplicationServiceException(String message) {
        super(message);
    }

    public CourseApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
