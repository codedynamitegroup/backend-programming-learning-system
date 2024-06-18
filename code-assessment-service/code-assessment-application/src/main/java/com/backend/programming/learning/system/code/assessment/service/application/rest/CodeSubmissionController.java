package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.application.handler.utils.JwtUtils;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.CreateCodeSubmissionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_submission.ExecuteCodeWithTestCaseCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_submission.*;
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

    //add outbox
    @PostMapping
    public ResponseEntity<CreateCodeSubmissionResponse> createCodeSubmission
            (@RequestHeader(value = "Access-Token") String accessToken,
             @RequestBody CreateCodeSubmissionCommand createCodeSubmissionCommand){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);
        createCodeSubmissionCommand.setEmail(email);
        CreateCodeSubmissionResponse response =
                codeSubmissionApplicationService.createCodeSubmission(createCodeSubmissionCommand);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
    @PostMapping("/execute")
    public ResponseEntity<String> executeCodeWithTestCase(
            @RequestBody ExecuteCodeWithTestCaseCommand command
    ){
        String response =
                codeSubmissionApplicationService.executeCodeWithTestCase(command);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<GetCodeSubmissionReponse> getCodeSubmissionsByUserId
            (@RequestHeader(value = "Access-Token") String accessToken,
             @RequestParam UUID codeQuestionId,
             @RequestParam(required = false) UUID contestId,
             @RequestParam(required = false) UUID cerCourseId,
             @RequestParam(defaultValue = "0") Integer pageNo,
             @RequestParam(defaultValue = "5") Integer pageSize){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        GetCodeSubmissionsByUserIdCommand command = GetCodeSubmissionsByUserIdCommand.builder()
                .codeQuestionId(codeQuestionId)
                .email(email)
                .pageNum(pageNo)
                .pageSize(pageSize)
                .contestId(contestId)
                .cerCourseId(cerCourseId)
                .build();
        GetCodeSubmissionReponse response =
                codeSubmissionApplicationService.getCodeSubmissionsByUserId(command);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/admin-code-submission")
    public ResponseEntity<GetCodeSubmissionReponse> getAdminCodeSubmissions
            (@RequestHeader(value = "Access-Token") String accessToken,
             @RequestParam(required = false) UUID contestId,
             @RequestParam(required = false) UUID cerCourseId,
             @RequestParam(defaultValue = "0") Integer pageNo,
             @RequestParam(defaultValue = "5") Integer pageSize){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        AdminCodeSubmissionQuery command = AdminCodeSubmissionQuery.builder()
                .email(email)
                .pageNum(pageNo)
                .pageSize(pageSize)
                .contestId(contestId)
                .cerCourseId(cerCourseId)
                .build();
        GetCodeSubmissionReponse response =
                codeSubmissionApplicationService.getAdminCodeSubmissions(command);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{code-submission-id}")
    public ResponseEntity<GetCodeSubmissionResponseItem> getCodeSubmissionsById
            (@RequestHeader(value = "Access-Token") String accessToken,
             @PathVariable("code-submission-id") UUID codeSubmissionId){
        String email = JwtUtils.getEmailFromJwtStringWithoutCheckExp(accessToken);

        GetDetailCodeSubmissionsByIdCommand command = GetDetailCodeSubmissionsByIdCommand.builder()
                .codeSubmissionId(codeSubmissionId)
                .email(email)
                .build();
        @Valid GetCodeSubmissionResponseItem response =
                codeSubmissionApplicationService.getCodeSubmissionsById(command);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{code-submission-id}/memory-time-ranking")
    public ResponseEntity<GetMemoryAndTimeRankingResponse> getMemoryAndTimeRanking(@PathVariable("code-submission-id") UUID codeSubmissionId){
        GetMemoryAndTimeRankingCommand command = GetMemoryAndTimeRankingCommand.builder()
                .codeSubmissionId(codeSubmissionId)
                .build();

        GetMemoryAndTimeRankingResponse response = codeSubmissionApplicationService.getMemoryAndRunTimeRanking(command);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/test-case-token")
    public void updateCodeSubmissionTestCase(@RequestBody UpdateCodeSubmissionTestCaseCommand command){
        codeSubmissionApplicationService.handleTestCaseResult(command);
    }

    //submit sample or use judge api directly
}
