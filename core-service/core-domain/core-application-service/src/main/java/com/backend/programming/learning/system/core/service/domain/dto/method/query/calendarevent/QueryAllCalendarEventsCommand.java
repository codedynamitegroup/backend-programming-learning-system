package com.backend.programming.learning.system.core.service.domain.dto.method.query.calendarevent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllCalendarEventsCommand {
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
}
