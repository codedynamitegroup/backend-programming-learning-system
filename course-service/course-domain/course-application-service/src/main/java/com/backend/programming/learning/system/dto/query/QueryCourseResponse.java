package com.backend.programming.learning.system.dto.query;

import com.backend.programming.learning.system.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class QueryCourseResponse {
    @NotNull
    private final Course course;
    @NotNull
    private final String message;
}
