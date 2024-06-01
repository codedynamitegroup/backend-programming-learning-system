package com.backend.programming.learning.system.auth.service.application.rest.exam_question;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question.CreateExamQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_question.QueryAllQuestionByExamIdWithPageAttResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.exam_question.ExamQuestionApplicationService;
import com.backend.programming.learning.system.course.service.domain.valueobject.ExamId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.exam_question
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 1:48 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course", produces = "application/vnd.api.v1+json")
public class ExamQuestionController {
    private final ExamQuestionApplicationService examQuestionApplicationService;

    @GetMapping("/exam/{examId}/question")
    @Operation(summary = "Get list question by exam id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllQuestionByExamIdWithPageAttResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllQuestionByExamIdWithPageAttResponse> findAllQuestionByExamId(
            @PathVariable UUID examId,
            @RequestParam(name = "search", required = false, defaultValue = "") String search,
            @RequestParam(name = "currentPage", required = false) Integer currentPage
    ) {
        log.info("Get all question by exam id");
        QueryAllQuestionByExamIdCommand queryAllQuestionByExamIdCommand = QueryAllQuestionByExamIdCommand.builder()
                .search(search)
                .currentPage(currentPage)
                .build();
        QueryAllQuestionByExamIdWithPageAttResponse response = examQuestionApplicationService.findAllQuestionByExamId(
                new ExamId(examId),
                queryAllQuestionByExamIdCommand);
        log.info("All question by exam id: {}", response);
        return ResponseEntity.ok(response);
    }



    @PostMapping("/exam/question/assign")
    @Operation(summary = "Assign question to exam.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateExamQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateExamQuestionResponse> assignExamToQuestions(
            @RequestBody CreateExamQuestionCommand createExamQuestionCommand) {
        log.info("Assign exam to question");
        CreateExamQuestionResponse response = examQuestionApplicationService.assignExamToQuestions(createExamQuestionCommand);
        log.info("Exam assigned to question: {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping("/exam/question/un-assign")
    @Operation(summary = "Un-assign question to exam.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateExamQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateExamQuestionResponse> unAssignExamToQuestions(
            @RequestBody CreateExamQuestionCommand createExamQuestionCommand) {
        log.info("Un-assign exam to question");
        CreateExamQuestionResponse response = examQuestionApplicationService.unAssignExamToQuestions(createExamQuestionCommand);
        log.info("Exam un-assigned to question: {}", response);
        return ResponseEntity.ok(response);
    }
}
