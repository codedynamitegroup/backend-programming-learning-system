package com.backend.programming.learning.system.core.service.domain.dto.query.notification;

import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllNotificationResponse {
    @NotNull
    private final List<Notification> notifications;
}
