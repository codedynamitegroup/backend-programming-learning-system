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

//    CalendarEventEntity saveByContestIdAndUserId(UUID contestId, UUID userId, CalendarEventEntity calendarEventEntity);
    void deleteByContestIdAndUserId(UUID contestId, UUID userId);

    Optional<CalendarEventEntity> findByContestIdAndUserId(UUID contestId, UUID userId);
//
//     if (time.isAfter(now)) {
//        log.info("Time is after now");
//        if (time.isBefore(now.plusHours(1)) && notificationNotifyTime != NotificationNotifyTime.ONE_HOUR) {
//            log.info("Time is before now plus 1 hour");
//            return NotificationNotifyTime.ONE_HOUR;
//        } else if (time.isBefore(now.plusHours(3))
//                && time.isAfter(now.plusHours(1))
//                && notificationNotifyTime != NotificationNotifyTime.THREE_HOURS) {
//            log.info("Time is before now plus 3 hours and after now plus 1 hour");
//            return NotificationNotifyTime.THREE_HOURS;
//        } else if (time.isBefore(now.plusHours(6))
//                && time.isAfter(now.plusHours(3))
//                && notificationNotifyTime != NotificationNotifyTime.SIX_HOURS) {
//            log.info("Time is before now plus 6 hours and after now plus 3 hours");
//            return NotificationNotifyTime.SIX_HOURS;
//        } else if (time.isBefore(now.plusHours(12))
//                && time.isAfter(now.plusHours(6))
//                && notificationNotifyTime != NotificationNotifyTime.TWELVE_HOURS) {
//            log.info("Time is before now plus 12 hours and after now plus 6 hours");
//            return NotificationNotifyTime.TWELVE_HOURS;
//        } else if (time.isBefore(now.plusDays(1))
//                && time.isAfter(now.plusHours(12))
//                && notificationNotifyTime != NotificationNotifyTime.TWENTY_FOUR_HOURS) {
//            log.info("Time is before now plus 1 day and after now plus 12 hours");
//            return NotificationNotifyTime.TWENTY_FOUR_HOURS;
//        } else {
//            log.info("Time valid check is not in any case");
//            return null;
//        }
//    } else {
//        log.info("Time is not after now");
//        return null;
//    }

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
}
