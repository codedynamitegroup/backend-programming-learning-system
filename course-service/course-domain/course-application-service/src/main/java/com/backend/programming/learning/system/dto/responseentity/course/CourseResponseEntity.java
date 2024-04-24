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

@Builder
public record CourseResponseEntity(
        UUID id,
        String name,
        String courseType,
        Boolean visible,
        UserId createdBy,
        UserId updatedBy,
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt
) {
}
