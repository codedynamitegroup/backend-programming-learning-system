package com.backend.programming.learning.system.core.service.application.rest;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeCodeQuestionApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeEssayQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/core/questions", produces = "application/vnd.api.v1+json")
public class QuestionController {
    private final QtypeCodeQuestionApplicationService qtypeCodeQuestionApplicationService;
    private final QtypeEssayQuestionApplicationService qtypeEssayQuestionApplicationService;

    public QuestionController(QtypeCodeQuestionApplicationService qtypeCodeQuestionApplicationService,
                              QtypeEssayQuestionApplicationService qtypeEssayQuestionApplicationService) {
        this.qtypeCodeQuestionApplicationService = qtypeCodeQuestionApplicationService;
        this.qtypeEssayQuestionApplicationService = qtypeEssayQuestionApplicationService;
    }

    @PostMapping("/create/code-question")
    public ResponseEntity<CreateQuestionResponse> createQtypeCodeQuestion(
            @RequestBody CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand) {
        log.info("Creating code question: {}", createQtypeCodeQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeCodeQuestionApplicationService
                .createQtypeCodeQuestion(createQtypeCodeQuestionCommand);
        log.info("Question code created: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }

    @PostMapping("/create/essay-question")
    public ResponseEntity<CreateQuestionResponse> createQtypeEssayQuestion(
            @RequestBody CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand) {
        log.info("Creating essay question: {}", createQtypeEssayQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeEssayQuestionApplicationService
                .createQtypeEssayQuestion(createQtypeEssayQuestionCommand);
        log.info("Question essay created: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }
}
