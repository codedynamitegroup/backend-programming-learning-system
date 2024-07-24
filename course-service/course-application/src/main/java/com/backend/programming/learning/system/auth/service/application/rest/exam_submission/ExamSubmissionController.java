package com.backend.programming.learning.system.auth.service.application.rest.exam_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.*;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryAllStudentExamSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryAllStudentExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionOverviewResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission.QueryStudentExamSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.exam_submission.ExamSubmissionApplicationService;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamSubmissionId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:07 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/exam", produces = "application/vnd.api.v1+json")
public class ExamSubmissionController {
    private final ExamSubmissionApplicationService examSubmissionApplicationService;

    @GetMapping("/question/submit/{submissionId}")
    @Operation(summary = "Submit exam detail.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryExamSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryExamSubmissionResponse> submitExamDetail(
            @PathVariable UUID submissionId) {
        log.info("Submit exam detail");
        QueryExamSubmissionResponse response = examSubmissionApplicationService.submitExamDetail(submissionId);
        log.info("Exam detail submitted: {}", response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/question/submit")
    @Operation(summary = "Submit exam.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
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
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/question/start-exam")
    @Operation(summary = "Start exam.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
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

    @PatchMapping("/question/end-exam")
    @Operation(summary = "End exam.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateExamSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateExamSubmissionResponse> endExam(
            @RequestBody CreateExamSubmissionEndCommand createExamSubmissionStartCommand) {
        log.info("End exam");
        CreateExamSubmissionResponse response = examSubmissionApplicationService.endExam(createExamSubmissionStartCommand);
        log.info("Exam ended: {}", response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{examId}/student/submission")
    @Operation(summary = "Get student exam submission by exam id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllStudentExamSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllStudentExamSubmissionResponse> findByExamId(
            @PathVariable UUID examId,
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "pageNo", required = false, defaultValue = "0") Integer pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        log.info("Getting exam submission with exam id: {}", examId);
        QueryAllStudentExamSubmissionCommand queryAllStudentExamSubmissionCommand = QueryAllStudentExamSubmissionCommand.builder()
                .search(search)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build();
        QueryAllStudentExamSubmissionResponse response = examSubmissionApplicationService.findByExamId(
                new ExamId(examId),
                queryAllStudentExamSubmissionCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{examId}/student/submission/{submissionId}")
    @Operation(summary = "Get student exam submission by exam id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllStudentExamSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryStudentExamSubmissionResponse> findByExamIdAndSubmissionId(
            @PathVariable(name = "examId") UUID examId,
            @PathVariable(name = "submissionId") UUID submissionId) {
        log.info("Getting exam submission with exam id: {}", examId);
        QueryStudentExamSubmissionResponse response = examSubmissionApplicationService.findByExamIdAndSubmissionId(
                new ExamId(examId),
                new ExamSubmissionId(submissionId));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{examId}/submission")
    @Operation(summary = "Get exam submission by exam id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryExamSubmissionOverviewResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<List<QueryExamSubmissionOverviewResponse>> findByExamId(
            @PathVariable UUID examId,
            @RequestParam(value = "userId", required = true) UUID userId
    ) {
        log.info("Getting exam submission with exam id: {}", examId);
        List<QueryExamSubmissionOverviewResponse> response = examSubmissionApplicationService.findByExamIdAndUserId(examId, userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/latest-submission")
    @Operation(summary = "Get latest exam submission.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryExamSubmissionOverviewResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryExamSubmissionOverviewResponse> findLatestOnGoingSubmission(
            @RequestParam(value = "examId", required = true, defaultValue = "86600cfb-7b48-4e81-8e05-8fa29d49d7a6") UUID examId,
            @RequestParam(value = "userId", required = true, defaultValue = "9ba179ed-d26d-4828-a0f6-8836c2063992") UUID userId
    ) {
        log.info("Getting latest exam submission with exam id: {}", examId);
        QueryExamSubmissionOverviewResponse response = examSubmissionApplicationService.findLatestOnGoingSubmission(examId, userId);
        log.info("Latest exam submission: {}", response);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/grading/submission/{submissionId}")
    @Operation(summary = "Grading exam submission.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<Void> updateStatusGrade(
            @PathVariable UUID submissionId)
    {
        log.info("Grading exam submission");
        examSubmissionApplicationService.updateStatusGrade(new ExamSubmissionId(submissionId));
        return ResponseEntity.ok().build();
    }
}
