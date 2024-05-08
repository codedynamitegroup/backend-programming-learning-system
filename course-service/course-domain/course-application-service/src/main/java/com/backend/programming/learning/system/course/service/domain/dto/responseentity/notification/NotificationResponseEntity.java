package com.backend.programming.learning.system.course.service.domain.dto.responseentity.notification;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class NotificationResponseEntity {
    @NotNull
    private final UUID notificationId;
    private final UserResponseEntity userFrom;
    @NotNull
    private final UserResponseEntity userTo;
    @NotNull
    private final String subject;
    @NotNull
    private final String fullMessage;
    @NotNull
    private final String smallMessage;
    @NotNull
    private final NotificationComponentType component;
    @NotNull
    private final NotificationEventType eventType;
    private final String contextUrl;
    private final String contextUrlName;
    @NotNull
    private final Boolean isRead;
    private final String timeRead;
    @NotNull
    private final String createdAt;
    @NotNull
    private final String updatedAt;
}
