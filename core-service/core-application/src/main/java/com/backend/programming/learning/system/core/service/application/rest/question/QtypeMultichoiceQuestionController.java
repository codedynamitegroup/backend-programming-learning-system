package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeMultichoiceQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeMultichoiceQuestionApplicationService;
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

@Slf4j
@RestController
@RequestMapping(value = "/core/questions/multichoice-question", produces = "application/vnd.api.v1+json")
public class QtypeMultichoiceQuestionController {
    private final QtypeMultichoiceQuestionApplicationService qtypeMultichoiceQuestionApplicationService;

    public QtypeMultichoiceQuestionController(QtypeMultichoiceQuestionApplicationService qtypeMultichoiceQuestionApplicationService) {
        this.qtypeMultichoiceQuestionApplicationService = qtypeMultichoiceQuestionApplicationService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create multichoice question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateQuestionResponse> createQtypeMultichoiceQuestion(
            @RequestBody CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand) {
        log.info("Creating multichoice question: {}", createQtypeMultichoiceQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeMultichoiceQuestionApplicationService
                .createQtypeMultichoiceQuestion(createQtypeMultichoiceQuestionCommand);
        log.info("Question multichoice created: {}", createQuestionResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createQuestionResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get multichoice question by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryQtypeMultichoiceQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryQtypeMultichoiceQuestionResponse> queryQtypeMultichoiceQuestionById(@PathVariable("id") UUID id) {
        log.info("Querying multichoice question by id: {}", id);
        QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionResponse = qtypeMultichoiceQuestionApplicationService
                .queryQtypeMultichoiceQuestionById(id);
        log.info("Question multichoice queried: {}", queryQtypeMultichoiceQuestionResponse);

        return ResponseEntity.ok(queryQtypeMultichoiceQuestionResponse);
    }

    @GetMapping("/questionId/{questionId}")
    public ResponseEntity<QueryQtypeMultichoiceQuestionResponse> queryQtypeMultichoiceQuestionByQuestionId(@PathVariable("questionId") UUID questionId) {
        log.info("Querying multichoice question by question id: {}", questionId);
        QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionResponse = qtypeMultichoiceQuestionApplicationService
                .queryQtypeMultichoiceQuestionByQuestionId(questionId);
        log.info("Question multichoice queried: {}", queryQtypeMultichoiceQuestionResponse);

        return ResponseEntity.ok(queryQtypeMultichoiceQuestionResponse);
    }
    @GetMapping
    @Operation(summary = "Get all multichoice questions.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryQtypeMultichoiceQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<List<QueryQtypeMultichoiceQuestionResponse>> queryAllQtypeMultichoiceQuestion() {
        log.info("Querying all multichoice questions");
        List<QueryQtypeMultichoiceQuestionResponse> queryQtypeMultichoiceQuestionResponse = qtypeMultichoiceQuestionApplicationService
                .queryAllQtypeMultichoiceQuestion();
        log.info("Questions multichoice queried: {}", queryQtypeMultichoiceQuestionResponse);

        return ResponseEntity.ok(queryQtypeMultichoiceQuestionResponse);
    }

    @PutMapping
    @Operation(summary = "Update multichoice question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateQuestionResponse> updateQtypeMultichoiceQuestion(
            @RequestBody UpdateQtypeMultichoiceQuestionCommand updateQtypeMultichoiceQuestionCommand) {
        log.info("Updating multichoice question: {}", updateQtypeMultichoiceQuestionCommand);
        UpdateQuestionResponse createQuestionResponse = qtypeMultichoiceQuestionApplicationService
                .updateQtypeMultichoiceQuestion(updateQtypeMultichoiceQuestionCommand);
        log.info("Question multichoice updated: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }
}
