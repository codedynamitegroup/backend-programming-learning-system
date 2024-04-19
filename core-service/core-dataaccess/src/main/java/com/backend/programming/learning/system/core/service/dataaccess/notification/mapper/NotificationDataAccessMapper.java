package com.backend.programming.learning.system.core.service.dataaccess.notification.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.contest_user.entity.ContestUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.notification.entity.NotificationEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestUserId;
import com.backend.programming.learning.system.domain.valueobject.NotificationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class NotificationDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public NotificationDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public NotificationEntity notificationToNotificationEntity(Notification notification) {
        UserEntity userFrom = notification.getUserFrom() != null
                ? userDataAccessMapper.userToUserEntity(notification.getUserFrom())
                : null;
        UserEntity userTo = userDataAccessMapper.userToUserEntity(notification.getUserTo());
        return NotificationEntity.builder()
                .id(notification.getId().getValue())
                .userFrom(userFrom)
                .userTo(userTo)
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

    public Notification notificationEntityToNotification(NotificationEntity notificationEntity) {
        User userFrom = notificationEntity.getUserFrom() != null
                ? userDataAccessMapper.userEntityToUser(notificationEntity.getUserFrom())
                : null;
        User userTo = userDataAccessMapper.userEntityToUser(notificationEntity.getUserTo());

        return Notification.builder()
                .id(new NotificationId(notificationEntity.getId()))
                .userFrom(userFrom)
                .userTo(userTo)
                .subject(notificationEntity.getSubject())
                .fullMessage(notificationEntity.getFullMessage())
                .smallMessage(notificationEntity.getSmallMessage())
                .component(notificationEntity.getComponent())
                .eventType(notificationEntity.getEventType())
                .contextUrl(notificationEntity.getContextUrl())
                .contextUrlName(notificationEntity.getContextUrlName())
                .isRead(notificationEntity.getIsRead())
                .timeRead(notificationEntity.getTimeRead())
                .createdAt(notificationEntity.getCreatedAt())
                .updatedAt(notificationEntity.getUpdatedAt())
                .build();
    }
}
