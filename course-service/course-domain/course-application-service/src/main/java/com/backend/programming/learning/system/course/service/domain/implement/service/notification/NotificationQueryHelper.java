package com.backend.programming.learning.system.course.service.domain.implement.service.notification;

import com.backend.programming.learning.system.course.service.domain.entity.Notification;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.NotificationRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class NotificationQueryHelper {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationQueryHelper(NotificationRepository notificationRepository,
                                   UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }


    @Transactional(readOnly = true)
    public Page<Notification> queryAllNotificationsByUserIdTo(
            UUID userIdTo, Integer pageNo, Integer pageSize
    ) {
        Page<Notification> notifications = notificationRepository.findAllByUserIdTo(userIdTo, pageNo, pageSize);
        for (Notification notification : notifications) {
            notification.setUserFrom(getUser(notification.getUserFrom().getId().getValue()));
            notification.setUserTo(getUser(notification.getUserTo().getId().getValue()));
        }

        return notifications;
    }
}





















