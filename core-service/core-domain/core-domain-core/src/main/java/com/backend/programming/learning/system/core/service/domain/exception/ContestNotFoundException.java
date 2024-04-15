package com.backend.programming.learning.system.core.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class ContestNotFoundException extends DomainException {
    public ContestNotFoundException(String message) {
        super(message);
    }

    public ContestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
