package com.backend.programming.learning.system.core.service.domain.implement.notification;

import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Contest;
import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import com.backend.programming.learning.system.core.service.domain.implement.contest.ContestCreateHelper;
import com.backend.programming.learning.system.core.service.domain.mapper.contest.ContestDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.notification.NotificationDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.notification.NotificationApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ContestRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class NotificationCommandHandler {
    private final NotificationCreateHelper notificationCreateHelper;
    private final NotificationDataMapper notificationDataMapper;
    private final NotificationRepository notificationRepository;

    public NotificationCommandHandler(NotificationCreateHelper notificationCreateHelper,
                                      NotificationDataMapper notificationDataMapper,
                                      NotificationRepository notificationRepository) {
        this.notificationCreateHelper = notificationCreateHelper;
        this.notificationDataMapper = notificationDataMapper;
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public CreateNotificationResponse createNotificationResponse(
            CreateNotificationCommand createNotificationCommand) {
        Notification notification = notificationCreateHelper
                .persistNotification(createNotificationCommand);

        log.info("Notification created with id: {}", notification.getId().getValue());

        return notificationDataMapper.notificationToCreateNotificationResponse(notification,
                "Notification created successfully");
    }

}
