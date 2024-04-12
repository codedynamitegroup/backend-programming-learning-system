package com.backend.programming.learning.system.core.service.domain.dto.create;

import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCertificateCourseCommand {
    @NotNull
    private final String name;
    @NotNull
    private final SkillLevel skillLevel;
    @NotNull
    private final Float avgRating;
    @NotNull
    private final UUID topicId;

    @NotNull
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;

    @NotNull
    private final UUID createdBy;
    @NotNull
    private final UUID updatedBy;

    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
}
