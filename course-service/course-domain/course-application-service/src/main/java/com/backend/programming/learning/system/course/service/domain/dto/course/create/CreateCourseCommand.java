package com.backend.programming.learning.system.course.service.domain.dto.course.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain.dto.course.create
 * Create by Dang Ngoc Tien
 * Date 4/10/2024 - 10:51 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CreateCourseCommand {
//    private Long courseId;
    private String name;
    private Boolean visible;
    private Long createdBy;
//    private Long updatedBy;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
}
