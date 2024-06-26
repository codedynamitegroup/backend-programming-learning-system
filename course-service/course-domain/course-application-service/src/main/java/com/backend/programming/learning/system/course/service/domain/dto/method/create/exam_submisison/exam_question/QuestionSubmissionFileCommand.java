package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question;

import lombok.Builder;

@Builder
public record QuestionSubmissionFileCommand(
        String fileUrl,
        String fileName,
        String fileType,
        Float fileSize
) {
}
