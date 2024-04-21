package com.backend.programming.learning.system.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class UserNotFoundException extends DomainException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}