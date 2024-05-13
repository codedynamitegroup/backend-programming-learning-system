package com.backend.programming.learning.system.core.service.domain.dto.responseentity.calendarevent;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.topic.TopicResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class CalendarEventResponseEntity {
    @NotNull
    private final UUID calendarEventId;
    @NotNull
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final NotificationEventType eventType;
    @NotNull
    private final ZonedDateTime startTime;
    @NotNull
    private final ZonedDateTime endTime;
    @NotNull
    private final UserResponseEntity user;
    private final UUID courseId;
    private final String component;
    @NotNull
    private final ZonedDateTime createdAt;
}
