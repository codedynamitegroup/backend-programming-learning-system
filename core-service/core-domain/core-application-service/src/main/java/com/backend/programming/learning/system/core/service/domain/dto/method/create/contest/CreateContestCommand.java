package com.backend.programming.learning.system.core.service.domain.dto.method.create.contest;

import com.backend.programming.learning.system.core.service.domain.dto.validator.contest.CreateContestCommandStartTimeAndEndTimeValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@CreateContestCommandStartTimeAndEndTimeValidator
public class CreateContestCommand {
    @NotNull(message = "Name is required")
    private final String name;
    private final UUID orgId;
    private final String description;
    private final String prizes;
    private final String rules;
    private final String scoring;
    private final String thumbnailUrl;
    @NotNull(message = "Start time is required")
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    private final String email;
}
