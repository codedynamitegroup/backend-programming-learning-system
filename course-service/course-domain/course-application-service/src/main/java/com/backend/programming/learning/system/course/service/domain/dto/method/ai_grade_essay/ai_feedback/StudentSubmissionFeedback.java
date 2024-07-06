package com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay.ai_feedback;

import lombok.Data;

@Data
public class StudentSubmissionFeedback {
    private String studentSubmissionId;
    private String feedback;
    private Float score_overall;
}
