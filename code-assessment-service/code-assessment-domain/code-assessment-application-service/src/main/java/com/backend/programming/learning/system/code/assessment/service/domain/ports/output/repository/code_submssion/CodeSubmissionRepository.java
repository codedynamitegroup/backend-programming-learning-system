package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmission;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;

import java.util.List;
import java.util.Optional;

public interface CodeSubmissionRepository {
    CodeSubmission save(CodeSubmission codeSubmission);
    void updateOneTestCase(CodeSubmissionId id);
    Optional<CodeSubmission> findById(CodeSubmissionId id);

    Optional<List<CodeSubmission>> findByUserIdAndQuestionId(UserId userId, CodeQuestionId codeQuestionId);

    Integer findNumberOfSubmissionUnderMySubmissionByMemory(CodeSubmissionId id);

    Integer findNumberOfSubmissionUnderMySubmissionByRunTime(CodeSubmissionId id);

    Integer countGradedTotalSubmission(CodeQuestionId id);
}
