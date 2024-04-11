package com.backend.programming.learning.system.core.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CoreDomainException extends DomainException {
    public CoreDomainException(String message) {
        super(message);
    }

    public CoreDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
