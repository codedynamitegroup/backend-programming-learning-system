package com.backend.programming.learning.system.auth.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class ForbiddenServiceException extends DomainException {

    public ForbiddenServiceException(String message) {
        super(message);
    }

    public ForbiddenServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
