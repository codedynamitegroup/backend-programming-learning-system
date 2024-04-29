package com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent;

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
    private String calendarEventId;
    @JsonProperty
    private String name;
    @JsonProperty
    private String description;
    @JsonProperty
    private String eventType;
    @JsonProperty
    private ZonedDateTime startTime;
    @JsonProperty
    private ZonedDateTime endTime;
    @JsonProperty
    private String userId;
    @JsonProperty
    private String contestId;
    @JsonProperty
    private String component;
    @JsonProperty
    private String updateCalendarEventState;
    @JsonProperty
    private ZonedDateTime createdAt;
    @JsonProperty
    private List<String> failureMessages;
}
