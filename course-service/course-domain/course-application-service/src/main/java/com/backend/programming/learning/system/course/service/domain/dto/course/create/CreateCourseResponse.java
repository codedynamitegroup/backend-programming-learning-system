package com.backend.programming.learning.system.course.service.domain.dto.course.create;

import com.backend.programming.learning.system.course.service.domain.entity.course.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.course.create
 * Create by Dang Ngoc Tien
 * Date 4/10/2024 - 10:48 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CreateCourseResponse {
    private final Course course;
    private final String message;
}
