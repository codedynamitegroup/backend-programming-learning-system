package com.backend.programming.learning.system.course.service.domain.dto.method.query.course_user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.method.query.course_user
 * Create by Dang Ngoc Tien
 * Date 5/20/2024 - 4:44 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class QueryAllCourseUserCommand {
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    @NotNull
    private final String search;
}
