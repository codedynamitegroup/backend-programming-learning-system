package com.backend.programming.learning.system.core.service.domain.implement.notification;

import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.notification.DeleteNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.delete.notification.DeleteNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.dto.delete.topic.DeleteTopicResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.notification.QueryAllNotificationsCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.notification.QueryAllNotificationsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.update.notification.MarkReadNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.update.notification.MarkReadNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.implement.contest.ContestCreateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.contest.ContestDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.notification.NotificationDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.notification.NotificationApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        log.info("Querying all notifications by user id to: {}", queryAllNotificationsCommand.getUserIdTo());
        Page<Notification> notifications = notificationQueryHelper
                .queryAllNotificationsByUserIdTo(
                        queryAllNotificationsCommand.getUserIdTo(),
                        queryAllNotificationsCommand.getPageNo(),
                        queryAllNotificationsCommand.getPageSize());
        log.info("Returning all notifications: {}", notifications);

        return notificationDataMapper.notificationsToQueryAllNotificationsResponse(notifications);
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
    public MarkReadNotificationResponse markReadNotification(MarkReadNotificationCommand markReadNotificationCommand) {
        notificationUpdateHelper.markReadNotificationById(
                markReadNotificationCommand.getNotificationId());

        return MarkReadNotificationResponse.builder()
                .notificationId(markReadNotificationCommand.getNotificationId())
                .message("Notification marked as read successfully")
                .build();
    }

}
