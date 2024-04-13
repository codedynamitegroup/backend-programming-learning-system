package com.backend.programming.learning.system.core.service.dataaccess.notification.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.contest_user.entity.ContestUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.notification.entity.NotificationEntity;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestId;
import com.backend.programming.learning.system.core.service.domain.valueobject.ContestUserId;
import com.backend.programming.learning.system.domain.valueobject.NotificationId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class NotificationDataAccessMapper {

    public NotificationEntity notificationToNotificationEntity(Notification notification) {
        return NotificationEntity.builder()
                .id(notification.getId().getValue())
                .build();
    }

    public Notification notificationEntityToNotification(NotificationEntity notificationEntity) {
        return Notification.builder()
                .id(new NotificationId(notificationEntity.getId()))
                .build();
    }
}
