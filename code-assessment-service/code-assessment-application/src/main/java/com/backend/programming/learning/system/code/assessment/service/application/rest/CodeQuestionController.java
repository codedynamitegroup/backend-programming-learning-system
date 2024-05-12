package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.code_question.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.query.code_question.GetCodeQuestionsResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeQuestionApplicationService;
import com.backend.programming.learning.system.domain.valueobject.QueryOrderBy;
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

        if(createCodeQuestionCommand.getIsPublic() == null)
            createCodeQuestionCommand.setIsPublic(true);

        CreateCodeQuestionResponse createCodeQuestionResponse =
            codeQuestionApplicationService.createCodeQuestion(createCodeQuestionCommand);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(createCodeQuestionResponse);
    }

    @GetMapping
    public ResponseEntity<GetCodeQuestionsResponse> getPublicCodeQuestion(
            @RequestParam(defaultValue = "${code-assessment-service.default-page-number}") Integer pageNo,
            @RequestParam(defaultValue = "${code-assessment-service.default-page-size}") Integer pageSize,
            @RequestParam(required = false) List<UUID> tagIds,
            @RequestParam(defaultValue = "ASC") QueryOrderBy orderBy,
            @RequestParam(defaultValue = "createdAt") CodeQuestion.Fields sortBy,
            @RequestParam UUID userId){
        GetCodeQuestionsCommand command = GetCodeQuestionsCommand.builder()
                .orderBy(orderBy)
                .sortBy(sortBy)
                .pageNum(pageNo)
                .pageSize(pageSize)
                .tagIds(tagIds)
                .userId(userId)
                .build();
        GetCodeQuestionsResponse response = codeQuestionApplicationService.getCodeQuestions(command);
        return ResponseEntity.ok(response);

    }
}
