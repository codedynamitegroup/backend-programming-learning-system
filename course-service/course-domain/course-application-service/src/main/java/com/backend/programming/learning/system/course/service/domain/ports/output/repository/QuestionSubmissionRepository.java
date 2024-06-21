package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.MarkQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuestionSubmissionRepository {
    QuestionSubmission save(QuestionSubmission questionSubmission);

    void saveAll(List<QuestionSubmission> questionSubmissions);

    List<QuestionSubmission> findAllByExamSubmissionId(UUID submissionId);

    void markQuestion(List<MarkQuestionSubmissionCommand> markQuestionSubmissionCommandList);

    List<QuestionSubmission> findByExamIdAndUserId(ExamId examId, UserId userId);

    Optional<QuestionSubmission> findByExamSubmissionIdAndQuestionId(UUID examSubmissionId, UUID questionId);
}
