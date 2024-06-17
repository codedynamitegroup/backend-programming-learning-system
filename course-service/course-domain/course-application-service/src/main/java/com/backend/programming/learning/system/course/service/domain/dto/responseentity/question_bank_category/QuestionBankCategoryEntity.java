package com.backend.programming.learning.system.course.service.domain.dto.responseentity.question_bank_category;

import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.responseentity.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:21 AM
 * Description: ...
 */
@Builder
public record QuestionBankCategoryEntity(
        UUID id,
        String name,
        String description,
        UUID organizationId,
        String organizationName,
        UUID createdBy,
        String createdByName,
        UUID updatedBy,
        String updatedByName,
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt
) {
}
