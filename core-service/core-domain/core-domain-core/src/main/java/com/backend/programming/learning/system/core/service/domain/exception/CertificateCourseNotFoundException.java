package com.backend.programming.learning.system.core.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CertificateCourseNotFoundException extends DomainException {
    public CertificateCourseNotFoundException(String message) {
        super(message);
    }

    public CertificateCourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
