package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Notification;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotificationRepository {
    Notification saveNotification(Notification notification);
    Page<Notification> findAllByUserIdTo(
            UUID userIdTo, Integer pageNo, Integer pageSize);
    Optional<Notification> findById(UUID notificationId);
    void deleteNotificationById(UUID notificationId);
    int markReadNotificationById(UUID notificationId);
    int updateNotificationById(UUID notificationId, Boolean read);
    List<Notification> saveAllNotifications(List<Notification> notifications);
    Integer countAllByUserIdToAndIsRead(UUID userIdTo, boolean isRead);
}
