package com.backend.programming.learning.system.code.assessment.service.domain.exception.constraint_exception;

public class UniqueConstraintException extends RuntimeException{
    public UniqueConstraintException(String message) {
        super(message);
    }

    public UniqueConstraintException(String message, Throwable cause) {
        super(message, cause);
    }

}
