package com.backend.programming.learning.system.auth.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class UnAuthorizedServiceException extends DomainException {

    public UnAuthorizedServiceException(String message) {
        super(message);
    }

    public UnAuthorizedServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
