package com.backend.programming.learning.system.core.service.domain.implement.notification;

import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.notification.DeleteNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.notification.DeleteNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.notification.QueryAllNotificationsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.notification.QueryAllNotificationsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.update.notification.MarkReadNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.update.notification.MarkReadNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.implement.contest.ContestCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest.ContestApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.notification.NotificationApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

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
