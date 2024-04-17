package com.backend.programming.learning.system.core.service.domain.ports.input.service.notification;

import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.notification.DeleteNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.notification.DeleteNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.notification.QueryAllNotificationsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.notification.QueryAllNotificationsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.update.notification.MarkReadNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.update.notification.MarkReadNotificationResponse;

import javax.validation.Valid;

public interface NotificationApplicationService {
    CreateNotificationResponse createNotificationResponse(
            @Valid CreateNotificationCommand createNotificationCommand);

    QueryAllNotificationsResponse queryAllNotificationsResponse(
            @Valid QueryAllNotificationsCommand queryAllNotificationsCommand);

    DeleteNotificationResponse deleteNotificationResponse(
            @Valid DeleteNotificationCommand deleteNotificationCommand);

    MarkReadNotificationResponse markReadNotificationResponse(
            @Valid MarkReadNotificationCommand markReadNotificationCommand);

}
