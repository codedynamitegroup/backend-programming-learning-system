package com.backend.programming.learning.system.course.service.domain.implement.service.notification.scheduler;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.notification.NotificationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.mapper.notification.NotificationDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.NotificationRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.socket.emitter.message.NotificationMessageEmitter;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationComponentType;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationNotifyTime;
import com.backend.programming.learning.system.domain.valueobject.NotificationId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
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
    private final CourseUserRepository courseUserRepository;

    public NotificationCreateScheduler(CalendarEventRepository calendarEventRepository,
                                       NotificationRepository notificationRepository,
                                       NotificationDataMapper notificationDataMapper,
                                       NotificationMessageEmitter<NotificationResponseEntity> notificationMessageEmitter,
                                       CourseUserRepository courseUserRepository) {
        this.calendarEventRepository = calendarEventRepository;
        this.notificationRepository = notificationRepository;
        this.notificationDataMapper = notificationDataMapper;
        this.notificationMessageEmitter = notificationMessageEmitter;
        this.courseUserRepository = courseUserRepository;
    }

    @Transactional
//    @Scheduled(fixedRateString = "${course-service.create-notification-scheduler-fixed-rate}")
    @Scheduled(fixedRateString = "15000")
    public void processCreateNotification() {
        log.info("Start NotificationCreateScheduler at {}", ZonedDateTime.now(ZoneId.of("UTC")));

        // Get all valid calendar events
        List<CalendarEvent> calendarEvents = calendarEventRepository
                .findAllValidCalendarEventsToCreateNotification(ZonedDateTime.now(ZoneId.of("UTC")));

        if (calendarEvents.isEmpty()) {
            log.info("No calendar event found after now at schedule time: {}",
                    ZonedDateTime.now(ZoneId.of("UTC")));
            return;
        }

        log.info("{} calendar events found after now at schedule time: {}",
                calendarEvents.size(), ZonedDateTime.now(ZoneId.of("UTC")));

        // Save multiple notifications for better performance
        List<Notification> notifications = new ArrayList<>();

        // Check if the startTime of calendarEvent is valid to create a notification
        // If it is, create a notification
        // Otherwise, do nothing
        calendarEvents.forEach(calendarEvent -> {
            NotificationNotifyTime newNotificationNotifyTime = isTimeValidToCreateNotification(
                    calendarEvent.getStartTime(),
                    calendarEvent.getNotificationNotifyTime());
            log.info("New NotificationNotifyTime: {}", newNotificationNotifyTime);
            if (newNotificationNotifyTime != null) {
                // Get the hours and minutes before the contest starts
                long hoursBeforeStart = Duration.between(
                        ZonedDateTime.now(ZoneId.of("UTC")),
                        calendarEvent.getStartTime()).toHours();
                long minutesBeforeStart = Duration.between(
                        ZonedDateTime.now(ZoneId.of("UTC")),
                        calendarEvent.getStartTime()).toMinutes() % 60;
                
                switch (calendarEvent.getComponent()) {
                    case CONTEST: {
                        String contextUrl = "/contests/" + calendarEvent.getContestId() + "/information";
                        String contextUrlName = "Contest";
                        User userFrom = calendarEvent.getUser();
                        User userTo = calendarEvent.getUser();
                        handleComponentType(
                                notifications,
                                NotificationComponentType.CONTEST,
                                newNotificationNotifyTime,
                                calendarEvent,
                                hoursBeforeStart,
                                minutesBeforeStart,
                                contextUrl,
                                contextUrlName,
                                userFrom,
                                userTo);
                        break;
                    }
                    case ASSIGNMENT: {
                        Page<CourseUser> courseUsers = courseUserRepository
                                .findAllUserByCourseId(
                                        calendarEvent.getCourse().getId().getValue(),
                                        "",
                                        0,
                                        9999999);
                        List<CourseUser> courseUserList = courseUsers.getContent();
                        log.info("CourseUserList size: {}", courseUserList.size());
                        for (CourseUser courseUser : courseUserList) {
                            boolean isTeacher = courseUser.getRoleMoodle().getId().getValue().equals(3) ||
                                    courseUser.getRoleMoodle().getId().getValue().equals(5);
                            String contextUrl = isTeacher
                                    ? "/lecturer/courses/" + calendarEvent.getCourse().getId().getValue() +
                                            "/assignments/" + calendarEvent.getAssignment().getId().getValue() :
                                            "/student/courses/" + calendarEvent.getCourse().getId().getValue() +
                                                    "/assignments/" + calendarEvent.getAssignment().getId().getValue();
                            String contextUrlName = "Assignment";
                            User userFrom = courseUser.getUser();
                            User userTo = courseUser.getUser();

                            handleComponentType(
                                    notifications,
                                    NotificationComponentType.ASSIGNMENT,
                                    newNotificationNotifyTime,
                                    calendarEvent,
                                    hoursBeforeStart,
                                    minutesBeforeStart,
                                    contextUrl,
                                    contextUrlName,
                                    userFrom,
                                    userTo);
                        }
                        break;
                    }
                    case EXAM: {
                        Page<CourseUser> courseUsers = courseUserRepository
                                .findAllUserByCourseId(
                                        calendarEvent.getCourse().getId().getValue(),
                                        "",
                                        0,
                                        9999999);
                        List<CourseUser> courseUserList = courseUsers.getContent();
                        log.info("CourseUserList size: {}", courseUserList.size());
                        for (CourseUser courseUser : courseUserList) {
                            boolean isTeacher = courseUser.getRoleMoodle().getId().getValue().equals(3) ||
                                    courseUser.getRoleMoodle().getId().getValue().equals(5);
                            String contextUrl = isTeacher
                                    ? "/lecturer/courses/" + calendarEvent.getCourse().getId().getValue() +
                                    "/assignments/exams/" + calendarEvent.getExam().getId().getValue() :
                                    "/student/courses/" + calendarEvent.getCourse().getId().getValue() +
                                            "/assignments/exams/" + calendarEvent.getExam().getId().getValue();
                            String contextUrlName = "Exam";
                            User userFrom = courseUser.getUser();
                            User userTo = courseUser.getUser();

                            handleComponentType(
                                    notifications,
                                    NotificationComponentType.EXAM,
                                    newNotificationNotifyTime,
                                    calendarEvent,
                                    hoursBeforeStart,
                                    minutesBeforeStart,
                                    contextUrl,
                                    contextUrlName,
                                    userFrom,
                                    userTo);
                        }
                        break;
                    }
                    default:
                        log.error("Invalid component: {}", calendarEvent.getComponent());
                        break;
                }
                calendarEvent.setNotificationNotifyTime(newNotificationNotifyTime);
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
            String room = "email_" + notificationResult.getUserTo().getEmail();
            notificationMessageEmitter.emit(room, "get_notification", queryNotificationResponse);
            log.info("Notification emitted to user: {}", queryNotificationResponse);
        }
        log.info("End emitting notifications at {}", ZonedDateTime.now(ZoneId.of("UTC")));

        // Save updated calendar events
        calendarEventRepository.saveAllCalendarEvents(calendarEvents);

        log.info("End NotificationCreateScheduler at {}", ZonedDateTime.now(ZoneId.of("UTC")));
    }

    private void handleComponentType(List<Notification> notifications,
                                     NotificationComponentType notificationComponentType,
                                     NotificationNotifyTime newNotificationNotifyTime,
                                     CalendarEvent calendarEvent,
                                     long hoursBeforeStart,
                                     long minutesBeforeStart,
                                     String contextUrl,
                                     String contextUrlName,
                                     User userFrom,
                                     User userTo) {
        // Build full message for contest
        String fullMessage = "";
        String smallMessage = "";

        String prefix = notificationComponentType.name().charAt(0)
                + notificationComponentType.name().substring(1).toLowerCase();

        if (newNotificationNotifyTime == NotificationNotifyTime.ONE_HOUR) {
            fullMessage = prefix + " \"" + calendarEvent.getName() + "\"" + " is about to start in " +
                    hoursBeforeStart + " hours and " + minutesBeforeStart + " minutes";
            smallMessage = prefix + " \"" + calendarEvent.getName() + "\"" + " is about to start in " +
                    hoursBeforeStart + " hours and " + minutesBeforeStart + " minutes";
        } else if (newNotificationNotifyTime == NotificationNotifyTime.THREE_HOURS) {
            fullMessage = prefix + " \"" + calendarEvent.getName() + "\"" + " is about to start in "
                    + hoursBeforeStart + " hours and " + minutesBeforeStart + " minutes";
            smallMessage = prefix + " \"" + calendarEvent.getName() + "\"" + " is about to start in "
                    + hoursBeforeStart + " hours and " + minutesBeforeStart + " minutes";
        } else if (newNotificationNotifyTime == NotificationNotifyTime.SIX_HOURS) {
            fullMessage = prefix + " \"" + calendarEvent.getName() + "\"" + " is about to start in "
                    + hoursBeforeStart + " hours and " + minutesBeforeStart + " minutes";
            smallMessage = prefix + " \"" +calendarEvent.getName() + "\"" + " is about to start in "
                    + hoursBeforeStart + " hours and " + minutesBeforeStart + " minutes";
        }
        else if (newNotificationNotifyTime == NotificationNotifyTime.TWELVE_HOURS) {
            fullMessage = prefix + " \"" + calendarEvent.getName() + "\"" + " is about to start in "
                    + hoursBeforeStart + " hours and " + minutesBeforeStart + " minutes";
            smallMessage = prefix + " \"" + calendarEvent.getName() + "\"" + " is about to start in "
                    + hoursBeforeStart + " hours and " + minutesBeforeStart + " minutes";
        }
        else if (newNotificationNotifyTime == NotificationNotifyTime.TWENTY_FOUR_HOURS) {
            fullMessage = prefix + " \"" + calendarEvent.getName() + "\"" + " is about to start in "
                    + hoursBeforeStart + " hours and " + minutesBeforeStart + " minutes";
            smallMessage = prefix + " \"" + calendarEvent.getName() + "\"" + " is about to start in "
                    + hoursBeforeStart + " hours and " + minutesBeforeStart + " minutes";
        }

        // Create notification for contest
        Notification newNotification = Notification.builder()
                .id(new NotificationId(UUID.randomUUID()))
                .userFrom(userFrom)
                .userTo(userTo)
                .subject(prefix + " \"" + calendarEvent.getName() + "\"" + " is about to start")
                .fullMessage(fullMessage)
                .smallMessage(smallMessage)
                .component(calendarEvent.getComponent())
                .eventType(calendarEvent.getEventType())
                .contextUrl(contextUrl)
                .contextUrlName(contextUrlName)
                .isRead(false)
                .timeRead(null)
                .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .build();
        notifications.add(newNotification);
    }

    private NotificationNotifyTime isTimeValidToCreateNotification(ZonedDateTime time,
                                                                   NotificationNotifyTime notificationNotifyTime) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        // Check multiple cases for notificationNotifyTime
        if (time.isAfter(now)) {
            log.info("Time is after now");
            if (time.isBefore(now.plusHours(1)) && notificationNotifyTime != NotificationNotifyTime.ONE_HOUR) {
                log.info("Time is before now plus 1 hour");
                return NotificationNotifyTime.ONE_HOUR;
            } else if (time.isBefore(now.plusHours(3))
                    && time.isAfter(now.plusHours(1))
                    && notificationNotifyTime != NotificationNotifyTime.THREE_HOURS) {
                log.info("Time is before now plus 3 hours and after now plus 1 hour");
                return NotificationNotifyTime.THREE_HOURS;
            } else if (time.isBefore(now.plusHours(6))
                    && time.isAfter(now.plusHours(3))
                    && notificationNotifyTime != NotificationNotifyTime.SIX_HOURS) {
                log.info("Time is before now plus 6 hours and after now plus 3 hours");
                return NotificationNotifyTime.SIX_HOURS;
            } else if (time.isBefore(now.plusHours(12))
                    && time.isAfter(now.plusHours(6))
                    && notificationNotifyTime != NotificationNotifyTime.TWELVE_HOURS) {
                log.info("Time is before now plus 12 hours and after now plus 6 hours");
                return NotificationNotifyTime.TWELVE_HOURS;
            } else if (time.isBefore(now.plusDays(1))
                    && time.isAfter(now.plusHours(12))
                    && notificationNotifyTime != NotificationNotifyTime.TWENTY_FOUR_HOURS) {
                log.info("Time is before now plus 1 day and after now plus 12 hours");
                return NotificationNotifyTime.TWENTY_FOUR_HOURS;
            } else {
                log.info("Time valid check is not in any case");
                return null;
            }
        } else {
            log.info("Time is not after now");
            return null;
        }
    }
}
