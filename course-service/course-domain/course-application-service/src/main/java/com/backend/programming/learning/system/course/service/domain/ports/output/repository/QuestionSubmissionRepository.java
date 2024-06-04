package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;

import java.util.List;

public interface QuestionSubmissionRepository {
    QuestionSubmission save(QuestionSubmission questionSubmission);

    void saveAll(List<QuestionSubmission> questionSubmissions);
}
