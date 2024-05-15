package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.QuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllQuestionsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QuestionApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/questions", produces = "application/vnd.api.v1+json")
public class QuestionController {
    private final QuestionApplicationService questionApplicationService;

    public QuestionController(QuestionApplicationService questionApplicationService) {
        this.questionApplicationService = questionApplicationService;
    }

    @GetMapping
    @Operation(summary = "Get all questions.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllQuestionsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllQuestionsResponse> getAllQuestions() {
        log.info("Getting all questions");
        List<QuestionResponseEntity> questionResponseEntity = questionApplicationService.queryAllQuestion();
        log.info("Questions retrieved: {}", questionResponseEntity);

        return ResponseEntity.ok(QueryAllQuestionsResponse.builder()
                .questionResponses(questionResponseEntity)
                .build());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get question by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QuestionResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QuestionResponseEntity> getQuestion(@PathVariable UUID id) {
        log.info("Getting question with id: {}", id);
        QuestionResponseEntity questionResponseEntity = questionApplicationService.queryQuestionById(id);
        log.info("Question retrieved: {}", questionResponseEntity);

        return ResponseEntity.ok(questionResponseEntity);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete question by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QuestionDeleteResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QuestionDeleteResponse> deleteQuestion(@PathVariable UUID id) {
        log.info("Deleting question with id: {}", id);
        QuestionDeleteResponse questionDeleteResponse = questionApplicationService.deleteQuestionById(id);
        log.info("Question deleted");

        return ResponseEntity.ok(questionDeleteResponse);
    }
}
