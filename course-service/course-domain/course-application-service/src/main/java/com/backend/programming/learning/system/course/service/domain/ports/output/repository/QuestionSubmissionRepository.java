package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.MarkQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;

import java.util.List;
import java.util.UUID;

public interface QuestionSubmissionRepository {
    QuestionSubmission save(QuestionSubmission questionSubmission);

    void saveAll(List<QuestionSubmission> questionSubmissions);

    List<QuestionSubmission> findAllByExamSubmissionId(UUID submissionId);

    void markQuestion(List<MarkQuestionSubmissionCommand> markQuestionSubmissionCommandList);
}
