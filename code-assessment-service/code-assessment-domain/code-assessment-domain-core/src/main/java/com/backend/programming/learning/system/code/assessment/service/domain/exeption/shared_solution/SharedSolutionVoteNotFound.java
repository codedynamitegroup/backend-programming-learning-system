package com.backend.programming.learning.system.code.assessment.service.domain.exeption.shared_solution;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class SharedSolutionVoteNotFound extends DomainException {
    public SharedSolutionVoteNotFound(String message) {
        super(message);
    }

    public SharedSolutionVoteNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}