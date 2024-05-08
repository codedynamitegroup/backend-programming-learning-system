package com.backend.programming.learning.system.course.service.domain.dto.method.query.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryNotificationCommand {
    @NotNull
    private final UUID userIdTo;
}
