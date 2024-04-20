package com.backend.programming.learning.system.dto.method.create.course;

import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCourseResponse {
    private UUID id;
    private String name;
    private Boolean visible;
    private UserId createdBy;
    private ZonedDateTime createdAt;
    @NotNull
    private final String message;
}
