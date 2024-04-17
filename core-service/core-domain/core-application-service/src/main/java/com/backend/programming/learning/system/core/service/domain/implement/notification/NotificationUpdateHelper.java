package com.backend.programming.learning.system.core.service.domain.implement.notification;

import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.NotificationNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.ReviewNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class NotificationUpdateHelper {
    private final NotificationRepository notificationRepository;

    public NotificationUpdateHelper(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public void markReadNotificationById(UUID notificationId) {
        Notification notification = getNotification(notificationId);
        if (notification.getRead()) {
            log.warn("Notification with id: {} is already read", notificationId);
            throw new CoreDomainException("Notification with id: " + notificationId + " is already read");
        }
        int updatedRows = notificationRepository.markReadNotificationById(notificationId);
        if (updatedRows == 0) {
            log.warn("Could not mark notification with id: {} as read", notificationId);
            throw new NotificationNotFoundException("Could not mark notification with id: " +
                    notificationId + " as read");
        }
        log.info("Notification with id: {} marked as read", notificationId);
    }

    private Notification getNotification(UUID notificationId) {
        Optional<Notification> notification = notificationRepository.findById(notificationId);
        if (notification.isEmpty()) {
            log.warn("Could not find notification with id: {}", notificationId);
            throw new ReviewNotFoundException("Could not find notification with id: " + notificationId);
        }
        return notification.get();
    }
}