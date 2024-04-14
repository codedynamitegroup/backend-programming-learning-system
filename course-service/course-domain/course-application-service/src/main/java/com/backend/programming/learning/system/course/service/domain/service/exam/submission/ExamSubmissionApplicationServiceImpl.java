package com.backend.programming.learning.system.course.service.domain.service.exam.submission;

import com.backend.programming.learning.system.course.service.domain.ports.input.service.exam.submission.ExamSubmissionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.course.service.domain.service.exam.submission
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 11:28 PM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class ExamSubmissionApplicationServiceImpl implements ExamSubmissionApplicationService {
    private final ExamSubmissionCreateCommandHandler examSubmissionCreateCommandHandler;
    @Override
    public void submitExam(Long examId) {
        log.info("Submitting exam with id: {}", examId);
        examSubmissionCreateCommandHandler.submitExam(examId);
    }
}
