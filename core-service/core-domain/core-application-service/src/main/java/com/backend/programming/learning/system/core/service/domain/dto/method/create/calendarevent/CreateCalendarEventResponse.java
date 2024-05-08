package com.backend.programming.learning.system.core.service.domain.dto.method.create.calendarevent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateCalendarEventResponse {
    @NotNull
    private final UUID calendarEventId;
    @NotNull
    private final String message;
}
