package com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent;

import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CalendarEventUpdateRequest {
    private String id;
    private String sagaId;
    private String userId;
    private String contestId;
    private String courseId;
    private String name;
    private String description;
    private NotificationEventType eventType;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private NotificationComponentType component;
    private UpdateState updateCalendarEventState;
}
