package com.backend.programming.learning.system.code.assessment.service.application.rest;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.codequestion.CreateCodeQuestionCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.create.codequestion.CreateCodeQuestionResponse;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.CodeQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<CreateCodeQuestionResponse> createCodeQuestion
            (@RequestBody CreateCodeQuestionCommand createCodeQuestionCommand){
        log.info("Create code question for question id {}", createCodeQuestionCommand.getQuestionId());
        CreateCodeQuestionResponse createCodeQuestionResponse =
            codeQuestionApplicationService.createCodeQuestion(createCodeQuestionCommand);
        return ResponseEntity.ok(createCodeQuestionResponse);
    }
}
