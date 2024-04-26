package com.backend.programming.learning.system.core.service.domain.dto.method.message;

import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.core.service.domain.valueobject.UpdateState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CalendarEventResponse {
    private String id;
    private String sagaId;
    private String userId;
    private String courseId;
    private String name;
    private String description;
    private NotificationEventType eventType;
    private String startTime;
    private String endTime;
    private NotificationComponentType component;
    private UpdateState updateState;
    private List<String> failureMessages;

}
