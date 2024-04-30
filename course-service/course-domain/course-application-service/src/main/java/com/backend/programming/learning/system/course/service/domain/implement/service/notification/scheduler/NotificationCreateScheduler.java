package com.backend.programming.learning.system.course.service.domain.implement.service.notification.scheduler;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.notification.NotificationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.entity.Notification;
import com.backend.programming.learning.system.course.service.domain.mapper.notification.NotificationDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.NotificationRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.socket.emitter.message.NotificationMessageEmitter;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationNotifyTime;
import com.backend.programming.learning.system.domain.valueobject.NotificationId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class NotificationCreateScheduler {
    private final Map<String, Integer> notificationTimeMapInMillis = Arrays.stream(NotificationNotifyTime.values())
            .collect(Collectors.toMap(
                    NotificationNotifyTime::name,
                    NotificationNotifyTime::getTimeInMillis
            ));

    private final CalendarEventRepository calendarEventRepository;
    private final NotificationRepository notificationRepository;
    private final NotificationDataMapper notificationDataMapper;
    private final NotificationMessageEmitter<NotificationResponseEntity> notificationMessageEmitter;

    public NotificationCreateScheduler(CalendarEventRepository calendarEventRepository,
                                       NotificationRepository notificationRepository,
                                        NotificationDataMapper notificationDataMapper,
                                       NotificationMessageEmitter<NotificationResponseEntity> notificationMessageEmitter) {
        this.calendarEventRepository = calendarEventRepository;
        this.notificationRepository = notificationRepository;
        this.notificationDataMapper = notificationDataMapper;
        this.notificationMessageEmitter = notificationMessageEmitter;
    }

    @Transactional
    @Scheduled(fixedRateString = "${course-service.create-notification-scheduler-fixed-rate}")
    public void processCreateNotification() {
        log.info("Start NotificationCreateScheduler at {}", ZonedDateTime.now(ZoneId.of("UTC")));

        // Get all calendar events with the time after now
        List<CalendarEvent> calendarEvents = calendarEventRepository
                .findAllByStartTimeAfterTime(ZonedDateTime.now(ZoneId.of("UTC")));

        if (calendarEvents.isEmpty()) {
            log.info("No calendar event found after now at schedule time: {}",
                    ZonedDateTime.now(ZoneId.of("UTC")));
            return;
        }

        // Save multiple notifications for better performance
        List<Notification> notifications = new ArrayList<>();

        // Check if the startTime of calendarEvent is valid to create a notification
        // If it is, create a notification
        // Otherwise, do nothing
        calendarEvents.forEach(calendarEvent -> {
            Integer notificationTimeInMillis = isTimeValidToCreateNotification(calendarEvent.getStartTime());
            if (notificationTimeInMillis != null) {
                // TODO: DO FOR REMAINING COMPONENTS
                switch (calendarEvent.getComponent()) {
                    case CONTEST: {
                        // Get the minutes before the contest starts
                        int minutesBeforeContestStart =
                                calendarEvent.getStartTime().minusMinutes(
                                        ZonedDateTime.now(ZoneId.of("UTC")).getMinute()).getMinute();
                        // Build full message for contest
                        String fullMessage = "Contest " + calendarEvent.getName() + " is about to start in "
                                + minutesBeforeContestStart + " minutes";
                        // Build small message for contest
                        String smallMessage = "Contest " + calendarEvent.getName() + " is about to start in "
                                + minutesBeforeContestStart + " minutes";
                        // Create notification for contest
                        Notification newNotification = Notification.builder()
                                .id(new NotificationId(UUID.randomUUID()))
                                .userFrom(calendarEvent.getUser())
                                .userTo(calendarEvent.getUser())
                                .subject("Contest " + calendarEvent.getName() + " is about to start")
                                .fullMessage(fullMessage)
                                .smallMessage(smallMessage)
                                .component(calendarEvent.getComponent())
                                .eventType(calendarEvent.getEventType())
                                .contextUrl("contest/" + calendarEvent.getContestId())
                                .contextUrlName("Contest")
                                .isRead(false)
                                .timeRead(null)
                                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                                .build();
                        notifications.add(newNotification);
                        break;
                    }
                    default:
                        log.error("Invalid component: {}", calendarEvent.getComponent());
                        break;
                }
            }
        });

        if (notifications.isEmpty()) {
            log.info("No notification created at schedule time: {}",
                    ZonedDateTime.now(ZoneId.of("UTC")));
            return;
        }

        log.info("{} notifications created at schedule time: {}",
                notifications.size(), ZonedDateTime.now(ZoneId.of("UTC")));
        // Save notifications
        List<Notification> savedNotifications = notificationRepository.saveAllNotifications(notifications);

        log.info("Start emitting notifications at {}", ZonedDateTime.now(ZoneId.of("UTC")));
        for (Notification notificationResult : savedNotifications) {
            NotificationResponseEntity queryNotificationResponse = notificationDataMapper
                    .notificationToQueryNotificationResponse(notificationResult);
            log.info("Emitting notification to user: {}", queryNotificationResponse);
            String room = "user_" + notificationResult.getUserTo().getId().getValue();
            notificationMessageEmitter.emit(room, "get_message", queryNotificationResponse);
            log.info("Notification emitted to user: {}", queryNotificationResponse);
        }
        log.info("End emitting notifications at {}", ZonedDateTime.now(ZoneId.of("UTC")));

        log.info("End NotificationCreateScheduler at {}", ZonedDateTime.now(ZoneId.of("UTC")));
    }

    private Integer isTimeValidToCreateNotification(ZonedDateTime time) {
        // Check if the time is after the current time for any notification time
        // If it is, return the notification time in milliseconds
        // Otherwise, return null
        return notificationTimeMapInMillis.entrySet().stream().filter(
                entry -> time.isAfter(ZonedDateTime.now(ZoneId.of("UTC")).plusSeconds(entry.getValue() / 1000)
                ))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(null);
    }
}
