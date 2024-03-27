package com.backend.programming.learning.system.course.service.application.rest.question;

import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.question.get.QuestionResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.question.QuestionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.backend.programming.learning.system.course.service.application.rest.question
 * Create by Dang Ngoc Tien
 * Date 3/25/2024 - 10:58 PM
 * Description: ...
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/exam/{examId}/question", produces = "application/vnd.api.v1+json")
public class QuestionController {
    final private QuestionApplicationService questionApplicationService;

    @PostMapping
    public ResponseEntity<CreateQuestionResponse> createQuestion(
            @PathVariable Long examId,
            @RequestBody CreateQuestionCommand createQuestionCommand
    ) {
        log.info("Creating question");
        CreateQuestionResponse response = questionApplicationService.createQuestion(examId, createQuestionCommand);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<QuestionResponse> getQuestions(
            @PathVariable Long examId
    ) {
        log.info("Getting question");
        QuestionResponse response = questionApplicationService.getQuestions(examId);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{questionId}")
    public ResponseEntity<Void> deleteQuestion(
            @PathVariable Long examId,
            @PathVariable Long questionId
    ) {
        log.info("Deleting question");
        questionApplicationService.deleteQuestion(examId, questionId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{questionId}")
    public ResponseEntity<CreateQuestionResponse> getQuestion(
            @PathVariable Long examId,
            @PathVariable Long questionId
    ) {
        log.info("Getting question");
        CreateQuestionResponse response = questionApplicationService.getQuestion(questionId);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{questionId}")
    public ResponseEntity<CreateQuestionResponse> updateQuestion(
            @PathVariable Long examId,
            @PathVariable Long questionId,
            @RequestBody CreateQuestionCommand createQuestionCommand
    ) {
        log.info("Updating question");
        CreateQuestionResponse response = questionApplicationService.updateQuestion(examId, questionId, createQuestionCommand);
        return ResponseEntity.ok(response);
    }
}
