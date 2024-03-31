package com.backend.programming.learning.system.domain.exception;

public class CoreDomainException extends DomainException {
    public CoreDomainException(String message) {
        super(message);
    }

    public CoreDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
