package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record ExamQuestionSubmissionCommand(
        UUID examId,
        UUID userId,
        List<QuestionSubmissionCommand> questionSubmissionCommands
) {
}
