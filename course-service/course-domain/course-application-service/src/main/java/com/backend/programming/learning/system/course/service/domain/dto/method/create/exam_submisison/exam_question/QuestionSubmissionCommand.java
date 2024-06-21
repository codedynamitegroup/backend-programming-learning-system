package com.backend.programming.learning.system.course.service.domain.dto.method.create.exam_submisison.exam_question;

import lombok.Builder;

import java.util.UUID;

@Builder
public record QuestionSubmissionCommand(
        UUID questionId,
        String content,
        Integer numFile,
        Boolean answerStatus,
        Boolean flag) { }
