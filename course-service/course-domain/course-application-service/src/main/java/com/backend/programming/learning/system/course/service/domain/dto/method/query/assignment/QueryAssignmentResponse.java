package com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAssignmentResponse {

    @NotNull
    private final UUID assignmentId;

    @NotNull
    private final UUID courseId;

    @NotNull
    private final String title;

    @NotNull
    private final String intro;

    @NotNull
    private final Float score;

    @NotNull
    private final Float maxScore;

    @NotNull
    private final ZonedDateTime timeOpen;

    @NotNull
    private final ZonedDateTime timeClose;

    @NotNull
    private final ZonedDateTime timeLimit;

    @NotNull
    private final String type;

    @NotNull
    private final Boolean visible;
}
