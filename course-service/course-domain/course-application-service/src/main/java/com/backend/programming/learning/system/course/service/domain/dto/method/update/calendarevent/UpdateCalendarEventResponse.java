package com.backend.programming.learning.system.course.service.domain.dto.method.update.calendarevent;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateCalendarEventResponse {
    @NotNull
    private final UUID calendarEventId;
    @NotNull
    private final String message;
}
