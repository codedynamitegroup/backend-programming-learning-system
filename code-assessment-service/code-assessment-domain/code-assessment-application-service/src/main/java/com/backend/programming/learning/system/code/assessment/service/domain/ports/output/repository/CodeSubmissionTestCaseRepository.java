package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeSubmissionTestCase;

import java.util.List;

public interface CodeSubmissionTestCaseRepository {
    List<CodeSubmissionTestCase> save(List<CodeSubmissionTestCase> cstcList);
}
