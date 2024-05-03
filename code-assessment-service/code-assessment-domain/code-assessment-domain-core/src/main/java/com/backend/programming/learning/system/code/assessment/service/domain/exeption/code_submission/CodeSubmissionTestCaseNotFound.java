package com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_submission;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CodeSubmissionTestCaseNotFound extends DomainException {
    public CodeSubmissionTestCaseNotFound(String message) {
        super(message);
    }

    public CodeSubmissionTestCaseNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}