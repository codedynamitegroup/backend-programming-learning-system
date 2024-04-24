package com.backend.programming.learning.system.dto.responseentity.course;

import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.dto.responseentity.course
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 8:09 PM
 * Description: ...
 */
@Getter
@Builder
@AllArgsConstructor
public class CourseResponseEntity {
    private UUID id;
    private String name;
    private Boolean visible;
    private UserId createdBy;
    private UserId updatedBy;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
