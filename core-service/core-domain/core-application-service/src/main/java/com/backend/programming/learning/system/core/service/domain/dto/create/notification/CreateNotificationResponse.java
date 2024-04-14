package com.backend.programming.learning.system.core.service.domain.dto.create.notification;

import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateNotificationResponse {
    @NotNull
    private final Notification notification;
    @NotNull
    private final String message;
}
