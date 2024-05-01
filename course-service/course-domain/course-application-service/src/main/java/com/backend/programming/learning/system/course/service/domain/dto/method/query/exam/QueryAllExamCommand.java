package com.backend.programming.learning.system.course.service.domain.dto.method.query.exam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * com.backend.programming.learning.system.dto.method.query.exam
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 9:01 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllExamCommand {
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    @NotNull
    private final String search;
}
