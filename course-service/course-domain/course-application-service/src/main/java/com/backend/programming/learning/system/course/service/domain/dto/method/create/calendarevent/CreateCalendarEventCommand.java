package com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.validator.calendarevent.CreateCalendarEventCommandStartTimeAndEndTimeValidator;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@CreateCalendarEventCommandStartTimeAndEndTimeValidator
public class CreateCalendarEventCommand {
    @NotNull(message = "Name is required")
    private final String name;
    @NotNull(message = "Description is required")
    private final String description;
    @NotNull(message = "EventType is required")
    @EnumValidator(enumClass = NotificationEventType.class, message = "EventType is invalid")
    private final String eventType;
    @NotNull(message = "StartTime is required")
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    private final UUID userId;
    private final UUID courseId;
    private final UUID contestId;
    private final UUID examId;
    private final UUID assignmentId;
    @EnumValidator(enumClass = NotificationComponentType.class, message = "Component is invalid")
    private final String component;
}
