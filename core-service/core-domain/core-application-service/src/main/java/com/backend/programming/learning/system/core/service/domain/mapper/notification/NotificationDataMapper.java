package com.backend.programming.learning.system.core.service.domain.mapper.notification;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.notification.QueryAllNotificationsResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.notification.NotificationResponseEntity;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.user.UserResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.mapper.user.UserDataMapper;
import com.backend.programming.learning.system.core.service.domain.valueobject.NotificationEventType;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class NotificationDataMapper {
    private final UserDataMapper userDataMapper;

    public NotificationDataMapper(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public Notification createNotificationCommandToNotification(
            CreateNotificationCommand createNotificationCommand) {
        User userFrom = createNotificationCommand.getUserIdFrom() != null
                ? User.builder().id(new UserId(createNotificationCommand.getUserIdFrom())).build()
                : null;
        User userTo = User.builder().id(new UserId(createNotificationCommand.getUserIdTo())).build();

        return Notification.builder()
                .userFrom(userFrom)
                .userTo(userTo)
                .subject(createNotificationCommand.getSubject())
                .fullMessage(createNotificationCommand.getFullMessage())
                .smallMessage(createNotificationCommand.getSmallMessage())
                .component(createNotificationCommand.getComponent())
                .eventType(NotificationEventType.valueOf(createNotificationCommand.getEventType()))
                .contextUrl(createNotificationCommand.getContextUrl())
                .contextUrlName(createNotificationCommand.getContextUrlName())
                .isRead(false)
                .build();
    }

    public CreateNotificationResponse notificationToCreateNotificationResponse(
            Notification notification, String message) {
        return CreateNotificationResponse.builder()
                .notificationId(notification.getId().getValue())
                .message(message)
                .build();
    }

    public NotificationResponseEntity notificationToQueryNotificationResponse(Notification notification) {
        UserResponseEntity userFromResponse = notification.getUserFrom() != null
                ? userDataMapper.userToUserResponseEntity(notification.getUserFrom())
                : null;
        UserResponseEntity userToResponse = userDataMapper.userToUserResponseEntity(notification.getUserTo());

        return NotificationResponseEntity.builder()
                .notificationId(notification.getId().getValue())
                .userFrom(userFromResponse)
                .userTo(userToResponse)
                .subject(notification.getSubject())
                .fullMessage(notification.getFullMessage())
                .smallMessage(notification.getSmallMessage())
                .component(notification.getComponent())
                .eventType(notification.getEventType())
                .contextUrl(notification.getContextUrl())
                .contextUrlName(notification.getContextUrlName())
                .isRead(notification.getRead())
                .timeRead(notification.getTimeRead())
                .createdAt(notification.getCreatedAt())
                .updatedAt(notification.getUpdatedAt())
                .build();
    }

    public QueryAllNotificationsResponse notificationsToQueryAllNotificationsResponse(Page<Notification> notifications) {
        return QueryAllNotificationsResponse.builder()
                .notifications(notifications.map(this::notificationToQueryNotificationResponse).getContent())
                .currentPage(notifications.getNumber())
                .totalItems(notifications.getTotalElements())
                .totalPages(notifications.getTotalPages())
                .build();
    }
}
