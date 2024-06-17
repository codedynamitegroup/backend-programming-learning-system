package com.backend.programming.learning.system.course.service.domain.dto.method.query.question_bank_category;

import lombok.Builder;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.query.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:18 AM
 * Description: ...
 */
@Builder
public record QueryAllQuestionBankCategoryCommand(
        Boolean isOrgQuestionBank,
        UUID organizationId,
        @NotNull
        Integer pageNo,
        @NotNull
        Integer pageSize,
        @NotNull
        String search
) {
}
