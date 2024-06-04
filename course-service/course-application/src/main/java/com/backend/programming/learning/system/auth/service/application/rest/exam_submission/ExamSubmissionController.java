package com.backend.programming.learning.system.auth.service.application.rest.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.CreateExamSubmissionStartCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.exam_submission.ExamSubmissionApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:07 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/exam/question", produces = "application/vnd.api.v1+json")
public class ExamSubmissionController {
    private final ExamSubmissionApplicationService examSubmissionApplicationService;
    @PostMapping("/submit")
    @Operation(summary = "Submit exam.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateExamSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateExamSubmissionResponse> submitExam(
            @RequestBody CreateExamSubmissionCommand createExamSubmissionCommand) {
        log.info("Submit exam");
        CreateExamSubmissionResponse response = examSubmissionApplicationService.submitExam(createExamSubmissionCommand);
        log.info("Exam submitted: {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/start-exam")
    @Operation(summary = "Start exam.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateExamSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateExamSubmissionResponse> startExam(
            @RequestBody CreateExamSubmissionStartCommand createExamSubmissionStartCommand) {
        log.info("Start exam");
        CreateExamSubmissionResponse response = examSubmissionApplicationService.startExam(createExamSubmissionStartCommand);
        log.info("Exam started: {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/end-exam")
    @Operation(summary = "End exam.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateExamSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateExamSubmissionResponse> endExam(
            @RequestBody CreateExamSubmissionStartCommand createExamSubmissionStartCommand) {
        log.info("End exam");
        CreateExamSubmissionResponse response = examSubmissionApplicationService.endExam(createExamSubmissionStartCommand);
        log.info("Exam ended: {}", response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
