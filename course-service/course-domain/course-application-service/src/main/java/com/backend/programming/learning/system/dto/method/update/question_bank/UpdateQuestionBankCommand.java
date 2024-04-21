package com.backend.programming.learning.system.dto.method.update.question_bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * com.backend.programming.learning.system.dto.method.update.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 4:37 PM
 * Description: ...
 */
public record UpdateQuestionBankCommand(
        @NotNull(message = "Question bank name is required")
        String name
) {
}
