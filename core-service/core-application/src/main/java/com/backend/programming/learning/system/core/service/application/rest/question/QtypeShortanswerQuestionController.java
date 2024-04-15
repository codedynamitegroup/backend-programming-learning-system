package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QtypeShortanswerQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
