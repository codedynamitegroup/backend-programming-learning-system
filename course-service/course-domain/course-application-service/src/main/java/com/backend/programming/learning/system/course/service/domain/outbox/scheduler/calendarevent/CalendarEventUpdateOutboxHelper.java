package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.calendarevent;

import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.exception.CalendarEventNotFoundException;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateEventPayload;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.outbox.CalendarEventUpdateOutboxRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.backend.programming.learning.system.saga.contest_user.SagaConstants.CONTEST_USER_SAGA_NAME;

@Slf4j
@Component
public class CalendarEventUpdateOutboxHelper {
    private final CalendarEventUpdateOutboxRepository calendarEventUpdateOutboxRepository;
    private final CalendarEventRepository calendarEventRepository;
    private final ObjectMapper objectMapper;

    public CalendarEventUpdateOutboxHelper(CalendarEventUpdateOutboxRepository calendarEventUpdateOutboxRepository,
                                           CalendarEventRepository calendarEventRepository,
                                           ObjectMapper objectMapper) {
        this.calendarEventUpdateOutboxRepository = calendarEventUpdateOutboxRepository;
        this.calendarEventRepository = calendarEventRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional(readOnly = true)
    public Optional<CalendarEventUpdateOutboxMessage>
    getCompletedCalendarEventUpdateOutboxMessageBySagaIdAndUpdateCalendarEventStateStatus(
            UUID sagaId, UpdateState updateCalendarEventState) {
        return calendarEventUpdateOutboxRepository.
                findByTypeAndSagaIdAndUpdateCalendarEventState(CONTEST_USER_SAGA_NAME, sagaId, updateCalendarEventState);
    }

    @Transactional(readOnly = true)
    public Optional<List<CalendarEventUpdateOutboxMessage>>
    getCalendarEventUpdateOutboxMessageByOutboxStatus(OutboxStatus outboxStatus) {
        return calendarEventUpdateOutboxRepository.findByTypeAndOutboxStatus(CONTEST_USER_SAGA_NAME, outboxStatus);
    }

    @Transactional
    public void deleteCalendarEventUpdateOutboxMessageByOutboxStatus(OutboxStatus outboxStatus) {
        calendarEventUpdateOutboxRepository.deleteByTypeAndOutboxStatus(CONTEST_USER_SAGA_NAME, outboxStatus);
    }

    @Transactional(readOnly = true)
    public CalendarEvent findCalendarEventByContestIdAndUserId(
            UUID contestId, UUID userId) {
        Optional<CalendarEvent> calendarEvent = calendarEventRepository
                .findCalendarEventByContestIdAndUserId(contestId, userId);
        if (calendarEvent.isEmpty()) {
            log.error("Could not find CalendarEvent by contestId: {} and userId: {}", contestId, userId);
            throw new CalendarEventNotFoundException("Could not find CalendarEvent by contestId: " + contestId + " and userId: " + userId);
        }
        return calendarEvent.get();
    }

    @Transactional
    public void saveCalendarEventUpdateOutboxRepositoryOutboxMessage(
            CalendarEventUpdateEventPayload calendarEventUpdateEventPayload,
            UpdateState updateState,
            OutboxStatus outboxStatus,
            UUID sagaId) {
        save(CalendarEventUpdateOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .createdAt(calendarEventUpdateEventPayload.getCreatedAt())
                .processedAt(ZonedDateTime.now(ZoneId.of("UTC")))
                .type(CONTEST_USER_SAGA_NAME)
                .payload(createPayload(calendarEventUpdateEventPayload))
                .updateCalendarEventState(updateState)
                .outboxStatus(outboxStatus)
                .build());
    }

    @Transactional
    public void updateOutboxStatus(CalendarEventUpdateOutboxMessage calendarEventUpdateOutboxMessage,
                                   OutboxStatus outboxStatus) {
        calendarEventUpdateOutboxMessage.setOutboxStatus(outboxStatus);
        save(calendarEventUpdateOutboxMessage);
        log.info("Order outbox table status is updated as: {}", outboxStatus.name());
    }

    void save(CalendarEventUpdateOutboxMessage calendarEventUpdateOutboxMessage) {
        CalendarEventUpdateOutboxMessage response = calendarEventUpdateOutboxRepository.save(calendarEventUpdateOutboxMessage);
        if (response == null) {
            throw new CourseDomainException("Could not save CalendarEventUpdateOutboxMessage!");
        }
        log.info("CalendarEventUpdateOutboxMessage saved with id: {}", response.getId());
    }

    private String createPayload(CalendarEventUpdateEventPayload calendarEventUpdateEventPayload) {
        try {
            return objectMapper.writeValueAsString(calendarEventUpdateEventPayload);
        } catch (JsonProcessingException e) {
            log.error("Could not create CalendarEventUpdateEventPayload json!", e);
            throw new CourseDomainException("Could not create CalendarEventUpdateEventPayload json!", e);
        }
    }

}
