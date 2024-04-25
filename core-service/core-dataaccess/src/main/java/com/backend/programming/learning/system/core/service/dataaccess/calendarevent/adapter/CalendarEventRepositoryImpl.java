package com.backend.programming.learning.system.core.service.dataaccess.calendarevent.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.calendarevent.mapper.CalendarEventDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.calendarevent.repository.CalendarEventJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CalendarEventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CalendarEventRepositoryImpl implements CalendarEventRepository {
    private final CalendarEventJpaRepository calendarEventJpaRepository;
    private final CalendarEventDataAccessMapper calendarEventDataAccessMapper;
    private CalendarEventJpaRepository calendarEventJpaRepository1;

    public CalendarEventRepositoryImpl(CalendarEventJpaRepository calendarEventJpaRepository,
                                       CalendarEventDataAccessMapper calendarEventDataAccessMapper) {
        this.calendarEventJpaRepository = calendarEventJpaRepository;
        this.calendarEventDataAccessMapper = calendarEventDataAccessMapper;
    }

    @Override
    public Optional<CalendarEvent> findById(UUID calendarEventId) {
        return calendarEventJpaRepository.findById(calendarEventId)
                .map(calendarEventDataAccessMapper::calendarEventEntityToCalendarEvent);
    }

    @Override
    public CalendarEvent saveCalendarEvent(CalendarEvent calendarEvent) {
        return calendarEventDataAccessMapper.calendarEventEntityToCalendarEvent(calendarEventJpaRepository
                .save(calendarEventDataAccessMapper
                        .calendarEventToCalendarEventEntity(calendarEvent)));
    }

    @Override
    public List<CalendarEvent> findAllBetweenFromTimeAndToTime(ZonedDateTime fromTime, ZonedDateTime toTime) {
        return calendarEventJpaRepository.findAllBetweenFromTimeAndToTime(fromTime, toTime)
                .stream()
                .map(calendarEventDataAccessMapper::calendarEventEntityToCalendarEvent)
                .toList();
    }

    @Override
    public void deleteCalendarEvent(UUID calendarEventId) {
        calendarEventJpaRepository.deleteById(calendarEventId);
    }
}
