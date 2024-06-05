package com.backend.programming.learning.system.course.service.domain.dto.method.query.course_user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCourseByUserCommand {
    @NotNull
    private UUID userId;
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    @NotNull
    private final String search;

    private final String[] courseType;

}
