package com.backend.programming.learning.system.course.service.domain.implement.service.listener.calendarevent;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent.CalendarEventUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.notification.NotificationResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.entity.Notification;
import com.backend.programming.learning.system.course.service.domain.mapper.calendarevent.CalendarEventDataMapper;
import com.backend.programming.learning.system.course.service.domain.mapper.notification.NotificationDataMapper;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.outbox.scheduler.calendarevent.CalendarEventUpdateOutboxHelper;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.calendarevent.CalendarEventUpdatedMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.NotificationRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.socket.emitter.message.NotificationMessageEmitter;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationNotifyTime;
import com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.domain.valueobject.NotificationId;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CalendarEventRequestHelper {

    private final CourseDomainService courseDomainService;
    private final CalendarEventRepository calendarEventRepository;
    private final CalendarEventUpdatedMessagePublisher calendarEventUpdatedMessagePublisher;
    private final CalendarEventUpdateOutboxHelper calendarEventUpdateOutboxHelper;
    private final CalendarEventDataMapper calendarEventDataMapper;
    private final NotificationRepository notificationRepository;
    private final NotificationDataMapper notificationDataMapper;
    private final NotificationMessageEmitter<NotificationResponseEntity> notificationMessageEmitter;

    public CalendarEventRequestHelper(CourseDomainService courseDomainService,
                                      CalendarEventRepository calendarEventRepository,
                                      CalendarEventUpdatedMessagePublisher calendarEventUpdatedMessagePublisher,
                                      CalendarEventUpdateOutboxHelper calendarEventUpdateOutboxHelper,
                                      CalendarEventDataMapper calendarEventDataMapper,
                                      NotificationRepository notificationRepository,
                                      NotificationDataMapper notificationDataMapper,
                                      NotificationMessageEmitter<NotificationResponseEntity> notificationMessageEmitter) {
        this.courseDomainService = courseDomainService;
        this.calendarEventRepository = calendarEventRepository;
        this.calendarEventUpdatedMessagePublisher = calendarEventUpdatedMessagePublisher;
        this.calendarEventUpdateOutboxHelper = calendarEventUpdateOutboxHelper;
        this.calendarEventDataMapper = calendarEventDataMapper;
        this.notificationRepository = notificationRepository;
        this.notificationDataMapper = notificationDataMapper;
        this.notificationMessageEmitter = notificationMessageEmitter;
    }

    @Transactional
    public void persistCalendarEvent(CalendarEventUpdateRequest calendarEventUpdateRequest) {

        if (publishIfOutboxMessageProcessed(calendarEventUpdateRequest, UpdateState.CREATED)) {
            log.info("An outbox message with saga id: {} is already saved to database!",
                    calendarEventUpdateRequest.getSagaId());
            return;
        }

        log.info("Received CalendarEventUpdateRequest for contest id: {} and user id: {}",
                calendarEventUpdateRequest.getContestId(), calendarEventUpdateRequest.getUserId());

        CalendarEvent calendarEvent = calendarEventDataMapper
                .calendarEventUpdateRequestModelToCalendarEvent(calendarEventUpdateRequest);
        courseDomainService.createCalendarEvent(calendarEvent);

        NotificationNotifyTime newNotificationNotifyTime = isTimeValidToCreateNotification(
                calendarEvent.getStartTime(),
                calendarEvent.getNotificationNotifyTime());

        if (newNotificationNotifyTime != null) {
            // Get the hours and minutes before the contest starts
            long hoursBeforeContestStart = Duration.between(
                    ZonedDateTime.now(ZoneId.of("UTC")),
                    calendarEvent.getStartTime()).toHours();
            long minutesBeforeContestStart = Duration.between(
                    ZonedDateTime.now(ZoneId.of("UTC")),
                    calendarEvent.getStartTime()).toMinutes() % 60;

            // Build full message for contest
            String fullMessage = "";
            String smallMessage = "";

            if (newNotificationNotifyTime == NotificationNotifyTime.ONE_HOUR) {
                fullMessage = "Contest " + "\"" +calendarEvent.getName() + "\"" + " is about to start in " +
                        hoursBeforeContestStart + " hours and " + minutesBeforeContestStart + " minutes";
                smallMessage = "Contest " + "\"" +calendarEvent.getName() + "\"" + " is about to start in " +
                        hoursBeforeContestStart + " hours and " + minutesBeforeContestStart + " minutes";
            } else if (newNotificationNotifyTime == NotificationNotifyTime.THREE_HOURS) {
                fullMessage = "Contest " + "\"" +calendarEvent.getName() + "\"" + " is about to start in "
                        + hoursBeforeContestStart + " hours and " + minutesBeforeContestStart + " minutes";
                smallMessage = "Contest " + "\"" +calendarEvent.getName() + "\"" + " is about to start in "
                        + hoursBeforeContestStart + " hours and " + minutesBeforeContestStart + " minutes";
            } else if (newNotificationNotifyTime == NotificationNotifyTime.SIX_HOURS) {
                fullMessage = "Contest " + "\"" +calendarEvent.getName() + "\"" + " is about to start in "
                        + hoursBeforeContestStart + " hours and " + minutesBeforeContestStart + " minutes";
                smallMessage = "Contest " + "\"" +calendarEvent.getName() + "\"" + " is about to start in "
                        + hoursBeforeContestStart + " hours and " + minutesBeforeContestStart + " minutes";
            }
            else if (newNotificationNotifyTime == NotificationNotifyTime.TWELVE_HOURS) {
                fullMessage = "Contest " + "\"" +calendarEvent.getName() + "\"" + " is about to start in "
                        + hoursBeforeContestStart + " hours and " + minutesBeforeContestStart + " minutes";
                smallMessage = "Contest " + "\"" +calendarEvent.getName() + "\"" + " is about to start in "
                        + hoursBeforeContestStart + " hours and " + minutesBeforeContestStart + " minutes";
            }
            else if (newNotificationNotifyTime == NotificationNotifyTime.TWENTY_FOUR_HOURS) {
                fullMessage = "Contest " + "\"" +calendarEvent.getName() + "\"" + " is about to start in "
                        + hoursBeforeContestStart + " hours and " + minutesBeforeContestStart + " minutes";
                smallMessage = "Contest " + "\"" +calendarEvent.getName() + "\"" + " is about to start in "
                        + hoursBeforeContestStart + " hours and " + minutesBeforeContestStart + " minutes";
            }

            String subject = "You have registered for contest " + "\"" + calendarEvent.getName() + "\"";

            // Create notification for contest
            Notification newNotification = Notification.builder()
                    .id(new NotificationId(UUID.randomUUID()))
                    .userFrom(calendarEvent.getUser())
                    .userTo(calendarEvent.getUser())
                    .subject(subject)
                    .fullMessage(fullMessage)
                    .smallMessage(smallMessage)
                    .component(calendarEvent.getComponent())
                    .eventType(calendarEvent.getEventType())
                    .contextUrl("/contest/" + calendarEvent.getContestId() + "/information")
                    .contextUrlName("Contest")
                    .isRead(false)
                    .timeRead(null)
                    .createdAt(ZonedDateTime.now(ZoneId.of("UTC")))
                    .updatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
            .build();

            // Save notification
            Notification savedNotification = notificationRepository.saveNotification(newNotification);
            NotificationResponseEntity queryNotificationResponse = notificationDataMapper
                    .notificationToQueryNotificationResponse(savedNotification);
            log.info("Emitting notification to user: {}", queryNotificationResponse);
            String room = "email_" + calendarEvent.getUser().getEmail();
            notificationMessageEmitter.emit(room, "get_notification", queryNotificationResponse);
            log.info("Notification emitted to user: {}", queryNotificationResponse);
        }

        calendarEventRepository.saveCalendarEvent(calendarEvent);

        CalendarEventUpdateEventPayload calendarEventUpdateEventPayload =
                calendarEventDataMapper.
                        calendarEventUpdateRequestToCalendarEventUpdateEventPayload(
                                calendarEvent.getId().getValue().toString(),
                                calendarEventUpdateRequest,
                                UpdateState.CREATED.name(),
                                new ArrayList<>());

        calendarEventUpdateOutboxHelper.saveCalendarEventUpdateOutboxRepositoryOutboxMessage(
                calendarEventUpdateEventPayload,
                UpdateState.valueOf(calendarEventUpdateEventPayload.getUpdateCalendarEventState()),
                OutboxStatus.STARTED,
                UUID.fromString(calendarEventUpdateRequest.getSagaId()));
    }

    @Transactional
    public void updateCalendarEvent(CalendarEventUpdateRequest calendarEventUpdateRequest) {

        if (publishIfOutboxMessageProcessed(calendarEventUpdateRequest, UpdateState.UPDATED)) {
            log.info("An outbox message with saga id: {} is already saved to database!",
                    calendarEventUpdateRequest.getSagaId());
            return;
        }

        log.info("Received CalendarEventUpdateRequest for contest id: {} and user id: {}",
                calendarEventUpdateRequest.getContestId(), calendarEventUpdateRequest.getUserId());

        CalendarEvent calendarEvent = calendarEventDataMapper
                .calendarEventUpdateRequestModelToCalendarEvent(calendarEventUpdateRequest);
        CalendarEvent calendarEventFromDb = calendarEventUpdateOutboxHelper
                .findCalendarEventByContestIdAndUserId(
                        calendarEvent.getContestId(), calendarEvent.getUser().getId().getValue());
        calendarEvent.setId(calendarEventFromDb.getId());
        calendarEventRepository.saveCalendarEvent(calendarEvent);

        CalendarEventUpdateEventPayload calendarEventUpdateEventPayload =
                calendarEventDataMapper.
                        calendarEventUpdateRequestToCalendarEventUpdateEventPayload(
                                calendarEvent.getId().getValue().toString(),
                                calendarEventUpdateRequest,
                                UpdateState.UPDATED.name(),
                                new ArrayList<>());

        calendarEventUpdateOutboxHelper.saveCalendarEventUpdateOutboxRepositoryOutboxMessage(
                calendarEventUpdateEventPayload,
                UpdateState.valueOf(calendarEventUpdateEventPayload.getUpdateCalendarEventState()),
                OutboxStatus.STARTED,
                UUID.fromString(calendarEventUpdateRequest.getSagaId()));
    }

    @Transactional
    public void deleteCalendarEvent(CalendarEventUpdateRequest calendarEventUpdateRequest) {

        if (publishIfOutboxMessageProcessed(calendarEventUpdateRequest, UpdateState.DELETED)) {
            log.info("An outbox message with saga id: {} is already saved to database!",
                    calendarEventUpdateRequest.getSagaId());
            return;
        }

        log.info("Received CalendarEventUpdateRequest for contest id: {} and user id: {}",
                calendarEventUpdateRequest.getContestId(), calendarEventUpdateRequest.getUserId());

        CalendarEvent calendarEvent = calendarEventDataMapper
                .calendarEventUpdateRequestModelToCalendarEvent(calendarEventUpdateRequest);
        calendarEventRepository.deleteCalendarEventByContestIdAndUserId(
                calendarEvent.getContestId(), calendarEvent.getUser().getId().getValue());

        CalendarEventUpdateEventPayload calendarEventUpdateEventPayload =
                calendarEventDataMapper.
                        calendarEventUpdateRequestToCalendarEventUpdateEventPayload(
                                null,
                                calendarEventUpdateRequest,
                                UpdateState.DELETED.name(),
                                new ArrayList<>());

        calendarEventUpdateOutboxHelper.saveCalendarEventUpdateOutboxRepositoryOutboxMessage(
                calendarEventUpdateEventPayload,
                UpdateState.valueOf(calendarEventUpdateEventPayload.getUpdateCalendarEventState()),
                OutboxStatus.STARTED,
                UUID.fromString(calendarEventUpdateRequest.getSagaId()));

    }

    private boolean publishIfOutboxMessageProcessed(CalendarEventUpdateRequest calendarEventUpdateRequest,
                                                    UpdateState updateCalendarEventState) {
        Optional<CalendarEventUpdateOutboxMessage> calendarEventUpdateOutboxMessage =
                calendarEventUpdateOutboxHelper.
                        getCompletedCalendarEventUpdateOutboxMessageBySagaIdAndUpdateCalendarEventStateStatus(
                                UUID.fromString(calendarEventUpdateRequest.getSagaId()),
                                updateCalendarEventState);
        if (calendarEventUpdateOutboxMessage.isPresent()) {
            calendarEventUpdatedMessagePublisher.publish(calendarEventUpdateOutboxMessage.get(),
                    calendarEventUpdateOutboxHelper::updateOutboxStatus);
            return true;
        }
        return false;
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
