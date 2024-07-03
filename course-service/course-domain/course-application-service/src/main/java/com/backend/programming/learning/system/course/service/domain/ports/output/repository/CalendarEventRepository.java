package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CalendarEventRepository {
    Optional<CalendarEvent> findById(UUID calendarEventId);
    CalendarEvent saveCalendarEvent(CalendarEvent calendarEvent);

    List<CalendarEvent> findAllBetweenFromTimeAndToTime(ZonedDateTime fromTime, ZonedDateTime toTime);

    void deleteCalendarEvent(UUID calendarEventId);

//    CalendarEvent saveCalendarEventByContestIdAndUserId(UUID contestId, UUID userId, CalendarEvent calendarEvent);
    void deleteCalendarEventByContestIdAndUserId(UUID contestId, UUID userId);
    Optional<CalendarEvent> findCalendarEventByContestIdAndUserId(UUID contestId, UUID userId);

    List<CalendarEvent> findAllValidCalendarEventsToCreateNotification(ZonedDateTime time);
    List<CalendarEvent> saveAllCalendarEvents(List<CalendarEvent> calendarEvents);
    List<CalendarEvent> findAll(
            List<UUID> courseIds,
            ZonedDateTime fromTime,
            ZonedDateTime toTime,
            UUID userId);

    List<CalendarEvent> findAllByExamId(UUID examId);
    List<CalendarEvent> findAllByAssignmentId(UUID assignmentId);
}
