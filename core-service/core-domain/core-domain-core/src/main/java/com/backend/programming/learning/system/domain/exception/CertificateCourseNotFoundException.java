package com.backend.programming.learning.system.domain.exception;

public class CertificateCourseNotFoundException extends DomainException {
    public CertificateCourseNotFoundException(String message) {
        super(message);
    }

    public CertificateCourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
