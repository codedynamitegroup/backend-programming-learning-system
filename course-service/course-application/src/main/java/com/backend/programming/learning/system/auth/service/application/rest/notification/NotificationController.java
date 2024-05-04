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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    @Operation(summary = "Create notification.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateNotificationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateNotificationResponse> createNotification(
            @RequestBody CreateNotificationCommand createNotificationCommand) {
        log.info("Creating notification: {}", createNotificationCommand);
        CreateNotificationResponse createNotificationResponse =
                notificationApplicationService.createNotificationResponse(createNotificationCommand);
        log.info("Notification created: {}", createNotificationResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createNotificationResponse);
    }

    @GetMapping
    @Operation(summary = "Get all notifications.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllNotificationsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
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
    @Operation(summary = "Mark notification as read.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = MarkReadNotificationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
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
    @Operation(summary = "Delete notification.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteNotificationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
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
