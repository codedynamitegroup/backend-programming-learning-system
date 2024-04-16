package com.backend.programming.learning.system.core.service.domain.ports.input.service.notification;

import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationResponse;

import javax.validation.Valid;

public interface NotificationApplicationService {
    CreateNotificationResponse createNotificationResponse(
            @Valid CreateNotificationCommand createNotificationCommand);

}
