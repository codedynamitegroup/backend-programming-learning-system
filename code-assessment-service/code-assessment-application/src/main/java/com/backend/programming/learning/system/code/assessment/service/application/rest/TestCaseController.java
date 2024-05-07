package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.test_case.PatchDeleteTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.test_case.PatchDeleteTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.testcase.GetTestCasesByQuestionIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.testcase.GetTestCasesByQuestionIdResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase.UpdateTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.testcase.UpdateTestCaseResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.TestCaseApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<CreateTestCasesResponse> createTestCases
            (@RequestBody CreateTestCasesCommand createTestCasesCommand){
        log.info("Create test cases for code question id {}", createTestCasesCommand.getCodeQuestionId());
        CreateTestCasesResponse createCodeQuestionResponse =
                service.createTestCases(createTestCasesCommand);
        return ResponseEntity.ok(createCodeQuestionResponse);
    }
    @PutMapping
    public ResponseEntity<UpdateTestCaseResponse> updateTestCase
            (@RequestBody UpdateTestCaseCommand command){
        log.info("update test case with id {}", command.getId());
        UpdateTestCaseResponse response =
                service.updateTestCase(command);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<GetTestCasesByQuestionIdResponse> updateTestCase
            (@RequestParam(defaultValue = "0") Integer pageNo,
             @RequestParam(defaultValue = "10") Integer pageSize,
             @RequestParam(defaultValue = "false") Boolean fetchAll,
             @RequestParam UUID codeQuestionId){

        GetTestCasesByQuestionIdCommand command =
                GetTestCasesByQuestionIdCommand.builder()
                        .codeQuestionId(codeQuestionId)
                        .pageNum(pageNo)
                        .pageSize(pageSize)
                        .fetchAll(fetchAll)
                        .build();
        GetTestCasesByQuestionIdResponse response =
                service.getTestCasesByCodeQuestionId(command);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/patch-delete")
    public ResponseEntity deleteTestCases
            (@RequestBody List<UUID> testCaseIds){
        PatchDeleteTestCasesCommand command = PatchDeleteTestCasesCommand.builder().testCaseIds(testCaseIds).build();
        service.patchDeleteTestCases(command);
        return ResponseEntity.noContent().build();
    }
}
