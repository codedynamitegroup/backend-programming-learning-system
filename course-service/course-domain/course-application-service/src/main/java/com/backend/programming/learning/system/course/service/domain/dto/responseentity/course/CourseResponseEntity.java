package com.backend.programming.learning.system.course.service.domain.dto.responseentity.course;

import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
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
        Integer courseIdMoodle,

        Organization organization,
        String name,
        CourseType courseType,
        Boolean visible,
        UserId createdBy,
        UserId updatedBy,
        ZonedDateTime createdAt,
        ZonedDateTime updatedAt
) {
}
