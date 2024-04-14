package com.backend.programming.learning.system.course.service.domain.mapper.exam.submission;

import com.backend.programming.learning.system.course.service.domain.entity.exam.submission.ExamSubmission;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.course.service.domain.mapper.exam.submission
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 11:17 PM
 * Description: ...
 */
@Component
public class ExamSubmissionDataMapper {
    public ExamSubmission createExamSubmission(Long examId) {
        return ExamSubmission.builder()
                .examId(examId)
                .userId(1L) // chưa rõ nghiệp vụ nên mock
                .type(1L) // chưa rõ nghiệp vụ nên mock
                .status(1L) // chưa rõ nghiệp vụ nên mock
                .build();
    }
}
