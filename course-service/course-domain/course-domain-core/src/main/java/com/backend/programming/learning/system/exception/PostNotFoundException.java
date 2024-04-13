package com.backend.programming.learning.system.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class PostNotFoundException extends DomainException {
    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
