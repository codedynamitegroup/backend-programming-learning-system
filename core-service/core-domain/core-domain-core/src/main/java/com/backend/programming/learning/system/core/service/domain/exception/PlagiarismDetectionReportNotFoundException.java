package com.backend.programming.learning.system.core.service.domain.exception;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class PlagiarismDetectionReportNotFoundException extends DomainException {
    public PlagiarismDetectionReportNotFoundException(String message) {
        super(message);
    }

    public PlagiarismDetectionReportNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
