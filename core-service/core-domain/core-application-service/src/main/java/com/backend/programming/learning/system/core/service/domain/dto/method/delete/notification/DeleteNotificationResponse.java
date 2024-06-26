package com.backend.programming.learning.system.core.service.domain.dto.method.delete.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DeleteNotificationResponse {
    @NotNull
    private final UUID notificationId;
    @NotNull
    private final String message;
}
