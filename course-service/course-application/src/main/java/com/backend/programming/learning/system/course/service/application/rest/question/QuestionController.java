package com.backend.programming.learning.system.course.service.application.rest.question;

import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.question.create.CreateQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.question.QuestionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping(value = "/question", produces = "application/vnd.api.v1+json")
public class QuestionController {
final private QuestionApplicationService questionApplicationService;
@PostMapping
    public ResponseEntity<CreateQuestionResponse> createQuestion(
            @RequestBody CreateQuestionCommand createQuestionCommand
) {
        log.info("Creating question");
        CreateQuestionResponse response = questionApplicationService.createQuestion(createQuestionCommand);
        return ResponseEntity.ok(response);
    }
}
