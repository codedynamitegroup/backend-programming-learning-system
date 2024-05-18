package com.backend.programming.learning.system.course.service.domain.dto.method.query.course_user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryCourseUserCommand {
    @NotNull
    private final UUID courseId;
}
