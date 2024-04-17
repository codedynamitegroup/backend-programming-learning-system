package com.backend.programming.learning.system.core.service.domain.dto.responseentity.notification;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class NotificationResponseEntity {
    @NotNull
    private final UUID notificationId;
    @NotNull
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
    private final String component;
    @NotNull
    private final NotificationEventType eventType;
    @NotNull
    private final String contextUrl;
    @NotNull
    private final String contextUrlName;
    @NotNull
    private final Boolean isRead;
    @NotNull
    private final ZonedDateTime timeRead;
    @NotNull
    private final ZonedDateTime createdAt;
    @NotNull
    private final ZonedDateTime updatedAt;
}