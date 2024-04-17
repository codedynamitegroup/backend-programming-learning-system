package com.backend.programming.learning.system.core.service.application.rest.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.AnswerOfQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/core/questions/answer", produces = "application/vnd.api.v1+json")
public class AnswerOfQuestionController {
    private final AnswerOfQuestionApplicationService answerOfQuestionApplicationService;

    public AnswerOfQuestionController(AnswerOfQuestionApplicationService answerOfQuestionApplicationService) {
        this.answerOfQuestionApplicationService = answerOfQuestionApplicationService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AnswerOfQuestionDeleteResponse> deleteAnswerOfQuestionById(@PathVariable UUID id) {
        return ResponseEntity.ok(answerOfQuestionApplicationService.deleteAnswerOfQuestionById(id));
    }
}
