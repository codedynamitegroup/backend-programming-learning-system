package com.backend.programming.learning.system.course.service.domain.dto.method.query.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.query.post
 * Create by Dang Ngoc Tien
 * Date 4/19/2024 - 1:31 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllPostByCourseIdCommand {
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;

    @NotNull
    private final UUID courseId;
}
