package com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent;

import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CalendarEventUpdateEventPayload {
    @JsonProperty
    private CalendarEvent calendarEvent;
    @JsonProperty
    private String updateCalendarEventState;
    @JsonProperty
    private ZonedDateTime createdAt;
    @JsonProperty
    private List<String> failureMessages;
}
