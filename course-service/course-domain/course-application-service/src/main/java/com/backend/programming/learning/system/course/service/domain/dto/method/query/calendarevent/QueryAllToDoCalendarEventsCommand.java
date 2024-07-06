package com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllToDoCalendarEventsCommand {
    private final UUID courseId;
}
