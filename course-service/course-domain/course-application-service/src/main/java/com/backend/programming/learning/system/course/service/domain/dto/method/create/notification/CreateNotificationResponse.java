package com.backend.programming.learning.system.course.service.domain.dto.method.create.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateNotificationResponse {
    @NotNull
    private final UUID notificationId;
    @NotNull
    private final String message;
}
