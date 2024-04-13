package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.Chapter;
import com.backend.programming.learning.system.core.service.domain.entity.CodeSubmission;

public interface CodeSubmissionRepository {
    CodeSubmission saveCodeSubmission(CodeSubmission codeSubmission);
}
