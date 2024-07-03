package com.backend.programming.learning.system.course.service.domain.dto.method.query.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllNotificationsCommand {
//    @NotNull
//    private final UUID userIdTo;
    private final String email;
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
    private final Boolean isRead;
}
