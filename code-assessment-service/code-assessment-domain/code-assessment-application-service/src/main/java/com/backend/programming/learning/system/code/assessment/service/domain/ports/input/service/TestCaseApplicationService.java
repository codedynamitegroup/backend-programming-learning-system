package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.test_case.PatchDeleteTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.test_case.PatchDeleteTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.testcase.GetTestCasesByQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.testcase.GetTestCasesByQuestionIdResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase.UpdateTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase.UpdateTestCaseResponse;

import javax.validation.Valid;

public interface TestCaseApplicationService {
    CreateTestCasesResponse createTestCases(@Valid CreateTestCasesCommand command);

    PatchDeleteTestCasesResponse patchDeleteTestCases(@Valid PatchDeleteTestCasesCommand command);

    UpdateTestCaseResponse updateTestCase(@Valid UpdateTestCaseCommand command);

    GetTestCasesByQuestionIdResponse getTestCasesByCodeQuestionId(@Valid GetTestCasesByQuestionIdCommand command);
}
