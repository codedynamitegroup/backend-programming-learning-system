package com.backend.programming.learning.system.auth.service.application.rest.notification;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.notification.CreateNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.notification.CreateNotificationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.notification.DeleteNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.notification.DeleteNotificationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.notification.QueryAllNotificationsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.notification.QueryAllNotificationsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.notification.MarkReadNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.notification.MarkReadNotificationResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.notification.NotificationApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/course/notifications", produces = "application/vnd.api.v1+json")
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

    @GetMapping
    public ResponseEntity<QueryAllNotificationsResponse> getAllNotifications(
            @RequestParam UUID userIdTo,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        QueryAllNotificationsResponse queryAllNotificationsResponse =
                notificationApplicationService.queryAllNotificationsResponse(QueryAllNotificationsCommand
                        .builder()
                        .userIdTo(userIdTo)
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .build());
        log.info("Returning all notifications: {}", queryAllNotificationsResponse);
        return ResponseEntity.ok(queryAllNotificationsResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarkReadNotificationResponse> markReadNotification(
            @PathVariable UUID id
    ) {
        log.info("Marking notification as read: {}", id);
        MarkReadNotificationResponse markReadNotificationResponse =
                notificationApplicationService.markReadNotificationResponse(MarkReadNotificationCommand
                        .builder()
                        .notificationId(id)
                        .build());
        log.info("Notification marked as read: {}", markReadNotificationResponse);

        return ResponseEntity.ok(markReadNotificationResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteNotificationResponse> deleteNotification(@PathVariable UUID id) {
        DeleteNotificationResponse deleteNotificationResponse =
                notificationApplicationService.deleteNotificationResponse(DeleteNotificationCommand
                        .builder()
                        .notificationId(id)
                        .build());
        log.info("Review notification: {}", id);
        return ResponseEntity.ok(deleteNotificationResponse);
    }

}
