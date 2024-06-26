package com.backend.programming.learning.system.course.service.domain.dto.method.query.question_bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;

/**
 * com.backend.programming.learning.system.dto.method.query.question_bank
 * Create by Dang Ngoc Tien
 * Date 4/21/2024 - 4:19 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllQuestionBankCommand {
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    @NotNull
    private final String search;
}
