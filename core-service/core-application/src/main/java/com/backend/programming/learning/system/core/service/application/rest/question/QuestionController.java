package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.QuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<QuestionResponseEntity>> getAllQuestions() {
        log.info("Getting all questions");
        List<QuestionResponseEntity> questionResponseEntity = questionApplicationService.queryAllQuestion();
        log.info("Questions retrieved: {}", questionResponseEntity);

        return ResponseEntity.ok(questionResponseEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseEntity> getQuestion(@PathVariable UUID id) {
        log.info("Getting question with id: {}", id);
        QuestionResponseEntity questionResponseEntity = questionApplicationService.queryQuestionById(id);
        log.info("Question retrieved: {}", questionResponseEntity);

        return ResponseEntity.ok(questionResponseEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<QuestionDeleteResponse> deleteQuestion(@PathVariable UUID id) {
        log.info("Deleting question with id: {}", id);
        QuestionDeleteResponse questionDeleteResponse = questionApplicationService.deleteQuestionById(id);
        log.info("Question deleted");

        return ResponseEntity.ok(questionDeleteResponse);
    }
}
