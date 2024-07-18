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

        @NotNull
        String message
) {
}
