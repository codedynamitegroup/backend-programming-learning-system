package com.backend.programming.learning.system.core.service.domain.dto.create.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateNotificationCommand {
    @NotNull
    private final UUID userIdFrom;
    @NotNull
    private final UUID userIdTo;
    @NotNull
    private final String subject;
    @NotNull
    private final String fullMessage;
    @NotNull
    private final String smallMessage;
    @NotNull
    private final String component;
    @NotNull
    private final String eventType;
    @NotNull
    private final String contextUrl;
    @NotNull
    private final String contextUrlName;
}
