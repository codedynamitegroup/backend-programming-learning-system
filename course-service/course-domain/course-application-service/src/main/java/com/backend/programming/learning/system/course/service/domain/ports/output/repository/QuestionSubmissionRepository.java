package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;

public interface QuestionSubmissionRepository {
    QuestionSubmission save(QuestionSubmission questionSubmission);
}