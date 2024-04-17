package com.backend.programming.learning.system.dto.method.query.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * com.backend.programming.learning.system.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 2:23 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllQuestionCommand {
    @NotNull
    private int pageNo;
    @NotNull
    private int pageSize;
}
