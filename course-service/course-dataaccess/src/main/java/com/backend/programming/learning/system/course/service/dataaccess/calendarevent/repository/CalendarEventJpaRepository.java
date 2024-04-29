package com.backend.programming.learning.system.course.service.dataaccess.calendarevent.repository;

import com.backend.programming.learning.system.course.service.dataaccess.calendarevent.entity.CalendarEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CalendarEventJpaRepository extends JpaRepository<CalendarEventEntity, UUID> {

    @Query("""
        select c from CalendarEventEntity c
        where
        c.startTime <= ?1 and (c.endTime is null or c.endTime >= ?2)
    """)
    List<CalendarEventEntity> findAllBetweenFromTimeAndToTime(ZonedDateTime startTime, ZonedDateTime endTime);

//    CalendarEventEntity saveByContestIdAndUserId(UUID contestId, UUID userId, CalendarEventEntity calendarEventEntity);
    void deleteByContestIdAndUserId(UUID contestId, UUID userId);

    Optional<CalendarEventEntity> findByContestIdAndUserId(UUID contestId, UUID userId);
}
