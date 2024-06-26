package com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCalendarEventsCommand {
    private final UUID courseId;
    @NotNull(message = "From time cannot be null")
    private final ZonedDateTime fromTime;
    @NotNull(message = "To time cannot be null")
    private final ZonedDateTime toTime;
    private String email;
}
