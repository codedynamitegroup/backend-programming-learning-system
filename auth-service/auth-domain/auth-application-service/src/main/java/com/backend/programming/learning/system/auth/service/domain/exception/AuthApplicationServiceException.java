package com.backend.programming.learning.system.auth.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class AuthApplicationServiceException extends DomainException {

    public AuthApplicationServiceException(String message) {
        super(message);
    }

    public AuthApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
