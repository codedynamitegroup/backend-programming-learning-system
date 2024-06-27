package com.backend.programming.learning.system.course.service.domain.dto.responseentity.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.assignment.AssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.course.CourseResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.exam.ExamResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationNotifyTime;
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
    private final UUID contestId;
    private final CourseResponseEntity course;
    private final ExamResponseEntity exam;
    private final AssignmentResponseEntity assignment;
    private final NotificationComponentType component;
    private final NotificationNotifyTime notificationNotifyTime;
    @NotNull
    private final ZonedDateTime createdAt;
}
