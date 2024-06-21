package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question;

import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import lombok.Builder;

import java.util.List;

@Builder
public record ExamQuestionSubmissionResponse(
        List<QuestionSubmission> questionSubmissions,
        String message) {
}
