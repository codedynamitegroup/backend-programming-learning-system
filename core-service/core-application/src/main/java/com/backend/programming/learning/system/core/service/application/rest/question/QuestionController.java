package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/questions", produces = "application/vnd.api.v1+json")
public class QuestionController {
    private final QuestionApplicationService questionApplicationService;

    public QuestionController(QuestionApplicationService questionApplicationService) {
        this.questionApplicationService = questionApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<QueryQuestionResponse>> getAllQuestions() {
        log.info("Getting all questions");
        List<QueryQuestionResponse> queryQuestionResponse = questionApplicationService.queryAllQuestion();
        log.info("Questions retrieved: {}", queryQuestionResponse);

        return ResponseEntity.ok(queryQuestionResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueryQuestionResponse> getQuestion(@PathVariable UUID id) {
        log.info("Getting question with id: {}", id);
        QueryQuestionResponse queryQuestionResponse = questionApplicationService.queryQuestionById(id);
        log.info("Question retrieved: {}", queryQuestionResponse);

        return ResponseEntity.ok(queryQuestionResponse);
    }
}
