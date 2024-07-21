package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmissionTestCase;
import com.backend.programming.learning.system.domain.valueobject.CodeSubmissionId;

import java.util.List;
import java.util.Optional;

public interface CodeSubmissionTestCaseRepository {
    List<CodeSubmissionTestCase> save(List<CodeSubmissionTestCase> cstcList);

    CodeSubmissionTestCase save(CodeSubmissionTestCase codeSubmissionTestCase);

    Optional<CodeSubmissionTestCase> findByToken(String token);

    List<CodeSubmissionTestCase> findByCodeSubmissionId(CodeSubmissionId id);

    Optional<CodeSubmissionTestCase> findFirstNonAcceptedByCodeSubmissionId(CodeSubmissionId id);

    Integer countNonAcceptedByCodeSubmissionId(CodeSubmissionId codeSubmissionId);
}
