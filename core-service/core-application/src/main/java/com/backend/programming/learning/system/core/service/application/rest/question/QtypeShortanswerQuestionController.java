package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeShortanswerQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeShortanswerQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/core/questions/shortanswer-question", produces = "application/vnd.api.v1+json")
public class QtypeShortanswerQuestionController {
    private final QtypeShortanswerQuestionApplicationService qtypeShortanswerQuestionApplicationService;

    public QtypeShortanswerQuestionController(QtypeShortanswerQuestionApplicationService qtypeShortanswerQuestionApplicationService) {
        this.qtypeShortanswerQuestionApplicationService = qtypeShortanswerQuestionApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateQuestionResponse> createQtypeShortanswerQuestion(
            @RequestBody CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand) {
        log.info("Creating shortanswer question: {}", createQtypeShortanswerQuestionCommand);
        CreateQuestionResponse createQuestionResponse = qtypeShortanswerQuestionApplicationService
                .createQtypeShortanswerQuestion(createQtypeShortanswerQuestionCommand);
        log.info("Question shortanswer created: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryQtypeShortanswerQuestionResponse> queryQtypeShortanswerQuestionById(
            @PathVariable("id") UUID qtShortanswerQuestionId) {
        log.info("Querying shortanswer question by id: {}", qtShortanswerQuestionId);
        QueryQtypeShortanswerQuestionResponse queryQtypeShortanswerQuestionResponse = qtypeShortanswerQuestionApplicationService
                .queryQtypeShortanswerQuestionById(qtShortanswerQuestionId);
        log.info("Question shortanswer queried: {}", queryQtypeShortanswerQuestionResponse);

        return ResponseEntity.ok(queryQtypeShortanswerQuestionResponse);
    }

    @GetMapping
    public ResponseEntity<List<QueryQtypeShortanswerQuestionResponse>> queryAllQtypeShortanswerQuestions() {
        log.info("Querying all shortanswer questions");
        List<QueryQtypeShortanswerQuestionResponse> queryQtypeShortanswerQuestionResponse = qtypeShortanswerQuestionApplicationService.queryAllQtypeShortanswerQuestions();
        log.info("Questions shortanswer queried: {}", queryQtypeShortanswerQuestionResponse);

        return ResponseEntity.ok(queryQtypeShortanswerQuestionResponse);
    }
}
