package com.backend.programming.learning.system.core.service.domain.dto.method.query.question;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * com.backend.programming.learning.system.core.service.domain.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 5/29/2024 - 2:57 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllQuestionByCategoryIdCommand {
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    @NotNull
    private final String search;
}
