package com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteCalendarEventResponse {
    @NotNull
    private final UUID calendarEventId;
    @NotNull
    private final String message;
}
