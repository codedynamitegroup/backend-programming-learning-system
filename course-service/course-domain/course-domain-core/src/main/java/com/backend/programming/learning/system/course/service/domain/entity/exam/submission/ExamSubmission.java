package com.backend.programming.learning.system.course.service.domain.entity.exam.submission;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * com.backend.programming.learning.system.course.service.domain.entity.exam.submission
 * Create by Dang Ngoc Tien
 * Date 4/14/2024 - 11:55 PM
 * Description: ...
 */
@Getter
@Setter
@Builder
public class ExamSubmission {
    private Long examSubmissionId;
    private Long examId;
    private Long userId;
    private Long type; // sau sẽ chuyển sang enum
    private Long status; // sau sẽ chuyển sang enum
}
