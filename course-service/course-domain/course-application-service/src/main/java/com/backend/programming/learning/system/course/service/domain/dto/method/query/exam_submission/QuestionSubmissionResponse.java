package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission;

import lombok.Builder;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.exam_submission
 * Create by Dang Ngoc Tien
 * Date 6/5/2024 - 9:45 PM
 * Description: ...
 */
@Builder
public record QuestionSubmissionResponse(
        UUID questionId,
        Integer passStatus,
        Float grade,
        String content,
        String rightAnswer,
        Integer numFile,
        Boolean flag,
        Boolean answerStatus
) { }
