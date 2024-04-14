package com.backend.programming.learning.system.course.service.dataaccess.mapper.exam.submission;

import com.backend.programming.learning.system.course.service.dataaccess.entity.exam.submission.ExamSubmissionEntity;
import com.backend.programming.learning.system.course.service.domain.entity.exam.submission.ExamSubmission;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.mapper.exam.submission
 * Create by Dang Ngoc Tien
 * Date 4/15/2024 - 12:08 AM
 * Description: ...
 */
@Component
public class ExamSubmissionDataAccessMapper {
    public ExamSubmissionEntity examSubmissionToExamSubmissionEntity(ExamSubmission examSubmission) {
        return ExamSubmissionEntity.builder()
                .examId(examSubmission.getExamId())
                .userId(examSubmission.getUserId())
                .type(examSubmission.getType())
                .passStatus(examSubmission.getStatus())
                .build();
    }
}
