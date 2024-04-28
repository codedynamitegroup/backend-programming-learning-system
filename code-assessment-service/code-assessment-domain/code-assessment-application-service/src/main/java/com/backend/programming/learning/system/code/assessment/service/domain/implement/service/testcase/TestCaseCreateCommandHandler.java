package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.testcase;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.test_case.PatchDeleteTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.test_case.PatchDeleteTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.test_case.TestCaseDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestCaseCreateCommandHandler {
    private final TestCaseHelper testCaseHelper;
    private final TestCaseDataMapper testCaseDataMapper;

    public TestCaseCreateCommandHandler(TestCaseHelper testCaseHelper, TestCaseDataMapper testCaseDataMapper) {
        this.testCaseHelper = testCaseHelper;
        this.testCaseDataMapper = testCaseDataMapper;
    }

    public CreateTestCasesResponse createTestCases(CreateTestCasesCommand createTestCasesCommand){
        return testCaseHelper.persistTestCases(createTestCasesCommand);
    }

    public PatchDeleteTestCasesResponse patchDeleteTestCases(PatchDeleteTestCasesCommand command) {
        return testCaseHelper.patchDeleteTestCases(command);
    }
}
