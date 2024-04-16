package com.backend.programming.learning.system.core.service.application.rest.notification;

import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.contest.CreateContestResponse;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.contest.ContestApplicationService;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.notification.NotificationApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/core/notifications", produces = "application/vnd.api.v1+json")
public class NotificationController {
    private final NotificationApplicationService notificationApplicationService;

    public NotificationController(NotificationApplicationService notificationApplicationService) {
        this.notificationApplicationService = notificationApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateNotificationResponse> createNotification(
            @RequestBody CreateNotificationCommand createNotificationCommand) {
        log.info("Creating notification: {}", createNotificationCommand);
        CreateNotificationResponse createNotificationResponse =
                notificationApplicationService.createNotificationResponse(createNotificationCommand);
        log.info("Notification created: {}", createNotificationResponse);

        return ResponseEntity.ok(createNotificationResponse);
    }

}
