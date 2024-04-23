package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.QuestionSubmission;

public interface QuestionSubmissionRepository {
    QuestionSubmission save(QuestionSubmission questionSubmission);
}
