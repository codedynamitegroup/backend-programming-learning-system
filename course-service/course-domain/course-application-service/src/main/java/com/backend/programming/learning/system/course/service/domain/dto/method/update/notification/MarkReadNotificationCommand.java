package com.backend.programming.learning.system.course.service.domain.dto.method.update.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class MarkReadNotificationCommand {
    @NotNull
    private UUID notificationId;
}
