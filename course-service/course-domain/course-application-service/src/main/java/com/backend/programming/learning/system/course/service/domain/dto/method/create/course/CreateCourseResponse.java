package com.backend.programming.learning.system.course.service.domain.dto.method.create.course;

import com.backend.programming.learning.system.course.service.domain.entity.CourseType;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
public record CreateCourseResponse(
        UUID id,
        String name,
        CourseType courseType,
        Boolean visible,
        UserId createdBy,
        ZonedDateTime createdAt,
        @NotNull
        String message
) {
}
