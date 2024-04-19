package com.backend.programming.learning.system.core.service.domain.implement.notification;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.notification.NotificationResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.notification.NotificationDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.socket.emitter.message.NotificationMessageEmitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class NotificationCreateHelper {
    private final CoreDomainService coreDomainService;
    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;
    private final NotificationDataMapper notificationDataMapper;
    private final NotificationMessageEmitter<NotificationResponseEntity> notificationMessageEmitter;

    public NotificationCreateHelper(CoreDomainService coreDomainService,
                                    UserRepository userRepository,
                                    NotificationRepository notificationRepository,
                                    NotificationDataMapper notificationDataMapper,
                                    NotificationMessageEmitter<NotificationResponseEntity>
                                            notificationMessageEmitter) {
        this.coreDomainService = coreDomainService;
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
        coreDomainService.createNotification(notification);
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

            throw new CoreDomainException("Could not save notification");
        }
        log.info("Certificate course saved with id: {}", savedNotification.getId().getValue());
        return savedNotification;
    }

}





















