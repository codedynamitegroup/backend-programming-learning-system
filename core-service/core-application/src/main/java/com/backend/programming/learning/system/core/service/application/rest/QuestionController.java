package com.backend.programming.learning.system.core.service.application.rest;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.*;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/questions", produces = "application/vnd.api.v1+json")
public class QuestionController {
    private final QtypeCodeQuestionApplicationService qtypeCodeQuestionApplicationService;
    private final QtypeEssayQuestionApplicationService qtypeEssayQuestionApplicationService;
    private final QtypeShortanswerQuestionApplicationService qtypeShortanswerQuestionApplicationService;
    private final QtypeMultichoiceQuestionApplicationService qtypeMultichoiceQuestionApplicationService;
    private final QuestionApplicationService questionApplicationService;

    public QuestionController(QtypeCodeQuestionApplicationService qtypeCodeQuestionApplicationService,
                              QtypeEssayQuestionApplicationService qtypeEssayQuestionApplicationService,
                              QtypeShortanswerQuestionApplicationService qtypeShortanswerQuestionApplicationService,
                              QtypeMultichoiceQuestionApplicationService qtypeMultichoiceQuestionApplicationService,
                              QuestionApplicationService questionApplicationService) {
        this.qtypeCodeQuestionApplicationService = qtypeCodeQuestionApplicationService;
        this.qtypeEssayQuestionApplicationService = qtypeEssayQuestionApplicationService;
        this.qtypeShortanswerQuestionApplicationService = qtypeShortanswerQuestionApplicationService;
        this.qtypeMultichoiceQuestionApplicationService = qtypeMultichoiceQuestionApplicationService;
        this.questionApplicationService = questionApplicationService;
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

    @PostMapping("/create/shortanswer-question")
    public ResponseEntity<CreateQuestionResponse> createQtypeShortanswerQuestion(
            @RequestBody CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand) {
        log.info("Creating shortanswer question: {}", createQtypeShortanswerQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeShortanswerQuestionApplicationService
                .createQtypeShortanswerQuestion(createQtypeShortanswerQuestionCommand);
        log.info("Question shortanswer created: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }

    @PostMapping("/create/multichoice-question")
    public ResponseEntity<CreateQuestionResponse> createQtypeMultichoiceQuestion(
            @RequestBody CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand) {
        log.info("Creating multichoice question: {}", createQtypeMultichoiceQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeMultichoiceQuestionApplicationService
                .createQtypeMultichoiceQuestion(createQtypeMultichoiceQuestionCommand);
        log.info("Question multichoice created: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryQuestionResponse> getQuestion(@PathVariable UUID id) {
        log.info("Getting question with id: {}", id);
        QueryQuestionResponse queryQuestionResponse = questionApplicationService.queryQuestionById(id);
        log.info("Question retrieved: {}", queryQuestionResponse);

        return ResponseEntity.ok(queryQuestionResponse);
    }
}
