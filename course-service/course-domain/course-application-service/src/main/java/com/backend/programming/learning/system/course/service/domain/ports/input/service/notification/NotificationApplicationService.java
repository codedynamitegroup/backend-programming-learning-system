package com.backend.programming.learning.system.course.service.domain.ports.input.service.notification;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.notification.DeleteNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.notification.DeleteNotificationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.notification.QueryAllNotificationsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.notification.QueryAllNotificationsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.notification.UpdateNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.notification.UdpateNotificationResponse;

import jakarta.validation.Valid;

public interface NotificationApplicationService {
    CreateNotificationResponse createNotificationResponse(
            @Valid CreateNotificationCommand createNotificationCommand);

    QueryAllNotificationsResponse queryAllNotificationsResponse(
            @Valid QueryAllNotificationsCommand queryAllNotificationsCommand);

    DeleteNotificationResponse deleteNotificationResponse(
            @Valid DeleteNotificationCommand deleteNotificationCommand);

    UdpateNotificationResponse updateNotificationResponse(
            @Valid UpdateNotificationCommand updateNotificationCommand);

}
