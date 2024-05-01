package com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCalendarEventsCommand {
    @NotNull
    private final ZonedDateTime fromTime;
    @NotNull
    private final ZonedDateTime toTime;
}
