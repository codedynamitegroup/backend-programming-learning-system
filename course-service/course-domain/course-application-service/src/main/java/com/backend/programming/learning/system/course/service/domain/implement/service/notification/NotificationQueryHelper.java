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
    public Page<Notification> queryAllNotificationsByEmail(
            String email, Integer pageNo, Integer pageSize
    ) {
        User user = findUserByEmail(email);
        Page<Notification> notifications = notificationRepository.findAllByUserIdTo(
                user.getId().getValue(),
                pageNo,
                pageSize);
        for (Notification notification : notifications) {
            notification.setUserFrom(getUser(notification.getUserFrom().getId().getValue()));
            notification.setUserTo(getUser(notification.getUserTo().getId().getValue()));
        }

        return notifications;
    }

    @Transactional(readOnly = true)
    public Integer countAllUnreadNotificationsByEmail(String email) {
        User user = findUserByEmail(email);
        return notificationRepository.countAllByUserIdToAndIsRead(user.getId().getValue(), false);
    }

    private User findUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email: {} not found", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
    }
}





















