package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmissionFile;

import java.util.Optional;
import java.util.UUID;

public interface QuestionSubmissionFileRepository {
    Optional<QuestionSubmissionFile> getQuestionSubmissionFile(UUID questionSubmissionFileId);
}
