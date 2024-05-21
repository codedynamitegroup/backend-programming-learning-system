package com.backend.programming.learning.system.auth.service.application.rest.question_bank_category;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category.CreateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category.CreateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_submission.CreateQuestionSubmissionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_bank_category.QueryAllQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_bank_category.QueryAllQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.question_bank_category.UpdateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.question_bank_category.UpdateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question_bank_category.QuestionBankCategoryEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.question_bank_category.QuestionBankCategoryApplicationService;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionBankCategoryId;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:14 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/question/bank/category", produces = "application/vnd.api.v1+json")
public class QuestionBankCategoryController {
    private final QuestionBankCategoryApplicationService questionBankCategoryApplicationService;
    @PostMapping("/create")
    @Operation(summary = "Create question bank category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateQuestionBankCategoryResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateQuestionBankCategoryResponse> createQuestionBankCategory(
            @RequestBody CreateQuestionBankCategoryCommand createQuestionBankCategoryCommand) {
        log.info("Creating question bank category");
        CreateQuestionBankCategoryResponse response = questionBankCategoryApplicationService
                .createQuestionBankCategoryCommand(createQuestionBankCategoryCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Query all question bank category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllQuestionBankCategoryResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllQuestionBankCategoryResponse> queryAllQuestionBankCategory(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("Querying all question bank category");
        QueryAllQuestionBankCategoryCommand queryAllQuestionBankCategoryCommand = QueryAllQuestionBankCategoryCommand.builder()
                .search(search)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build();
        QueryAllQuestionBankCategoryResponse response = questionBankCategoryApplicationService
                .queryAllQuestionBankCategory(queryAllQuestionBankCategoryCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{questionBankCategoryId}")
    @Operation(summary = "Query question bank category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QuestionBankCategoryEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QuestionBankCategoryEntity> queryQuestionBankCategory(
            @PathVariable UUID questionBankCategoryId
    ) {
        log.info("Querying question bank category");
        QuestionBankCategoryEntity response = questionBankCategoryApplicationService
                .queryQuestionBankCategory(new QuestionBankCategoryId(questionBankCategoryId));
        return ResponseEntity.ok(response);
    }

    @PutMapping("{questionBankCategoryId}")
    @Operation(summary = "Update question bank category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateQuestionBankCategoryResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateQuestionBankCategoryResponse> updateQuestionBankCategory(
            @PathVariable UUID questionBankCategoryId,
            @RequestBody UpdateQuestionBankCategoryCommand updateQuestionBankCategoryCommand
    ) {
        log.info("Updating question bank category");
        UpdateQuestionBankCategoryResponse response = questionBankCategoryApplicationService
                .updateQuestionBankCategory(new QuestionBankCategoryId(questionBankCategoryId), updateQuestionBankCategoryCommand);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{questionBankCategoryId}")
    @Operation(summary = "Delete question bank category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = Void.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<Void> deleteQuestionBankCategory(
            @PathVariable UUID questionBankCategoryId
    ) {
        log.info("Deleting question bank category");
        questionBankCategoryApplicationService
                .deleteQuestionBankCategory(new QuestionBankCategoryId(questionBankCategoryId));
        return ResponseEntity.ok().build();
    }
}
