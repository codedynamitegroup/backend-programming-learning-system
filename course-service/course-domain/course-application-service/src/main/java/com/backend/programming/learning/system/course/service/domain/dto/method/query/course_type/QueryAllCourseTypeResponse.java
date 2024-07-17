package com.backend.programming.learning.system.course.service.domain.dto.method.query.course_type;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course_type.CourseTypeResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCourseTypeResponse {
    private final List<CourseTypeResponseEntity> courseTypes;

    private final int currentPage;
    private final long totalItems;
    private final int totalPages;
}
