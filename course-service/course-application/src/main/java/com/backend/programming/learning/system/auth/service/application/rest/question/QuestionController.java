package com.backend.programming.learning.system.auth.service.application.rest.question;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.question.DeleteQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QueryAllQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QueryAllQuestionExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QueryAllQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QueryQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.question.QuestionApplicationService;
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
 * com.backend.programming.learning.system.auth.service.application.rest.post
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 10:48 PM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/question", produces = "application/vnd.api.v1+json")
public class QuestionController {
    final private QuestionApplicationService questionApplicationService;

    @PostMapping("/create")
    @Operation(summary = "Create question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateQuestionResponse> createQuestion(
            @RequestBody CreateQuestionCommand createQuestionCommand
    ) {
        log.info("Creating question");
        CreateQuestionResponse response = questionApplicationService.createQuestion(createQuestionCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/bank/create")
    @Operation(summary = "Create question bank.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateQuestionResponse> createQuestionBank(
            @RequestBody CreateQuestionCommand createQuestionCommand
    ) {
        log.info("Creating question bank");
        CreateQuestionResponse response = questionApplicationService.createQuestionBank(createQuestionCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Get all questions.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllQuestionResponse> findAllQuestions(
            @RequestParam(name = "questionBankCategoryId", required = false) UUID questionBankCategoryId,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        QueryAllQuestionCommand queryAllQuestionCommand = QueryAllQuestionCommand.builder()
                .questionBankCategoryId(questionBankCategoryId)
                .search(search)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build();
        QueryAllQuestionResponse response = questionApplicationService.findAllQuestions(queryAllQuestionCommand);
        log.info("Get all questions");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{questionId}")
    @Operation(summary = "Get question by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QuestionResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QuestionResponseEntity> findById(@PathVariable UUID questionId) {
        log.info("Get question by id: {}", questionId);
        QueryQuestionCommand queryQuestionCommand = QueryQuestionCommand.builder().questionId(questionId).build();
        QuestionResponseEntity response = questionApplicationService.findById(queryQuestionCommand);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{questionId}")
    @Operation(summary = "Delete question by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<String> deleteById(@PathVariable UUID questionId) {
        log.info("Delete question by id: {}", questionId);
        DeleteQuestionCommand deleteQuestionCommand = DeleteQuestionCommand.builder().questionId(questionId).build();
        questionApplicationService.deleteById(deleteQuestionCommand);
        return ResponseEntity.ok("Question deleted successfully");
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<QueryAllQuestionResponse> findAllQuestionsByExamId(
            @PathVariable UUID examId,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        QueryAllQuestionExamCommand queryAllQuestionCommand = QueryAllQuestionExamCommand.builder()
                .examId(examId)
                .search(search)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build();
        QueryAllQuestionResponse response = questionApplicationService.findAllQuestionsByExamId(queryAllQuestionCommand);
        log.info("Get all questions by exam id");
        return ResponseEntity.ok(response);
    }
}
