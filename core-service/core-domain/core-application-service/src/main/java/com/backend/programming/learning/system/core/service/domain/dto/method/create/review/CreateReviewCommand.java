package com.backend.programming.learning.system.core.service.domain.dto.method.create.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateReviewCommand {
    @NotNull(message = "certificateCourseId is required")
    private final UUID certificateCourseId;
    @NotNull(message = "rating is required")
    @Min(0)
    @Max(5)
    private final Float rating;
    @NotNull(message = "content is required")
    private final String content;
    @NotNull(message = "createdBy is required")
    private final UUID createdBy;
    @NotNull(message = "updatedBy is required")
    private final UUID updatedBy;
}
