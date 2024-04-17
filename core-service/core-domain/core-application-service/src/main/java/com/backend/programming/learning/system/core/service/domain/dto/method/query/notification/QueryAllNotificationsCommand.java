package com.backend.programming.learning.system.core.service.domain.dto.method.query.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class QueryAllNotificationsCommand {
    @NotNull
    private final UUID userIdTo;
    @NotNull
    private final int pageNo;
    @NotNull
    private final int pageSize;
}
