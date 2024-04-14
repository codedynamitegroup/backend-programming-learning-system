package com.backend.programming.learning.system.course.service.application.rest.exam.submission;

import com.backend.programming.learning.system.course.service.domain.ports.input.service.exam.submission.ExamSubmissionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.backend.programming.learning.system.course.service.application.rest.exam.submission
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 11:12 PM
 * Description: ...
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/exam/{examId}/submission", produces = "application/vnd.api.v1+json")
public class ExamSubmissionController {
    private final ExamSubmissionApplicationService examSubmissionApplicationService;
    @PostMapping
    public ResponseEntity<Void> submitExam(
            @PathVariable Long examId
    ) {
        log.info("Submitting exam with id: {}", examId);
        examSubmissionApplicationService.submitExam(examId);
        return ResponseEntity.noContent().build();
    }
}
