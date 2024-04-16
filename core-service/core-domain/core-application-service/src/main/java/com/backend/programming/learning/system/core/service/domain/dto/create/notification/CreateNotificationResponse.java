package com.backend.programming.learning.system.core.service.domain.dto.create.notification;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import com.backend.programming.learning.system.domain.valueobject.NotificationId;
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
