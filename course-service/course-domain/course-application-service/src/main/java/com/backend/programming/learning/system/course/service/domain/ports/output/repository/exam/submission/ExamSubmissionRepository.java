package com.backend.programming.learning.system.course.service.domain.ports.output.repository.exam.submission;

import com.backend.programming.learning.system.course.service.domain.entity.exam.submission.ExamSubmission;

/**
 * com.backend.programming.learning.system.course.service.domain.ports.output.repository.exam.submission
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 11:38 PM
 * Description: ...
 */
public interface ExamSubmissionRepository {
    void createExamSubmission(ExamSubmission examSubmission);
}
