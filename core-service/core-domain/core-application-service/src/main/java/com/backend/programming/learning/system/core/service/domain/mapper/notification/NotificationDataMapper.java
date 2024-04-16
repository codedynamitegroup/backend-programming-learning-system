package com.backend.programming.learning.system.core.service.domain.mapper.notification;

import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.certificatecourse.CreateCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.certificatecourse.QueryCertificateCourseResponse;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Notification;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class NotificationDataMapper {
    public Notification createNotificationCommandToNotification(
            CreateNotificationCommand createNotificationCommand) {
        return Notification.builder()
                .userIdFrom(new UserId(createNotificationCommand.getUserIdFrom()))
                .userIdTo(new UserId(createNotificationCommand.getUserIdTo()))
                .subject(createNotificationCommand.getSubject())
                .fullMessage(createNotificationCommand.getFullMessage())
                .smallMessage(createNotificationCommand.getSmallMessage())
                .component(createNotificationCommand.getComponent())
                .eventType(createNotificationCommand.getEventType())
                .contextUrl(createNotificationCommand.getContextUrl())
                .contextUrlName(createNotificationCommand.getContextUrlName())
                .isRead(false)
                .build();
    }

    public CreateNotificationResponse notificationToCreateNotificationResponse(
            Notification notification, String message) {
        return CreateNotificationResponse.builder()
                .notification(notification)
                .message(message)
                .build();
    }
}
