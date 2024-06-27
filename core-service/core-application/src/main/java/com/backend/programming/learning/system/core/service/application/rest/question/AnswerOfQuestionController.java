package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAnswerOfQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.AnswerOfQuestionApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/questions/answer", produces = "application/vnd.api.v1+json")
public class AnswerOfQuestionController {
    private final AnswerOfQuestionApplicationService answerOfQuestionApplicationService;

    public AnswerOfQuestionController(AnswerOfQuestionApplicationService answerOfQuestionApplicationService) {
        this.answerOfQuestionApplicationService = answerOfQuestionApplicationService;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete answer of question by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = AnswerOfQuestionDeleteResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<AnswerOfQuestionDeleteResponse> deleteAnswerOfQuestionById(@PathVariable UUID id) {
        return ResponseEntity.ok(answerOfQuestionApplicationService.deleteAnswerOfQuestionById(id));
    }

    @GetMapping("/{questionId}")
    @Operation(summary = "Get answer of question by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAnswerOfQuestionResponse[].class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<List<QueryAnswerOfQuestionResponse>> getAnswerOfQuestionByQuestionId(
            @PathVariable UUID questionId) {
        List<QueryAnswerOfQuestionResponse> response = answerOfQuestionApplicationService
                .getAnswerOfQuestionByQuestionId(questionId);
        return ResponseEntity.ok(response);
    }
}
