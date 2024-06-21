package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question;

import com.backend.programming.learning.system.course.service.domain.entity.QuestionSubmission;
import lombok.Builder;

import java.util.UUID;

@Builder
public record OneExamQuestionSubmissionResponse(
        UUID questionId,
        Float grade,
        String content,
        Boolean flag,
        Boolean answerStatus,
        String message
) {
}
