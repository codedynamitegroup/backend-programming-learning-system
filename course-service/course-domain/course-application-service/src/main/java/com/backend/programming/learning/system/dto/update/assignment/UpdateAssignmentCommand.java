package com.backend.programming.learning.system.dto.update.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateAssignmentCommand {
    private final UUID assignmentId;
    @NotNull
    private final String title;

    @NotNull
    private final String intro;

    @NotNull
    private final Float score;

    @NotNull
    private final Float maxScore;

    @NotNull
    private final ZonedDateTime timeClose;

    @NotNull
    private final ZonedDateTime timeLimit;

    @NotNull
    private final String type;

    @NotNull
    private final Boolean visible;
}
