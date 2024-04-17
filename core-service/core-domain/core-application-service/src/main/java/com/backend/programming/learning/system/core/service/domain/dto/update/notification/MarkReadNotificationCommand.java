package com.backend.programming.learning.system.core.service.domain.dto.update.notification;

import com.backend.programming.learning.system.core.service.domain.valueobject.SkillLevel;
import com.backend.programming.learning.system.dataaccess.validator.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class MarkReadNotificationCommand {
    @NotNull
    private UUID notificationId;
}
