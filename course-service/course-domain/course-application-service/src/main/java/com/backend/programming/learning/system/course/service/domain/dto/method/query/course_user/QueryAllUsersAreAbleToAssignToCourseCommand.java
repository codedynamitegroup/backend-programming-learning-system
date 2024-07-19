package com.backend.programming.learning.system.course.service.domain.dto.method.query.course_user;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class QueryAllUsersAreAbleToAssignToCourseCommand {
    @NotNull
    private UUID courseId;

    @NotNull
    private UUID organizationId;

    private final int pageNo;

    private final int pageSize;

    private final String search;
}
