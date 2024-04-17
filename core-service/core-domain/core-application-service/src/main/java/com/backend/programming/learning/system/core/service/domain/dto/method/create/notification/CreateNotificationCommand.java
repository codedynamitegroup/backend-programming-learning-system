package com.backend.programming.learning.system.core.service.domain.dto.method.create.notification;

import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
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
    @NotNull(message = "userIdTo is required")
    private final UUID userIdTo;
    @NotNull(message = "subject is required")
    private final String subject;
    @NotNull(message = "fullMessage is required")
    private final String fullMessage;
    @NotNull(message = "smallMessage is required")
    private final String smallMessage;
    private final String component;

    @NotNull(message = "eventType is required")
    @EnumValidator(enumClass = NotificationEventType.class, message = "eventType is invalid")
    private final String eventType;

    private final String contextUrl;
    private final String contextUrlName;
}
