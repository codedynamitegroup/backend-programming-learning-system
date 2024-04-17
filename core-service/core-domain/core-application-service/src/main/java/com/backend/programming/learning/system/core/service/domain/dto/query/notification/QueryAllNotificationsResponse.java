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
public class QueryAllNotificationsResponse {
    @NotNull
    private final List<QueryNotificationResponse> notifications;
    @NotNull
    private final int currentPage;
    @NotNull
    private final long totalItems;
    @NotNull
    private final int totalPages;
}
