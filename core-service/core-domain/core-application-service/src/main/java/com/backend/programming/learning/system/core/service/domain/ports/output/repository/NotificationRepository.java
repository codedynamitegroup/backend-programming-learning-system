package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface NotificationRepository {
    Notification saveNotification(Notification notification);
    Page<Notification> findAllByUserIdTo(
            UUID userIdTo, Integer pageNo, Integer pageSize);
    Optional<Notification> findById(UUID notificationId);
    void deleteNotificationById(UUID notificationId);
    int markReadNotificationById(UUID notificationId);
}
