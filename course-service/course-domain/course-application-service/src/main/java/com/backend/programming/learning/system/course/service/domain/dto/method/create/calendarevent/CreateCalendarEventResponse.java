package com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
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
