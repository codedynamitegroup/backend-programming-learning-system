package com.backend.programming.learning.system.code.assessment.service.domain.exeption.shared_solution.comment.vote;

import com.backend.programming.learning.system.domain.exception.DomainException;

public class CommentVoteNotFoundException  extends DomainException {
    public CommentVoteNotFoundException(String message) {
        super(message);
    }
    public CommentVoteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}