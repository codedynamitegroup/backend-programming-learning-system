package com.backend.programming.learning.system.auth.service.application.rest.question_submission;

import com.backend.programming.learning.system.dto.method.create.question_submission.CreateQuestionSubmissionCommand;
import com.backend.programming.learning.system.dto.method.create.question_submission.CreateQuestionSubmissionResponse;
import com.backend.programming.learning.system.ports.input.service.question_submission.QuestionSubmissionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.question_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 1:26 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/question", produces = "application/vnd.api.v1+json")
public class QuestionSubmissionController {
    private final QuestionSubmissionApplicationService questionSubmissionApplicationService;
    @PostMapping("/submit")
    public ResponseEntity<CreateQuestionSubmissionResponse> submitQuestion(
            @RequestBody CreateQuestionSubmissionCommand createQuestionSubmissionCommand) {
        log.info("Submit question");
        CreateQuestionSubmissionResponse response = questionSubmissionApplicationService.submitQuestion(createQuestionSubmissionCommand);
        log.info("Question submitted: {}", response);
        return ResponseEntity.ok(response);
    }
}
