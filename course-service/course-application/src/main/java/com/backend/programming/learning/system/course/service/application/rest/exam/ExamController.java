package com.backend.programming.learning.system.course.service.application.rest.exam;

import com.backend.programming.learning.system.course.service.domain.dto.create.CreateExamCommand;
import com.backend.programming.learning.system.course.service.domain.dto.create.CreateExamResponse;
import com.backend.programming.learning.system.course.service.domain.dto.get.ExamsResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.ExamApplicationService;
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

/**
 * com.backend.programming.learning.system.course.application.rest.exam
 * Create by Dang Ngoc Tien
 * Date 3/21/2024 - 12:07 AM
 * Description: ...
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/exam", produces = "application/vnd.api.v1+json")
public class ExamController {
    private final ExamApplicationService examApplicationService;

    @GetMapping
    public ResponseEntity<ExamsResponse> findAll(
            @RequestParam(value = "search", required = false) String search
    ) {
        log.info("Getting list exam");
        ExamsResponse response = examApplicationService.findAll(search);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateExamResponse> createExam(@RequestBody CreateExamCommand createExamCommand) {
        log.info("Creating exam");
        CreateExamResponse response = examApplicationService.createExam(createExamCommand);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{examId}")
    public ResponseEntity<CreateExamResponse> getExam(@PathVariable Long examId) {
        log.info("Getting exam with id: {}", examId);
        CreateExamResponse response = examApplicationService.getExam(examId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{examId}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long examId) {
        log.info("Deleting exam with id: {}", examId);
        examApplicationService.deleteExam(examId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{examId}")
    public ResponseEntity<CreateExamResponse> updateExam(@PathVariable Long examId, @RequestBody CreateExamCommand createExamCommand) {
        log.info("Updating exam with id: {}", examId);
        CreateExamResponse response = examApplicationService.updateExam(examId, createExamCommand);
        return ResponseEntity.ok(response);
    }
}
