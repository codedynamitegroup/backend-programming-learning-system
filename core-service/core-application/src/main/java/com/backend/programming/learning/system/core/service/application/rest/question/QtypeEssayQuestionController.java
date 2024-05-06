package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllQtypeEssayQuestionsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeEssayQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeEssayQuestionApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/core/questions/essay-question", produces = "application/vnd.api.v1+json")
public class QtypeEssayQuestionController {
    private final QtypeEssayQuestionApplicationService qtypeEssayQuestionApplicationService;

    public QtypeEssayQuestionController(QtypeEssayQuestionApplicationService qtypeEssayQuestionApplicationService) {
        this.qtypeEssayQuestionApplicationService = qtypeEssayQuestionApplicationService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create essay question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateQuestionResponse> createQtypeEssayQuestion(
            @RequestBody CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand) {
        log.info("Creating essay question: {}", createQtypeEssayQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeEssayQuestionApplicationService
                .createQtypeEssayQuestion(createQtypeEssayQuestionCommand);
        log.info("Question essay created: {}", createQuestionResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createQuestionResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get essay question by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryQtypeEssayQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryQtypeEssayQuestionResponse> queryQtypeEssayQuestionById(@PathVariable UUID id) {
        log.info("Getting essay question with id: {}", id);
        QueryQtypeEssayQuestionResponse queryQuestionResponse = qtypeEssayQuestionApplicationService
                .queryQtypeEssayQuestionById(id);
        log.info("Essay question retrieved: {}", queryQuestionResponse);

        return ResponseEntity.ok(queryQuestionResponse);
    }

    @GetMapping
    @Operation(summary = "Get all essay questions.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllQtypeEssayQuestionsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllQtypeEssayQuestionsResponse> queryAllQtypeEssayQuestion() {
        log.info("Getting all essay questions");
        List<QueryQtypeEssayQuestionResponse> queryQuestionResponse = qtypeEssayQuestionApplicationService
                .queryAllQtypeEssayQuestion();
        log.info("Essay questions retrieved: {}", queryQuestionResponse);

        return ResponseEntity.ok(QueryAllQtypeEssayQuestionsResponse.builder()
                .qtypeEssayQuestions(queryQuestionResponse)
                .build());
    }

    @PutMapping
    @Operation(summary = "Update essay question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateQuestionResponse> updateQtypeEssayQuestion(
            @RequestBody UpdateQtypeEssayQuestionCommand updateQtypeEssayQuestionCommand) {
        log.info("Updating essay question: {}", updateQtypeEssayQuestionCommand);
        UpdateQuestionResponse updateQuestionResponse = qtypeEssayQuestionApplicationService
                .updateQtypeEssayQuestion(updateQtypeEssayQuestionCommand);
        log.info("Essay question updated: {}", updateQuestionResponse);

        return ResponseEntity.ok(updateQuestionResponse);
    }
}
