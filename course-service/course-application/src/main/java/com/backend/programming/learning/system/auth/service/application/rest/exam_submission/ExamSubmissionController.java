package com.backend.programming.learning.system.auth.service.application.rest.exam_submission;

import com.backend.programming.learning.system.dto.method.create.exam_submisison.CreateExamSubmissionCommand;
import com.backend.programming.learning.system.dto.method.create.exam_submisison.CreateExamSubmissionResponse;
import com.backend.programming.learning.system.ports.input.service.exam_submission.ExamSubmissionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.backend.programming.learning.system.auth.service.application.rest.exam_submission
 * Create by Dang Ngoc Tien
 * Date 4/24/2024 - 12:07 AM
 * Description: ...
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/exam/question", produces = "application/vnd.api.v1+json")
public class ExamSubmissionController {
    private final ExamSubmissionApplicationService examSubmissionApplicationService;
    @PostMapping("/submit")
    public ResponseEntity<CreateExamSubmissionResponse> submitExam(
            @RequestBody CreateExamSubmissionCommand createExamSubmissionCommand) {
        log.info("Submit exam");
        CreateExamSubmissionResponse response = examSubmissionApplicationService.submitExam(createExamSubmissionCommand);
        log.info("Exam submitted: {}", response);
        return ResponseEntity.ok(response);
    }
//    @DeleteMapping("un-submit")
//    public ResponseEntity<CreateExamSubmissionResponse> unSubmitExam(
//            @RequestBody CreateExamSubmissionCommand createExamSubmissionCommand) {
//        log.info("Un-submit exam");
//        CreateExamSubmissionResponse response = examSubmissionApplicationService.unSubmitExam(createExamSubmissionCommand);
//        log.info("Exam un-submitted: {}", response);
//        return ResponseEntity.ok(response);
//    }
}
