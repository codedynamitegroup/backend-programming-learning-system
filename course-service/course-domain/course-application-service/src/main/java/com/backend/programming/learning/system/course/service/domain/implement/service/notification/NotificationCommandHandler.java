package com.backend.programming.learning.system.course.service.domain.implement.service.notification;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.notification.DeleteNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.notification.DeleteNotificationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.notification.QueryAllNotificationsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.notification.QueryAllNotificationsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.notification.UpdateNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.notification.UdpateNotificationResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Notification;
import com.backend.programming.learning.system.course.service.domain.mapper.notification.NotificationDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class NotificationCommandHandler {
    private final NotificationCreateHelper notificationCreateHelper;
    private final NotificationQueryHelper notificationQueryHelper;
    private final NotificationDeleteHelper notificationDeleteHelper;
    private final NotificationUpdateHelper notificationUpdateHelper;
    private final NotificationDataMapper notificationDataMapper;

    public NotificationCommandHandler(NotificationCreateHelper notificationCreateHelper,
                                      NotificationQueryHelper notificationQueryHelper,
                                      NotificationDeleteHelper notificationDeleteHelper,
                                      NotificationUpdateHelper notificationUpdateHelper,
                                      NotificationDataMapper notificationDataMapper) {
        this.notificationCreateHelper = notificationCreateHelper;
        this.notificationQueryHelper = notificationQueryHelper;
        this.notificationDeleteHelper = notificationDeleteHelper;
        this.notificationUpdateHelper = notificationUpdateHelper;
        this.notificationDataMapper = notificationDataMapper;
    }

    @Transactional
    public CreateNotificationResponse createNotificationResponse(
            CreateNotificationCommand createNotificationCommand) {
        Notification notification = notificationCreateHelper
                .persistNotification(createNotificationCommand);

        log.info("Notification created with id: {}", notification.getId().getValue());

        return notificationDataMapper.notificationToCreateNotificationResponse(notification,
                "Notification created successfully");
    }

    @Transactional(readOnly = true)
    public QueryAllNotificationsResponse queryAllNotificationsByUserIdTo(
            QueryAllNotificationsCommand queryAllNotificationsCommand) {
        Page<Notification> notifications = notificationQueryHelper
                .queryAllNotificationsByEmail(
                        queryAllNotificationsCommand.getEmail(),
                        queryAllNotificationsCommand.getIsRead(),
                        queryAllNotificationsCommand.getPageNo(),
                        queryAllNotificationsCommand.getPageSize());

        Integer unReadNotifications = notificationQueryHelper
                .countAllUnreadNotificationsByEmail(queryAllNotificationsCommand.getEmail());

        log.info("Returning all notifications: {}", notifications);
        return notificationDataMapper.notificationsToQueryAllNotificationsResponse(
                notifications,
                unReadNotifications);
    }

    @Transactional
    public DeleteNotificationResponse deleteNotification(DeleteNotificationCommand deleteNotificationCommand) {
        notificationDeleteHelper.deleteNotificationById(
                deleteNotificationCommand.getNotificationId());

        return DeleteNotificationResponse.builder()
                .notificationId(deleteNotificationCommand.getNotificationId())
                .message("Notification deleted successfully")
                .build();
    }

    @Transactional
    public UdpateNotificationResponse updateNotification(UpdateNotificationCommand updateNotificationCommand) {
        notificationUpdateHelper.updateNotificationById(
                updateNotificationCommand.getNotificationId(),
                updateNotificationCommand.getRead(),
                updateNotificationCommand.getEmail());

        return UdpateNotificationResponse.builder()
                .notificationId(updateNotificationCommand.getNotificationId())
                .message("Notification marked as read successfully")
                .build();
    }

}
