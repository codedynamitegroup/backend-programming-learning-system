package com.backend.programming.learning.system.auth.service.application.rest;

import com.backend.programming.learning.system.dto.create.CreateExamCommand;
import com.backend.programming.learning.system.dto.create.CreateExamResponse;
import com.backend.programming.learning.system.dto.query.QueryExamCommand;
import com.backend.programming.learning.system.dto.query.QueryExamResponse;
import com.backend.programming.learning.system.ports.input.service.ExamApplicationService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.application.rest.exam
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 12:07 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/exam", produces = "application/vnd.api.v1+json")
public class ExamController {
    private final ExamApplicationService examApplicationService;

    @GetMapping
    public ResponseEntity<List<QueryExamResponse>> findAll(
            @RequestParam(value = "search", required = false) String search
    ) {
        log.info("Getting list exam");
        List<QueryExamResponse> response = examApplicationService.findAll(search);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateExamResponse> createExam(@RequestBody CreateExamCommand createExamCommand) {
        log.info("Creating exam");
        CreateExamResponse response = examApplicationService.createExam(createExamCommand);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{examId}")
    public ResponseEntity<QueryExamResponse> findBy(@PathVariable UUID examId) {
        QueryExamCommand queryExamCommand = QueryExamCommand.builder().examId(examId).build();
        log.info("Getting exam with id: {}", examId);
        QueryExamResponse response = examApplicationService.findBy(queryExamCommand);
        return ResponseEntity.ok(response);
    }
}
