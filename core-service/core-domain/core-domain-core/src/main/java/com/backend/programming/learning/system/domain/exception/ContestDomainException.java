package com.backend.programming.learning.system.domain.exception;

public class ContestDomainException extends DomainException {
    public ContestDomainException(String message) {
        super(message);
    }

    public ContestDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
