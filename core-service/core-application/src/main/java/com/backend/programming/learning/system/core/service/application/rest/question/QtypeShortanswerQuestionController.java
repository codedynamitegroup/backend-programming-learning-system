package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllQtypeShortanswerQuestionsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeShortanswerQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeShortanswerQuestionApplicationService;
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
@RequestMapping(value = "/core/questions/shortanswer-question", produces = "application/vnd.api.v1+json")
public class QtypeShortanswerQuestionController {
    private final QtypeShortanswerQuestionApplicationService qtypeShortanswerQuestionApplicationService;

    public QtypeShortanswerQuestionController(QtypeShortanswerQuestionApplicationService qtypeShortanswerQuestionApplicationService) {
        this.qtypeShortanswerQuestionApplicationService = qtypeShortanswerQuestionApplicationService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create shortanswer question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateQuestionResponse> createQtypeShortanswerQuestion(
            @RequestBody CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand) {
        log.info("Creating shortanswer question: {}", createQtypeShortanswerQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeShortanswerQuestionApplicationService
                .createQtypeShortanswerQuestion(createQtypeShortanswerQuestionCommand);
        log.info("Question shortanswer created: {}", createQuestionResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createQuestionResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Query shortanswer question by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryQtypeShortanswerQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryQtypeShortanswerQuestionResponse> queryQtypeShortanswerQuestionById(
            @PathVariable("id") UUID qtShortanswerQuestionId) {
        log.info("Querying shortanswer question by id: {}", qtShortanswerQuestionId);
        QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionResponse = qtypeShortanswerQuestionApplicationService
                .queryQtypeShortanswerQuestionById(qtShortanswerQuestionId);
        log.info("Question shortanswer queried: {}", queryQtypeShortanswerQuestionResponse);

        return ResponseEntity.ok(queryQtypeShortanswerQuestionResponse);
    }

    @GetMapping
    @Operation(summary = "Query all shortanswer questions.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllQtypeShortanswerQuestionsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllQtypeShortanswerQuestionsResponse> queryAllQtypeShortanswerQuestions() {
        log.info("Querying all shortanswer questions");
        List<QueryQtypeShortanswerQuestionResponse> queryQtypeShortanswerQuestionResponse = qtypeShortanswerQuestionApplicationService.queryAllQtypeShortanswerQuestions();
        log.info("Questions shortanswer queried: {}", queryQtypeShortanswerQuestionResponse);

        return ResponseEntity.ok(QueryAllQtypeShortanswerQuestionsResponse.builder()
                .qtypeShortAnswerQuestions(queryQtypeShortanswerQuestionResponse)
                .build());
    }

    @PutMapping
    @Operation(summary = "Update shortanswer question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateQuestionResponse> updateQtypeShortanswerQuestion(
            @RequestBody UpdateQtypeShortanswerQuestionCommand updateQtypeShortanswerQuestionCommand) {
        log.info("Updating shortanswer question: {}", updateQtypeShortanswerQuestionCommand);
        UpdateQuestionResponse createQuestionResponse = qtypeShortanswerQuestionApplicationService
                .updateQtypeShortanswerQuestion(updateQtypeShortanswerQuestionCommand);
        log.info("Question shortanswer updated: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }
}
