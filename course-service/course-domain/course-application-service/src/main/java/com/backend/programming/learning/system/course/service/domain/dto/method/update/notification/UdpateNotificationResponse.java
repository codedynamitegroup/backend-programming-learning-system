package com.backend.programming.learning.system.course.service.domain.dto.method.update.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UdpateNotificationResponse {
    @NotNull
    private final UUID notificationId;
    @NotNull
    private final String message;
}
