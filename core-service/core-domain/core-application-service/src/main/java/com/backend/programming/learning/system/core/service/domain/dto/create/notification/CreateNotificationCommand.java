package com.backend.programming.learning.system.core.service.domain.dto.create.notification;

import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateNotificationCommand {
    private final UUID userIdFrom;
    @NotNull
    private final UUID userIdTo;
    @NotNull
    private final String subject;
    @NotNull
    private final String fullMessage;
    @NotNull
    private final String smallMessage;
    private final String component;
    @NotNull
    private final NotificationEventType eventType;
    private final String contextUrl;
    private final String contextUrlName;
}
