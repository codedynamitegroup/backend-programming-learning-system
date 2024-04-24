package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeCodeQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/create")
    public ResponseEntity<CreateQuestionResponse> createQtypeCodeQuestion(
            @RequestBody CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand) {
        log.info("Creating code question: {}", createQtypeCodeQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeCodeQuestionApplicationService
                .createQtypeCodeQuestion(createQtypeCodeQuestionCommand);
        log.info("Question code created: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryQtypeCodeQuestionResponse> getQtypeCodeQuestion(@PathVariable UUID id) {
        log.info("Getting code question with id: {}", id);
        QueryQtypeCodeQuestionResponse queryQuestionResponse = qtypeCodeQuestionApplicationService
                .queryQtypeCodeQuestionById(id);
        log.info("Code question retrieved: {}", queryQuestionResponse);

        return ResponseEntity.ok(queryQuestionResponse);
    }

    @GetMapping
    public ResponseEntity<List<QueryQtypeCodeQuestionResponse>> getAllQtypeCodeQuestions() {
        log.info("Getting all code questions");
        List<QueryQtypeCodeQuestionResponse> queryQuestionResponse = qtypeCodeQuestionApplicationService
                .queryAllQtypeCodeQuestions();
        log.info("Code questions retrieved: {}", queryQuestionResponse);

        return ResponseEntity.ok(queryQuestionResponse);
    }

    @PutMapping
    public ResponseEntity<UpdateQuestionResponse> updateQtypeCodeQuestion(
            @RequestBody UpdateQtypeCodeQuestionCommand updateQtypeCodeQuestionCommand) {
        log.info("Updating code question: {}", updateQtypeCodeQuestionCommand);
        UpdateQuestionResponse updateQuestionResponse = qtypeCodeQuestionApplicationService
                .updateQtypeCodeQuestion(updateQtypeCodeQuestionCommand);
        log.info("Code question updated: {}", updateQuestionResponse);

        return ResponseEntity.ok(updateQuestionResponse);
    }
}
