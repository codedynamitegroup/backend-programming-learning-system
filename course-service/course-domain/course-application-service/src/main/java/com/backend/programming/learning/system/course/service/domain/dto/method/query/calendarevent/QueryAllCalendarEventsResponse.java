package com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.calendarevent.CalendarEventResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCalendarEventsResponse {
    @NotNull
    private final List<CalendarEventResponseEntity> calendarEvents;
}
