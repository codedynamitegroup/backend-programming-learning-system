package com.backend.programming.learning.system.core.service.domain.dto.method.message.contest_user;

import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ContestUserCalendarEventUpdatedResponse {
    private String id;
    private String sagaId;
    private String calendarEventId;
    private String userId;
    private String courseId;
    private String contestId;
    private String name;
    private String description;
    private NotificationEventType eventType;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private NotificationComponentType component;
    private UpdateState updateCalendarEventState;
    private List<String> failureMessages;
}
