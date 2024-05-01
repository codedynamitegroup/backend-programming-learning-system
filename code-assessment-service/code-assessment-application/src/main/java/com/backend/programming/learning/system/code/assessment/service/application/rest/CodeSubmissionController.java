package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeSubmissionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/code-assessment/code-submission",
        produces = "application/vnd.api.v1+json")
@Slf4j
public class CodeSubmissionController {
    private final CodeSubmissionApplicationService codeSubmissionApplicationService;

    public CodeSubmissionController(CodeSubmissionApplicationService codeSubmissionApplicationService) {
        this.codeSubmissionApplicationService = codeSubmissionApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateCodeSubmissionResponse> createTestCases
            (@RequestBody CreateCodeSubmissionCommand createCodeSubmissionCommand){
        log.info("adsd {}", createCodeSubmissionCommand.getCodeQuestionId());
        CreateCodeSubmissionResponse response =
                codeSubmissionApplicationService.createCodeSubmission(createCodeSubmissionCommand);
        return ResponseEntity.ok(response);
    }

}
