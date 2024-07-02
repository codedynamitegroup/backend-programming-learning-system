package com.backend.programming.learning.system.course.service.domain.dto.method.update.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UpdateNotificationCommand {
    @NotNull(message = "notificationId is required.")
    private UUID notificationId;
    private Boolean read;
    private String email;
}
