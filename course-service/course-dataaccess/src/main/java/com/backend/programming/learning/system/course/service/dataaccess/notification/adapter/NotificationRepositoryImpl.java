package com.backend.programming.learning.system.course.service.dataaccess.notification.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.notification.entity.NotificationEntity;
import com.backend.programming.learning.system.course.service.dataaccess.notification.mapper.NotificationDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.notification.repository.NotificationJpaRepository;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Notification;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
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
    public Page<Notification> findAllByUserIdToAndIsRead(UUID userIdTo, Boolean isRead, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(
                pageNo,
                pageSize
        );
        return notificationJpaRepository.findAllByUserIdToAndIsRead(
                userIdTo,
                        isRead,
                        paging)
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
        return notificationJpaRepository.markReadNotificationById(
                true,
                ZonedDateTime.now(ZoneId.of("UTC")),
                notificationId);
    }

    @Override
    public int updateNotificationById(UUID notificationId, Boolean read) {
        return notificationJpaRepository.markReadNotificationById(
                read,
                ZonedDateTime.now(ZoneId.of("UTC")),
                notificationId);
    }

    @Override
    public List<Notification> saveAllNotifications(List<Notification> notifications) {
        List<NotificationEntity> notificationEntities = new ArrayList<>();
        Iterable<NotificationEntity> notificationEntitiesIterable = notificationJpaRepository.saveAll(
                        notificationDataAccessMapper.notificationListToNotificationEntityList(notifications));
        notificationEntitiesIterable.forEach(notificationEntities::add);
        return notificationDataAccessMapper.notificationEntityListToNotificationList(notificationEntities);
    }

    @Override
    public Integer countAllByUserIdToAndIsRead(UUID userIdTo, boolean isRead) {
        return notificationJpaRepository.countAllByUserIdToAndIsRead(userIdTo, isRead);
    }
}
