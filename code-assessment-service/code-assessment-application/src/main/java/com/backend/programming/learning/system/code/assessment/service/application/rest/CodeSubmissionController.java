package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.test_case.CreateTestCasesResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetCodeSubmissionResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetCodeSubmissionsByUserIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetDetailCodeSubmissionsByIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeSubmissionApplicationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<CreateCodeSubmissionResponse> createCodeSubmission
            (@RequestBody CreateCodeSubmissionCommand createCodeSubmissionCommand){
        CreateCodeSubmissionResponse response =
                codeSubmissionApplicationService.createCodeSubmission(createCodeSubmissionCommand);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
    @GetMapping
    public ResponseEntity<List<GetCodeSubmissionResponseItem>> getCodeSubmissionsByUserId
            (@RequestParam UUID userId,
             @RequestParam UUID codeQuestionId){

        GetCodeSubmissionsByUserIdCommand command = GetCodeSubmissionsByUserIdCommand.builder()
                .codeQuestionId(codeQuestionId)
                .userId(userId)
                .build();
        List<@Valid GetCodeSubmissionResponseItem> response =
                codeSubmissionApplicationService.getCodeSubmissionsByUserId(command);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/detail")
    public ResponseEntity<GetCodeSubmissionResponseItem> getCodeSubmissionsById
            (@RequestParam UUID userId,
             @RequestParam UUID codeSubmissionId){

        GetDetailCodeSubmissionsByIdCommand command = GetDetailCodeSubmissionsByIdCommand.builder()
                .codeSubmissionId(codeSubmissionId)
                .userId(userId)
                .build();
        @Valid GetCodeSubmissionResponseItem response =
                codeSubmissionApplicationService.getCodeSubmissionsById(command);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/test-case-token")
    public void updateCodeSubmissionTestCase(@RequestBody UpdateCodeSubmissionTestCaseCommand command){
        codeSubmissionApplicationService.handleTestCaseResult(command);

    }
}
