package com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryCourseTypeCommand {
    @NotNull
    private final UUID organizationId;

    @NotNull
    private final int pageNo;

    @NotNull
    private final int pageSize;

    @NotNull
    private final String searchName;
}
