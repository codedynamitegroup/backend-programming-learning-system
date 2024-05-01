package com.backend.programming.learning.system.course.service.dataaccess.outbox.calendar_event_update_outbox.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.outbox.calendar_event_update_outbox.exception.CalendarEventUpdateOutboxNotFoundException;
import com.backend.programming.learning.system.course.service.dataaccess.outbox.calendar_event_update_outbox.mapper.CalendarEventUpdateOutboxDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.outbox.calendar_event_update_outbox.repository.CalendarEventUpdateOutboxJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.outbox.model.calendarevent.CalendarEventUpdateOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventUpdateOutboxRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.UpdateState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CalendarEventUpdateOutboxRepositoryImpl implements CalendarEventUpdateOutboxRepository {

    private final CalendarEventUpdateOutboxJpaRepository calendarEventUpdateOutboxJpaRepository;
    private final CalendarEventUpdateOutboxDataAccessMapper calendarEventUpdateOutboxDataAccessMapper;

    public CalendarEventUpdateOutboxRepositoryImpl(CalendarEventUpdateOutboxJpaRepository calendarEventUpdateOutboxJpaRepository,
                                                   CalendarEventUpdateOutboxDataAccessMapper calendarEventUpdateOutboxDataAccessMapper) {
        this.calendarEventUpdateOutboxJpaRepository = calendarEventUpdateOutboxJpaRepository;
        this.calendarEventUpdateOutboxDataAccessMapper = calendarEventUpdateOutboxDataAccessMapper;
    }

    @Override
    public CalendarEventUpdateOutboxMessage save(CalendarEventUpdateOutboxMessage calendarEventUpdateOutboxMessage) {
        return calendarEventUpdateOutboxDataAccessMapper.calendarEventUpdateOutboxEntityToCalendarEventUpdateOutboxMessage(
                calendarEventUpdateOutboxJpaRepository.save(
                        calendarEventUpdateOutboxDataAccessMapper.
                                calendarEventUpdateOutboxMessageToCalendarEventUpdateOutboxEntity(
                                        calendarEventUpdateOutboxMessage)));
    }

    @Override
    public Optional<CalendarEventUpdateOutboxMessage> findByTypeAndSagaIdAndUpdateCalendarEventState(String type, UUID sagaId, UpdateState updateCalendarEventState) {
        return calendarEventUpdateOutboxJpaRepository.
                findByTypeAndSagaIdAndUpdateCalendarEventState(type, sagaId, updateCalendarEventState)
                .map(calendarEventUpdateOutboxDataAccessMapper::
                        calendarEventUpdateOutboxEntityToCalendarEventUpdateOutboxMessage);
    }

    @Override
    public Optional<List<CalendarEventUpdateOutboxMessage>> findByTypeAndOutboxStatus(String sagaType, OutboxStatus outboxStatus) {
        return Optional.of(calendarEventUpdateOutboxJpaRepository.findByTypeAndOutboxStatus(sagaType, outboxStatus)
                .orElseThrow(() -> new CalendarEventUpdateOutboxNotFoundException("Calendar event updated object " +
                        "cannot be found for saga type " + sagaType))
                .stream()
                .map(calendarEventUpdateOutboxDataAccessMapper
                        ::calendarEventUpdateOutboxEntityToCalendarEventUpdateOutboxMessage)
                .collect(Collectors.toList()));
    }

    @Override
    public void deleteByTypeAndOutboxStatus(String type, OutboxStatus outboxStatus) {
        calendarEventUpdateOutboxJpaRepository.deleteByTypeAndOutboxStatus(type, outboxStatus);
    }

}
