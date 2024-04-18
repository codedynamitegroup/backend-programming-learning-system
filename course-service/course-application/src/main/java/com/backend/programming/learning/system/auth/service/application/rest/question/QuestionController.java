package com.backend.programming.learning.system.auth.service.application.rest.question;

import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.dto.method.query.question.QueryAllQuestionCommand;
import com.backend.programming.learning.system.dto.method.query.question.QueryAllQuestionResponse;
import com.backend.programming.learning.system.ports.input.service.question.QuestionApplicationService;
import com.backend.programming.learning.system.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.post
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 10:48 PM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/question", produces = "application/vnd.api.v1+json")
public class QuestionController {
    final private QuestionApplicationService questionApplicationService;

    @PostMapping("/create")
    public ResponseEntity<CreateQuestionResponse> createQuestion(
            @RequestBody CreateQuestionCommand createQuestionCommand
    ) {
        log.info("Creating question");
        CreateQuestionResponse response = questionApplicationService.createQuestion(createQuestionCommand);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<QueryAllQuestionResponse> findAllQuestions(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        QueryAllQuestionCommand queryAllQuestionCommand = QueryAllQuestionCommand.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build();
        QueryAllQuestionResponse response = questionApplicationService.findAllQuestions(queryAllQuestionCommand);
        log.info("Get all questions");
        return ResponseEntity.ok(response);
    }
}
