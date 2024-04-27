package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesResponse;

import javax.validation.Valid;

public interface TestCaseApplicationService {
    CreateTestCasesResponse createTestCases(@Valid CreateTestCasesCommand command);
}
