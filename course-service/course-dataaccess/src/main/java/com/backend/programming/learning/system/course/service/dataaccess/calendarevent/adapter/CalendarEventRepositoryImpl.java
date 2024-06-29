package com.backend.programming.learning.system.course.service.dataaccess.calendarevent.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.calendarevent.entity.CalendarEventEntity;
import com.backend.programming.learning.system.course.service.dataaccess.calendarevent.mapper.CalendarEventDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.calendarevent.repository.CalendarEventJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CalendarEventRepositoryImpl implements CalendarEventRepository {
    private final CalendarEventJpaRepository calendarEventJpaRepository;
    private final CalendarEventDataAccessMapper calendarEventDataAccessMapper;

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

    @Override
    public void deleteCalendarEventByContestIdAndUserId(UUID contestId, UUID userId) {
        calendarEventJpaRepository.deleteByContestIdAndUserId(contestId, userId);
    }

    @Override
    public Optional<CalendarEvent> findCalendarEventByContestIdAndUserId(UUID contestId, UUID userId) {
        return calendarEventJpaRepository.findByContestIdAndUserId(contestId, userId)
                .map(calendarEventDataAccessMapper::calendarEventEntityToCalendarEvent);
    }

    @Override
    public List<CalendarEvent> findAllByStartTimeAfterTime(ZonedDateTime time) {
        return calendarEventJpaRepository.findAllByStartTimeAfterTime(time)
                .stream()
                .map(calendarEventDataAccessMapper
                        ::calendarEventEntityToCalendarEvent)
                .toList();
    }

    @Override
    public List<CalendarEvent> saveAllCalendarEvents(List<CalendarEvent> calendarEvents) {
        List<CalendarEventEntity> calendarEventEntities = new ArrayList<>();
        calendarEvents.forEach(calendarEvent -> calendarEventEntities.add(calendarEventDataAccessMapper
                .calendarEventToCalendarEventEntity(calendarEvent)));
        return calendarEventJpaRepository.saveAll(calendarEventEntities)
                .stream()
                .map(calendarEventDataAccessMapper::calendarEventEntityToCalendarEvent)
                .toList();
    }

    @Override
    public List<CalendarEvent> findAll(List<UUID> courseIds, ZonedDateTime fromTime, ZonedDateTime toTime, UUID userId) {
        return calendarEventJpaRepository.findAllByCourseIds(courseIds, userId, fromTime, toTime)
                .stream()
                .map(calendarEventDataAccessMapper::calendarEventEntityToCalendarEvent)
                .toList();
    }

    @Override
    public List<CalendarEvent> findAllByExamId(UUID examId) {
        return calendarEventJpaRepository.findAllByExamId(examId)
                .stream()
                .map(calendarEventDataAccessMapper::calendarEventEntityToCalendarEvent)
                .toList();
    }
}
