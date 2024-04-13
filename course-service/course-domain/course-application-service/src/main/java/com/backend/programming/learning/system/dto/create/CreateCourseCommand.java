package com.backend.programming.learning.system.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCourseCommand {

    @NotNull
    private final String name;

    @NotNull
    private final String key;

    @NotNull
    private final Boolean visible;

    @NotNull
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;

    @NotNull
    private final UUID createdBy;
    @NotNull
    private final UUID updatedBy;
}
