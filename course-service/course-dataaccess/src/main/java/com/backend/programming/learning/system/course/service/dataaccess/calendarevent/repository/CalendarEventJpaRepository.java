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

    @Query("""
        select c from CalendarEventEntity c
        where c.startTime > ?1
        """)
    List<CalendarEventEntity> findAllByStartTimeAfterTime(ZonedDateTime time);

    @Query(value = """
        select c.*
        from calendar_event c
        where c.contest_id is null
        and c.component <> 'CONTEST'
        and ((c.event_type = 'COURSE' and c.course_id in ?1)
            or (c.event_type = 'USER' and c.user_id = ?2))
        and ((c.start_time >= ?3 and c.start_time <= ?4)
            or (c.end_time is not null 
                    and (c.end_time >= ?3 and c.end_time <= ?4)))
""", nativeQuery = true)
    List<CalendarEventEntity> findAllByCourseIds(
            List<UUID> courseIds,
            UUID userId,
            ZonedDateTime fromTime,
            ZonedDateTime toTime
    );
}
