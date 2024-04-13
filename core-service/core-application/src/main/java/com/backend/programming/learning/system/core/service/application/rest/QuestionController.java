package com.backend.programming.learning.system.core.service.application.rest;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.QuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/questions", produces = "application/vnd.api.v1+json")
public class QuestionController {
    private final QuestionApplicationService questionApplicationService;

    public QuestionController(QuestionApplicationService questionApplicationService) {
        this.questionApplicationService = questionApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateQuestionResponse> createQuestion(
            @RequestBody CreateQuestionCommand createQuestionCommand) {
        log.info("Creating question: {}", createQuestionCommand);
        CreateQuestionResponse createQuestionResponse = questionApplicationService.createQuestion(createQuestionCommand);
        log.info("Question created: {}", createQuestionResponse);

        return ResponseEntity.ok(createQuestionResponse);
    }
}
