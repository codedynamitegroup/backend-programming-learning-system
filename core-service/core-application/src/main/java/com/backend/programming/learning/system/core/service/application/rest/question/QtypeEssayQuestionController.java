package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeEssayQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeEssayQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeEssayQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/core/questions/essay-question", produces = "application/vnd.api.v1+json")
public class QtypeEssayQuestionController {
    private final QtypeEssayQuestionApplicationService qtypeEssayQuestionApplicationService;

    public QtypeEssayQuestionController(QtypeEssayQuestionApplicationService qtypeEssayQuestionApplicationService) {
        this.qtypeEssayQuestionApplicationService = qtypeEssayQuestionApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateQuestionResponse> createQtypeEssayQuestion(
            @RequestBody CreateQtypeEssayQuestionCommand createQtypeEssayQuestionCommand) {
        log.info("Creating essay question: {}", createQtypeEssayQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeEssayQuestionApplicationService
                .createQtypeEssayQuestion(createQtypeEssayQuestionCommand);
        log.info("Question essay created: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryQtypeEssayQuestionResponse> queryQtypeEssayQuestionById(@PathVariable UUID id) {
        log.info("Getting essay question with id: {}", id);
        QueryQtypeEssayQuestionResponse queryQuestionResponse = qtypeEssayQuestionApplicationService
                .queryQtypeEssayQuestionById(id);
        log.info("Essay question retrieved: {}", queryQuestionResponse);

        return ResponseEntity.ok(queryQuestionResponse);
    }

    @GetMapping
    public ResponseEntity<List<QueryQtypeEssayQuestionResponse>> queryAllQtypeEssayQuestion() {
        log.info("Getting all essay questions");
        List<QueryQtypeEssayQuestionResponse> queryQuestionResponse = qtypeEssayQuestionApplicationService
                .queryAllQtypeEssayQuestion();
        log.info("Essay questions retrieved: {}", queryQuestionResponse);

        return ResponseEntity.ok(queryQuestionResponse);
    }
}
