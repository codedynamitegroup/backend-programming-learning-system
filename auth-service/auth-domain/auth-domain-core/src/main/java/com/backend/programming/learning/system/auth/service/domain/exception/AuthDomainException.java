package com.backend.programming.learning.system.auth.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class AuthDomainException extends DomainException {

    public AuthDomainException(String message) {
        super(message);
    }

    public AuthDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
