package com.backend.programming.learning.system.course.service.domain.implement.notification;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.notification.NotificationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Notification;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.notification.NotificationDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.NotificationRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.socket.emitter.message.NotificationMessageEmitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class NotificationCreateHelper {
    private final CourseDomainService courseDomainService;
    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;
    private final NotificationDataMapper notificationDataMapper;
    private final NotificationMessageEmitter<NotificationResponseEntity> notificationMessageEmitter;

    public NotificationCreateHelper(CourseDomainService courseDomainService,
                                    UserRepository userRepository,
                                    NotificationRepository notificationRepository,
                                    NotificationDataMapper notificationDataMapper,
                                    NotificationMessageEmitter<NotificationResponseEntity> notificationMessageEmitter) {
        this.courseDomainService = courseDomainService;
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
        this.notificationDataMapper = notificationDataMapper;
        this.notificationMessageEmitter = notificationMessageEmitter;
    }

    @Transactional
    public Notification persistNotification(CreateNotificationCommand createNotificationCommand) {
        if(createNotificationCommand.getUserIdFrom() != null) {
            checkUser(createNotificationCommand.getUserIdFrom());
        }
        checkUser(createNotificationCommand.getUserIdTo());

        Notification notification = notificationDataMapper.
                createNotificationCommandToNotification(createNotificationCommand);
        courseDomainService.createNotification(notification);
        Notification notificationResult = saveNotification(notification);

        log.info("Notification created with id: {}", notificationResult.getId().getValue());

        NotificationResponseEntity queryNotificationResponse =
                notificationDataMapper.notificationToQueryNotificationResponse(notificationResult);
        log.info("Emitting notification to user: {}", queryNotificationResponse);
        String room = "user_" + createNotificationCommand.getUserIdTo();
        notificationMessageEmitter.emit(room, "get_message", queryNotificationResponse);
        log.info("Notification emitted to user: {}", queryNotificationResponse);

        return notificationResult;
    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }

    private Notification saveNotification(Notification notification) {
        Notification savedNotification = notificationRepository.
                saveNotification(notification);

        if (savedNotification == null) {
            log.error("Could not save notification");

            throw new CourseDomainException("Could not save notification");
        }
        log.info("Certificate course saved with id: {}", savedNotification.getId().getValue());
        return savedNotification;
    }

}





















