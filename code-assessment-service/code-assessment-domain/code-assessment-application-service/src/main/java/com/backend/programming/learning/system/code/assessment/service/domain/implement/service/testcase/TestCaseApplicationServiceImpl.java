package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.testcase;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.TestCaseApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
@Validated
@Slf4j
public class TestCaseApplicationServiceImpl implements TestCaseApplicationService {
    private final TestCaseCreateCommandHandler testCaseCreateCommandHandler;

    public TestCaseApplicationServiceImpl(TestCaseCreateCommandHandler testCaseCreateCommandHandler) {
        this.testCaseCreateCommandHandler = testCaseCreateCommandHandler;
    }

    @Override
    public CreateTestCasesResponse createTestCases(CreateTestCasesCommand command) {
        return testCaseCreateCommandHandler.createTestCases(command);
    }
}
