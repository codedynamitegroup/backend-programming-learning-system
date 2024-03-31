package com.backend.programming.learning.system.exception;


import com.backend.programming.learning.system.domain.exception.DomainException;

public class AuthNotFoundException extends DomainException {

    public AuthNotFoundException(String message) {
        super(message);
    }

    public AuthNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
