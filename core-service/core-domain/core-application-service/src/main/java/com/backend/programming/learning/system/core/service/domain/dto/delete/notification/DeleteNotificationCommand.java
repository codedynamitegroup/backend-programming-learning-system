package com.backend.programming.learning.system.core.service.domain.dto.delete.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteNotificationCommand {
    @NotNull(message = "Notification ID is required")
    private final UUID notificationId;
}
