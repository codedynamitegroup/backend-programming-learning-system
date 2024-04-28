package com.backend.programming.learning.system.course.service.domain.implement.service.notification;

import com.backend.programming.learning.system.course.service.domain.entity.Notification;
import com.backend.programming.learning.system.course.service.domain.exception.NotificationNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class NotificationDeleteHelper {
    private final NotificationRepository notificationRepository;

    public NotificationDeleteHelper(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public void deleteNotificationById(UUID notificationId) {
        checkNotification(notificationId);
        notificationRepository.deleteNotificationById(notificationId);
        log.info("Notification with id: {} deleted successfully", notificationId);
    }

    private void checkNotification(UUID notificationId) {
        Optional<Notification> notification = notificationRepository.findById(notificationId);
        if (notification.isEmpty()) {
            log.warn("Could not find notification with id: {}", notificationId);
            throw new NotificationNotFoundException("Could not find notification with id: " + notificationId);
        }
    }
}