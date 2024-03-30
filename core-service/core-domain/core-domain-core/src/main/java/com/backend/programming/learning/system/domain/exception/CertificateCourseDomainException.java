package com.backend.programming.learning.system.domain.exception;

public class CertificateCourseDomainException extends DomainException {
    public CertificateCourseDomainException(String message) {
        super(message);
    }

    public CertificateCourseDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
