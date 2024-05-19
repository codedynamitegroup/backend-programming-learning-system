package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;

import java.util.List;
import java.util.UUID;

public interface CodeSubmissionRepository {
    CodeSubmission saveCodeSubmission(CodeSubmission codeSubmission);
    List<CodeSubmission> findAllCodeSubmissionsByUserIdAndQuestionId(UUID userId, UUID questionId);
}
