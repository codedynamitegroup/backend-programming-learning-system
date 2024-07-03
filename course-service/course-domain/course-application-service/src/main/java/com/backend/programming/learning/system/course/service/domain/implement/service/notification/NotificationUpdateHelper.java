package com.backend.programming.learning.system.course.service.domain.implement.service.notification;

import com.backend.programming.learning.system.course.service.domain.entity.Notification;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.exception.NotificationNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.NotificationRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class NotificationUpdateHelper {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationUpdateHelper(NotificationRepository notificationRepository,
                                    UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

//    @Transactional
//    public void markReadNotificationById(UUID notificationId,
//                                            String email) {
//        User user = getUserByEmail(email);
//        Notification notification = getNotification(notificationId);
//        if (!notification.getUserTo().getId().equals(user.getId())) {
//            log.warn("Notification with id: {} does not belong to user with email: {}", notificationId, email);
//            throw new CourseDomainException("Notification with id: " +
//                    notificationId + " does not belong to user with email: " + email);
//        }
//
//        if (notification.getRead()) {
//            return;
//        }
//        int updatedRows = notificationRepository.markReadNotificationById(notificationId);
//        if (updatedRows == 0) {
//            log.warn("Could not mark notification with id: {} as read", notificationId);
//            throw new NotificationNotFoundException("Could not mark notification with id: " +
//                    notificationId + " as read");
//        }
//        log.info("Notification with id: {} marked as read", notificationId);
//    }

    @Transactional
    public void updateNotificationById(UUID notificationId,
                                         Boolean read,
                                         String email) {
        User user = getUserByEmail(email);
        Notification notification = getNotification(notificationId);
        if (!notification.getUserTo().getId().equals(user.getId())) {
            log.warn("Notification with id: {} does not belong to user with email: {}", notificationId, email);
            throw new CourseDomainException("Notification with id: " +
                    notificationId + " does not belong to user with email: " + email);
        }

        if (read == notification.getRead()) {
            return;
        }
        int updatedRows = notificationRepository.updateNotificationById(notificationId, read);
        if (updatedRows == 0) {
            log.warn("Could not update notification with id: {} ", notificationId);
            throw new NotificationNotFoundException("Could not update notification with id: " +
                    notificationId );
        }
        log.info("Notification with id: {} updated", notificationId);
    }

    private User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            log.warn("Could not find user with email: {}", email);
            throw new CourseDomainException("Could not find user with email: " + email);
        }
        return user.get();
    }

    private Notification getNotification(UUID notificationId) {
        Optional<Notification> notification = notificationRepository.findById(notificationId);
        if (notification.isEmpty()) {
            log.warn("Could not find notification with id: {}", notificationId);
            throw new NotificationNotFoundException("Could not find notification with id: " + notificationId);
        }
        return notification.get();
    }
}