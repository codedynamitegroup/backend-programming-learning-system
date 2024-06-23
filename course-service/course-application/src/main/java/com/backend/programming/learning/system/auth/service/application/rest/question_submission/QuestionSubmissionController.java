package com.backend.programming.learning.system.auth.service.application.rest.question_submission;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.ExamQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.ExamQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.OneExamQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.OneExamQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.MarkQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_submission.QueryQuestionSubmissionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_submission.QueryQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.question_submission.QuestionSubmissionApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.question_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 1:26 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/question", produces = "application/vnd.api.v1+json")
public class QuestionSubmissionController {
    private final QuestionSubmissionApplicationService questionSubmissionApplicationService;
    @PostMapping("/submit")
    @Operation(summary = "Create question submission.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateQuestionSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateQuestionSubmissionResponse> submitQuestion(
            @RequestBody CreateQuestionSubmissionCommand createQuestionSubmissionCommand) {
        log.info("Submit question");
        CreateQuestionSubmissionResponse response = questionSubmissionApplicationService.submitQuestion(createQuestionSubmissionCommand);
        log.info("Question submitted: {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/mark")
    @Operation(summary = "Create question submission.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateQuestionSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<Void> mark(
            @RequestBody List<MarkQuestionSubmissionCommand> markQuestionSubmissionCommandList
            ){
        log.info("Mark question");
        questionSubmissionApplicationService.markQuestion(markQuestionSubmissionCommandList);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/submit-all")
    @Operation(summary = "Submit question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = ExamQuestionSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<ExamQuestionSubmissionResponse> submitExam(
            @RequestBody ExamQuestionSubmissionCommand examQuestionSubmissionCommand) {
        log.info("Submitting questions: {}", examQuestionSubmissionCommand);
        ExamQuestionSubmissionResponse response = questionSubmissionApplicationService.submitExamQuestion(examQuestionSubmissionCommand);
        log.info("Question list submitted: {}", response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/submit-one")
    @Operation(summary = "Submit one question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = OneExamQuestionSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<OneExamQuestionSubmissionResponse> submitOneExam(@RequestBody OneExamQuestionSubmissionCommand oneExamQuestionSubmissionCommand) {
        log.info("Submitting one question: {}", oneExamQuestionSubmissionCommand);
        OneExamQuestionSubmissionResponse response = questionSubmissionApplicationService.submitOneExamQuestion(oneExamQuestionSubmissionCommand);
        log.info("One question submitted: {}", response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/get-by-questionId")
    @Operation(summary = "Get all questions by exam id and user id and questionId list.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryQuestionSubmissionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryQuestionSubmissionResponse> getQuestionSubmissionByQuestionId(
           @RequestBody QueryQuestionSubmissionCommand queryQuestionSubmissionCommand) {
        log.info("Getting question submission by question id list: {}", queryQuestionSubmissionCommand);
        QueryQuestionSubmissionResponse response = questionSubmissionApplicationService.getQuestionSubmissionByQuestionIdList(queryQuestionSubmissionCommand);
        log.info("Question submission by question id list: {}", response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
