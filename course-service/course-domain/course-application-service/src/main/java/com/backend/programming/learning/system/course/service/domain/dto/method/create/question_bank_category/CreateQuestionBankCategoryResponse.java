package com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category;

import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.create.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:17 AM
 * Description: ...
 */
@Builder
public record CreateQuestionBankCategoryResponse(
        UUID id,
        String name,
        String description,
        UUID createdBy,
        UUID updatedBy,
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt,
        String message
) {
}
