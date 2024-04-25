package com.backend.programming.learning.system.core.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CoreApplicationServiceException extends DomainException {

    public CoreApplicationServiceException(String message) {
        super(message);
    }

    public CoreApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
