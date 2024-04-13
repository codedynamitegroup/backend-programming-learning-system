package com.backend.programming.learning.system.course.service.domain.entity.course;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain.entity.course
 * Create by Dang Ngoc Tien
 * Date 4/10/2024 - 10:41 PM
 * Description: ...
 */
@Builder
@Getter
@Setter
public class Course {
    private Long courseId;
    private String name;
    private Boolean visible;
    private Long createdBy;
    private Long updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
