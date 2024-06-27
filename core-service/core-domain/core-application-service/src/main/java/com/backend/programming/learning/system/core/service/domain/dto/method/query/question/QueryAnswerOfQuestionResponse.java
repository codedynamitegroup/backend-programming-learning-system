package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import lombok.Builder;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.core.service.domain.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 6/27/2024 - 10:46 AM
 * Description: ...
 */
@Builder
public record QueryAnswerOfQuestionResponse(
        UUID answerId,
        UUID questionId,
        String feedback,
        String answer,
        Float fraction
) {
}
