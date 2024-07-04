package com.backend.programming.learning.system.course.service.domain.dto.method.query.rubric_user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.query.question
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 2:23 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllRubricsByUserIdCommand {
    private final UUID userId;
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    @NotNull
    private final String search;
}
