package com.backend.programming.learning.system.course.service.dataaccess.calendarevent.repository;

import com.backend.programming.learning.system.course.service.dataaccess.calendarevent.entity.CalendarEventEntity;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationNotifyTime;
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

    void deleteByContestIdAndUserId(UUID contestId, UUID userId);

    Optional<CalendarEventEntity> findByContestIdAndUserId(UUID contestId, UUID userId);

    @Query("""
        select c from CalendarEventEntity c
        where c.startTime > ?1
        and (
            (c.startTime < ?2 and (c.notificationNotifyTime is null or c.notificationNotifyTime != 'ONE_HOUR'))
            or (c.startTime < ?3 and c.startTime > ?2 and (c.notificationNotifyTime is null or c.notificationNotifyTime != 'THREE_HOURS'))
            or (c.startTime < ?4 and c.startTime > ?3 and (c.notificationNotifyTime is null or c.notificationNotifyTime != 'SIX_HOURS'))
            or (c.startTime < ?5 and c.startTime > ?4 and (c.notificationNotifyTime is null or c.notificationNotifyTime != 'TWELVE_HOURS'))
            or (c.startTime < ?6 and c.startTime > ?5 and (c.notificationNotifyTime is null or c.notificationNotifyTime != 'TWENTY_FOUR_HOURS'))
        )
        """)
    List<CalendarEventEntity> findAllValidCalendarEventsToCreateNotification(ZonedDateTime now,
                                                                             ZonedDateTime afterOneHours,
                                                                             ZonedDateTime afterThreeHours,
                                                                             ZonedDateTime afterSixHours,
                                                                             ZonedDateTime afterTwelveHours,
                                                                             ZonedDateTime afterTwentyFourHours);

    @Query(value = """
        select c.*
        from calendar_event c
        where c.contest_id is null
        and c.component <> 'CONTEST'
        and ((c.event_type = 'COURSE' and c.course_id in ?1)
            or (c.event_type = 'USER' and c.user_id = ?2))
        and ((c.start_time >= ?3 and c.start_time <= ?4)
            or (c.end_time is not null 
                    and (c.end_time >= ?3 and c.end_time <= ?4))
            or (c.start_time < ?3 and c.end_time is not null and c.end_time > ?3))
""", nativeQuery = true)
    List<CalendarEventEntity> findAllByCourseIds(
            List<UUID> courseIds,
            UUID userId,
            ZonedDateTime fromTime,
            ZonedDateTime toTime
    );

    @Query("""
        select c from CalendarEventEntity c
        where c.exam.id = ?1
    """)
    List<CalendarEventEntity> findAllByExamId(UUID examId);

    @Query("""
        select c from CalendarEventEntity c
        where c.assignment.id = ?1
    """)
    List<CalendarEventEntity> findAllByAssignmentId(UUID assignmentId);

    @Query("""
        select c from CalendarEventEntity c
        where c.course.id = ?1
        and (c.component = 'EXAM' or c.component = 'ASSIGNMENT')
        and (c.endTime is null or c.endTime > ?2)
        order by c.endTime asc
        limit 5
    """)
    List<CalendarEventEntity> findAllByCourseId(UUID courseId, ZonedDateTime now);
}
