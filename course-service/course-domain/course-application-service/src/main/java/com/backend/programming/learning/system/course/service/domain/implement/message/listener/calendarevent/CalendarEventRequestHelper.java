package com.backend.programming.learning.system.course.service.domain.implement.message.listener.calendarevent;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.calendarevent.CalendarEventUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.calendarevent.CalendarEventDataMapper;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.outbox.scheduler.calendarevent.CalendarEventUpdateOutboxHelper;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.calendarevent.CalendarEventUpdatedMessagePublisher;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public CalendarEventRequestHelper(CourseDomainService courseDomainService,
                                      CalendarEventRepository calendarEventRepository,
                                      CalendarEventUpdatedMessagePublisher calendarEventUpdatedMessagePublisher,
                                      CalendarEventUpdateOutboxHelper calendarEventUpdateOutboxHelper,
                                      CalendarEventDataMapper calendarEventDataMapper) {
        this.courseDomainService = courseDomainService;
        this.calendarEventRepository = calendarEventRepository;
        this.calendarEventUpdatedMessagePublisher = calendarEventUpdatedMessagePublisher;
        this.calendarEventUpdateOutboxHelper = calendarEventUpdateOutboxHelper;
        this.calendarEventDataMapper = calendarEventDataMapper;
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
}
