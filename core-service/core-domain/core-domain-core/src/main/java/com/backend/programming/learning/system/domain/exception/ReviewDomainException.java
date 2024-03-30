package com.backend.programming.learning.system.domain.exception;

public class ReviewDomainException extends DomainException {
    public ReviewDomainException(String message) {
        super(message);
    }

    public ReviewDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
