package com.backend.programming.learning.system.course.service.domain.dto.method.update.course;

import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.method.delete.update.course
 * Create by Dang Ngoc Tien
 * Date 4/20/2024 - 10:21 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class UpdateCourseResponse {
    private UUID courseId;
    private String name;
    private CourseType courseType;
    private Boolean visible;
    private String message;
}
