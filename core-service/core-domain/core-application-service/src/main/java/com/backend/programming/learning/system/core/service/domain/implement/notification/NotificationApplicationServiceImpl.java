package com.backend.programming.learning.system.core.service.domain.implement.notification;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.notification.DeleteNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.notification.DeleteNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.notification.QueryAllNotificationsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.notification.QueryAllNotificationsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.update.notification.MarkReadNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.update.notification.MarkReadNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.notification.NotificationApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
class NotificationApplicationServiceImpl implements NotificationApplicationService {
    private final NotificationCommandHandler notificationCommandHandler;

    public NotificationApplicationServiceImpl(NotificationCommandHandler notificationCommandHandler) {
        this.notificationCommandHandler = notificationCommandHandler;
    }

    @Override
    public CreateNotificationResponse createNotificationResponse(CreateNotificationCommand createNotificationCommand) {
        return notificationCommandHandler.createNotificationResponse(createNotificationCommand);
    }

    @Override
    public QueryAllNotificationsResponse queryAllNotificationsResponse(QueryAllNotificationsCommand queryAllNotificationsCommand) {
        return notificationCommandHandler.queryAllNotificationsByUserIdTo(queryAllNotificationsCommand);
    }

    @Override
    public DeleteNotificationResponse deleteNotificationResponse(DeleteNotificationCommand deleteNotificationCommand) {
        return notificationCommandHandler.deleteNotification(deleteNotificationCommand);
    }

    @Override
    public MarkReadNotificationResponse markReadNotificationResponse(MarkReadNotificationCommand markReadNotificationCommand) {
        return notificationCommandHandler.markReadNotification(markReadNotificationCommand);
    }
}
