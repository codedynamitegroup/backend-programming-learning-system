package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.codequestion.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.codequestion.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeQuestionApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/code-assessment/code-question",
        produces = "application/vnd.api.v1+json")
@Slf4j
public class CodeQuestionController {
    private final CodeQuestionApplicationService codeQuestionApplicationService;

    public CodeQuestionController(CodeQuestionApplicationService codeQuestionApplicationService) {
        this.codeQuestionApplicationService = codeQuestionApplicationService;
    }
    @PostMapping
    @Operation(summary = "Create code question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Accepted.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateCodeQuestionResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateCodeQuestionResponse> createCodeQuestion
            (@RequestBody CreateCodeQuestionCommand createCodeQuestionCommand){
        log.info("Create code question for question id {}", createCodeQuestionCommand.getQuestionId());
        CreateCodeQuestionResponse createCodeQuestionResponse =
            codeQuestionApplicationService.createCodeQuestion(createCodeQuestionCommand);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(createCodeQuestionResponse);
    }
}
