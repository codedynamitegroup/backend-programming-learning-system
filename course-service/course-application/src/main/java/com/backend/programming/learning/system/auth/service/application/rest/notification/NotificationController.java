package com.backend.programming.learning.system.auth.service.application.rest.notification;

import com.backend.programming.learning.system.course.service.domain.dto.method.delete.notification.DeleteNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.notification.DeleteNotificationResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.notification.QueryAllNotificationsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.notification.QueryAllNotificationsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.notification.UpdateNotificationCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.notification.UdpateNotificationResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.notification.NotificationApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
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

//    @PostMapping("/create")
//    @Operation(summary = "Create notification.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Success.", content = {
//                    @Content(mediaType = "application/vnd.api.v1+json",
//                            schema = @Schema(implementation = CreateNotificationResponse.class))
//            }),
//            @ApiResponse(responseCode = "400", description = "Not found."),
//            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
//    public ResponseEntity<CreateNotificationResponse> createNotification(
//            @RequestBody CreateNotificationCommand createNotificationCommand) {
//        log.info("Creating notification: {}", createNotificationCommand);
//        CreateNotificationResponse createNotificationResponse =
//                notificationApplicationService.createNotificationResponse(createNotificationCommand);
//        log.info("Notification created: {}", createNotificationResponse);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(createNotificationResponse);
//    }

    @GetMapping("/me")
    @Operation(summary = "Get all notifications of an user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllNotificationsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllNotificationsResponse> getAllNotifications(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        QueryAllNotificationsResponse queryAllNotificationsResponse =
                notificationApplicationService.queryAllNotificationsResponse(QueryAllNotificationsCommand
                        .builder()
                        .email(email)
                        .pageNo(pageNo)
                        .pageSize(pageSize)
                        .build());
        log.info("Returning all notifications: {}", queryAllNotificationsResponse);
        return ResponseEntity.ok(queryAllNotificationsResponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update notification.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UdpateNotificationResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UdpateNotificationResponse> updateNotification(
            @PathVariable UUID id,
            @RequestParam(required = true) Boolean read
    ) {
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        log.info("read: {}", read);

        log.info("Update notification: {}", id);
        UdpateNotificationResponse updateNotificationResponse =
                notificationApplicationService.updateNotificationResponse(UpdateNotificationCommand
                        .builder()
                        .notificationId(id)
                        .read(read)
                        .email(email)
                        .build());
        log.info("Notification updated: {}", updateNotificationResponse);

        return ResponseEntity.ok(updateNotificationResponse);
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
