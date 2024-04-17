package com.backend.programming.learning.system.core.service.dataaccess.notification.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.contest_user.mapper.ContestUserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.contest_user.repository.ContestUserJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.notification.mapper.NotificationDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.notification.repository.NotificationJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ContestUser;
import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestUserRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Page<Notification> findAllByUserIdTo(UUID userIdTo, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return notificationJpaRepository.findAllByUserIdTo(userIdTo, paging)
                .map(notificationDataAccessMapper::notificationEntityToNotification);
    }

    @Override
    public Optional<Notification> findById(UUID notificationId) {
        return notificationJpaRepository.findById(notificationId)
                .map(notificationDataAccessMapper::notificationEntityToNotification);
    }

    @Override
    public void deleteNotificationById(UUID notificationId) {
        notificationJpaRepository.deleteById(notificationId);
    }

    @Override
    public int markReadNotificationById(UUID notificationId) {
        return notificationJpaRepository.markReadNotificationById(true, notificationId);
    }
}
