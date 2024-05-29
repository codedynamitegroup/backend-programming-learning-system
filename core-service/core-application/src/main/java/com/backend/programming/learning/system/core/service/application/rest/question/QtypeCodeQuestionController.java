package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAllQtypeCodeQuestionsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeCodeQuestionApplicationService;
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
@RequestMapping(value = "/core/questions/code-question", produces = "application/vnd.api.v1+json")
public class QtypeCodeQuestionController {
    private final QtypeCodeQuestionApplicationService qtypeCodeQuestionApplicationService;

    public QtypeCodeQuestionController(QtypeCodeQuestionApplicationService qtypeCodeQuestionApplicationService) {
        this.qtypeCodeQuestionApplicationService = qtypeCodeQuestionApplicationService;
    }

    //meh, still need this shit
    @PostMapping("/create")
    @Operation(summary = "Create code question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateQuestionResponse> createQtypeCodeQuestion(
            @RequestBody CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand) {
        log.info("Creating code question: {}", createQtypeCodeQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeCodeQuestionApplicationService
                .createQtypeCodeQuestion(createQtypeCodeQuestionCommand);
        log.info("Question code created: {}", createQuestionResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createQuestionResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get code question by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryQtypeCodeQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryQtypeCodeQuestionResponse> getQtypeCodeQuestion(@PathVariable UUID id) {
        log.info("Getting code question with id: {}", id);
        QueryQtypeCodeQuestionResponse queryQuestionResponse = qtypeCodeQuestionApplicationService
                .queryQtypeCodeQuestionById(id);
        log.info("Code question retrieved: {}", queryQuestionResponse);

        return ResponseEntity.ok(queryQuestionResponse);
    }

    @GetMapping
    @Operation(summary = "Get all code questions.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllQtypeCodeQuestionsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllQtypeCodeQuestionsResponse> getAllQtypeCodeQuestions() {
        log.info("Getting all code questions");
        List<QueryQtypeCodeQuestionResponse> queryQuestionResponse = qtypeCodeQuestionApplicationService
                .queryAllQtypeCodeQuestions();
        log.info("Code questions retrieved: {}", queryQuestionResponse);

        return ResponseEntity.ok(QueryAllQtypeCodeQuestionsResponse.builder()
                .qtypeCodeQuestions(queryQuestionResponse)
                .build());
    }

    //update code question in the code assessment service
//    @PutMapping
//    @Operation(summary = "Update code question.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Success.", content = {
//                    @Content(mediaType = "application/vnd.api.v1+json",
//                            schema = @Schema(implementation = UpdateQuestionResponse.class))
//            }),
//            @ApiResponse(responseCode = "400", description = "Not found."),
//            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
//    public ResponseEntity<UpdateQuestionResponse> updateQtypeCodeQuestion(
//            @RequestBody UpdateQtypeCodeQuestionCommand updateQtypeCodeQuestionCommand) {
//        log.info("Updating code question: {}", updateQtypeCodeQuestionCommand);
//        UpdateQuestionResponse updateQuestionResponse = qtypeCodeQuestionApplicationService
//                .updateQtypeCodeQuestion(updateQtypeCodeQuestionCommand);
//        log.info("Code question updated: {}", updateQuestionResponse);
//
//        return ResponseEntity.ok(updateQuestionResponse);
//    }
}
