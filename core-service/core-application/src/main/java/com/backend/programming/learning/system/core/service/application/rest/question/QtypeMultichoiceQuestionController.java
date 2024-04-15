package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeMultichoiceQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeMultichoiceQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CreateQuestionResponse> createQtypeMultichoiceQuestion(
            @RequestBody CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand) {
        log.info("Creating multichoice question: {}", createQtypeMultichoiceQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeMultichoiceQuestionApplicationService
                .createQtypeMultichoiceQuestion(createQtypeMultichoiceQuestionCommand);
        log.info("Question multichoice created: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryQtypeMultichoiceQuestionResponse> queryQtypeMultichoiceQuestionById(@PathVariable("id") UUID id) {
        log.info("Querying multichoice question by id: {}", id);
        QueryQtypeMultichoiceQuestionResponse queryQtypeMultichoiceQuestionResponse = qtypeMultichoiceQuestionApplicationService
                .queryQtypeMultichoiceQuestionById(id);
        log.info("Question multichoice queried: {}", queryQtypeMultichoiceQuestionResponse);

        return ResponseEntity.ok(queryQtypeMultichoiceQuestionResponse);
    }
}
