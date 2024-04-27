package com.backend.programming.learning.system.core.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class ContestUserNotFoundException extends DomainException {
    public ContestUserNotFoundException(String message) {
        super(message);
    }

    public ContestUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
