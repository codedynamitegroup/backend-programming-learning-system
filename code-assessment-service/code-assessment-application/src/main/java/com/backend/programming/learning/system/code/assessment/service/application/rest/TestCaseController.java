package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.TestCaseApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/code-assessment/test-case",
        produces = "application/vnd.api.v1+json")
@Slf4j
public class TestCaseController {
    private final TestCaseApplicationService service;

    public TestCaseController(TestCaseApplicationService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<CreateTestCasesResponse> creatTestCases
            (@RequestBody CreateTestCasesCommand createTestCasesCommand){
        log.info("Create test cases for code question id {}", createTestCasesCommand.getCodeQuestionId());
        CreateTestCasesResponse createCodeQuestionResponse =
                service.createTestCases(createTestCasesCommand);
        return ResponseEntity.ok(createCodeQuestionResponse);
    }
}
