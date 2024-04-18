package com.backend.programming.learning.system.auth.service.application.rest.exam;

import com.backend.programming.learning.system.dto.method.create.exam.CreateExamCommand;
import com.backend.programming.learning.system.dto.method.create.exam.CreateExamResponse;
import com.backend.programming.learning.system.dto.method.query.exam.QueryAllExamCommand;
import com.backend.programming.learning.system.dto.method.query.exam.QueryAllExamResponse;
import com.backend.programming.learning.system.dto.method.query.exam.QueryExamCommand;
import com.backend.programming.learning.system.dto.responseentity.exam.ExamResponseEntity;
import com.backend.programming.learning.system.ports.input.service.exam.ExamApplicationService;
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
    public ResponseEntity<QueryAllExamResponse> findAll(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        log.info("Getting list exam");
        QueryAllExamCommand queryAllExamCommand = QueryAllExamCommand.builder()
                .search(search)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .build();
        QueryAllExamResponse response = examApplicationService.findAll(queryAllExamCommand);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateExamResponse> createExam(@RequestBody CreateExamCommand createExamCommand) {
        log.info("Creating exam");
        CreateExamResponse response = examApplicationService.createExam(createExamCommand);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{examId}")
    public ResponseEntity<ExamResponseEntity> findBy(@PathVariable UUID examId) {
        QueryExamCommand queryExamCommand = QueryExamCommand.builder().examId(examId).build();
        log.info("Getting exam with id: {}", examId);
        ExamResponseEntity response = examApplicationService.findBy(queryExamCommand);
        return ResponseEntity.ok(response);
    }
}
