package com.backend.programming.learning.system.course.service.domain.dto.course.get;

import com.backend.programming.learning.system.course.service.domain.entity.course.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.course.get
 * Create by Dang Ngoc Tien
 * Date 4/11/2024 - 12:02 AM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CourseResponse {
    private final List<Course> courses;
    private final String message;
}
