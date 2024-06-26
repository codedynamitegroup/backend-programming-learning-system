package com.backend.programming.learning.system.core.service.domain.dto.method.delete.calendarevent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteCalendarEventCommand {
    @NotNull(message = "calendarEventId is required")
    private final UUID calendarEventId;
}
