package com.backend.programming.learning.system.dto.method.query.course;

import com.backend.programming.learning.system.dto.responseentity.course.CourseResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCourseResponse {
    private final List<CourseResponseEntity> courses;

    private final int currentPage;
    private final long totalItems;
    private final int totalPages;
}
