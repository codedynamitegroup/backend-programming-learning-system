package com.backend.programming.learning.system.core.service.application.rest;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.CoreApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/core", produces = "application/vnd.api.v1+json")
public class CoreController {
    private final CoreApplicationService coreApplicationService;

    public CoreController(CoreApplicationService coreApplicationService) {
        this.coreApplicationService = coreApplicationService;
    }

    @PostMapping("/question/create")
    public ResponseEntity<CreateQuestionResponse> createQuestion(@RequestBody CreateQuestionCommand createQuestionCommand, @RequestBody CreateQuestionCommand crete2) {
        log.info("Creating question: {}", createQuestionCommand);
        CreateQuestionResponse createQuestionResponse = coreApplicationService.createQuestion(createQuestionCommand);
        log.info("Question created: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }

}
