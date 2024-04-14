package com.backend.programming.learning.system.core.service.dataaccess.notification.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.contest_user.mapper.ContestUserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest_user.repository.ContestUserJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.notification.mapper.NotificationDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.notification.repository.NotificationJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.NotificationRepository;
import org.springframework.stereotype.Component;

@Component
public class NotificationRepositoryImpl implements NotificationRepository {
    private final NotificationJpaRepository notificationJpaRepository;
    private final NotificationDataAccessMapper notificationDataAccessMapper;

    public NotificationRepositoryImpl(NotificationJpaRepository notificationJpaRepository,
                                      NotificationDataAccessMapper notificationDataAccessMapper) {
        this.notificationJpaRepository = notificationJpaRepository;
        this.notificationDataAccessMapper = notificationDataAccessMapper;
    }

    @Override
    public Notification saveNotification(Notification notification) {
        return notificationDataAccessMapper.notificationEntityToNotification(
                notificationJpaRepository
                        .save(notificationDataAccessMapper
                                .notificationToNotificationEntity(notification)));
    }
}
