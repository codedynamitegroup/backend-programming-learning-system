package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetCodeSubmissionsByUserIdCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.GetCodeSubmissionsByUserIdResponseItem;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.code_submission.UpdateCodeSubmissionTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeSubmissionApplicationService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/code-assessment/code-submission",
        produces = "application/vnd.api.v1+json")
@Slf4j
@Validated
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
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<GetCodeSubmissionsByUserIdResponseItem>> getCodeSubmissionsByUserId
            (@RequestBody GetCodeSubmissionsByUserIdCommand command){
        List<@Valid GetCodeSubmissionsByUserIdResponseItem> response =
                codeSubmissionApplicationService.getCodeSubmissionsByUserId(command);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/test-case-token")
    public void updateCodeSubmissionTestCase(@RequestBody UpdateCodeSubmissionTestCaseCommand command){
        codeSubmissionApplicationService.handleTestCaseResult(command);

    }

}
