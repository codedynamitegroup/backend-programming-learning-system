package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;

public interface CodeSubmissionRepository {
    CodeSubmission save(CodeSubmission codeSubmission);
}
