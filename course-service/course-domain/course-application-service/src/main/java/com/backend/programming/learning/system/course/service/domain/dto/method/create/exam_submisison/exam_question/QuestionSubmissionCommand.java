package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record QuestionSubmissionCommand(
        @Schema(example = "c4b3219f-9d83-4497-ad15-d46772141bd5")
        UUID questionId,
        String content,
        List<String> fileUrls,
        Boolean answerStatus,
        Boolean flag) { }
