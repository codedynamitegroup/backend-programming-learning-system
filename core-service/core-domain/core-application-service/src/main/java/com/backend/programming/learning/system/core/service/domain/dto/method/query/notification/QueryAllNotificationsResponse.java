package com.backend.programming.learning.system.core.service.domain.dto.method.query.notification;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.notification.NotificationResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllNotificationsResponse {
    @NotNull
    private final List<NotificationResponseEntity> notifications;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
