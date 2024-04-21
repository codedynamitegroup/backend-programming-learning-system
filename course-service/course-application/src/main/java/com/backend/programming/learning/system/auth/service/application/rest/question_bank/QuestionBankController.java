package com.backend.programming.learning.system.auth.service.application.rest.question_bank;

import com.backend.programming.learning.system.dto.method.create.question_bank.CreateQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.create.question_bank.CreateQuestionBankResponse;
import com.backend.programming.learning.system.dto.method.delete.question_bank.DeleteQuestionBankResponse;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryAllQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryAllQuestionBankResponse;
import com.backend.programming.learning.system.dto.method.query.question_bank.QueryQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.update.question_bank.UpdateQuestionBankCommand;
import com.backend.programming.learning.system.dto.method.update.question_bank.UpdateQuestionBankResponse;
import com.backend.programming.learning.system.dto.responseentity.question_bank.QuestionBankResponseEntity;
import com.backend.programming.learning.system.ports.input.service.question_bank.QuestionBankApplicationService;
import com.backend.programming.learning.system.valueobject.QuestionBankId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 3:54 PM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/question/bank", produces = "application/vnd.api.v1+json")
public class QuestionBankController {
    private final QuestionBankApplicationService questionBankApplicationService;

    @PostMapping("/create")
    public ResponseEntity<CreateQuestionBankResponse> createQuestionBank(
            @RequestBody CreateQuestionBankCommand createQuestionBankCommand) {
        log.info("Creating question bank");
        CreateQuestionBankResponse response = questionBankApplicationService.createQuestionBankCommand(createQuestionBankCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<QueryAllQuestionBankResponse> getQuestionBank(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        QueryAllQuestionBankCommand queryAllQuestionBankCommand = QueryAllQuestionBankCommand.builder()
                .search(search)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build();
        QueryAllQuestionBankResponse response = questionBankApplicationService.findAllQuestionBank(queryAllQuestionBankCommand);
        log.info("Get all question bank");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{questionBankId}")
    public ResponseEntity<QuestionBankResponseEntity> getQuestionBankById(
            @PathVariable UUID questionBankId
    ) {
        log.info("Get question bank by id");
        QueryQuestionBankCommand queryQuestionBankCommand = QueryQuestionBankCommand.builder().questionBankId(questionBankId).build();
        QuestionBankResponseEntity response = questionBankApplicationService.findQuestionBankById(queryQuestionBankCommand);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{questionBankId}")
    public ResponseEntity<UpdateQuestionBankResponse> updateQuestionBank(
            @PathVariable UUID questionBankId,
            @RequestBody UpdateQuestionBankCommand updateQuestionBankCommand
    ) {
        log.info("Update question bank");
        UpdateQuestionBankResponse response = questionBankApplicationService.updateQuestionBankCommand(
                new QuestionBankId(questionBankId),
                updateQuestionBankCommand);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{questionBankId}")
    public ResponseEntity<DeleteQuestionBankResponse> deleteQuestionBank(
            @PathVariable UUID questionBankId
    ) {
        log.info("Delete question bank");
        questionBankApplicationService.deleteQuestionBank(new QuestionBankId(questionBankId));
        return ResponseEntity.ok(DeleteQuestionBankResponse.builder().message("Question bank deleted successfully").build());
    }
}
