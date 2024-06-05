package com.backend.programming.learning.system.course.service.domain.dto.method.query.course_user;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Builder
@AllArgsConstructor
public class QueryAllCourseByUserResponse {
    private final List<CourseResponseEntity> courses;

    private final int currentPage;
    private final long totalItems;
    private final int totalPages;

}
