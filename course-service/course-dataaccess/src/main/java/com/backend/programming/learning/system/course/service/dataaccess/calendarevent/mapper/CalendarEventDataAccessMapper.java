package com.backend.programming.learning.system.course.service.dataaccess.calendarevent.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.calendarevent.entity.CalendarEventEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.CalendarEventId;
import org.springframework.stereotype.Component;

@Component
public class CalendarEventDataAccessMapper {
    private final UserDataAccessMapper userDataAccessMapper;

    public CalendarEventDataAccessMapper(UserDataAccessMapper userDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
    }

    public CalendarEvent calendarEventEntityToCalendarEvent(CalendarEventEntity calendarEventEntity) {
        User user= userDataAccessMapper.userEntityToUser(calendarEventEntity.getUser());
        return CalendarEvent.builder()
                .id(new CalendarEventId(calendarEventEntity.getId()))
                .name(calendarEventEntity.getName())
                .description(calendarEventEntity.getDescription())
                .eventType(calendarEventEntity.getEventType())
                .startTime(calendarEventEntity.getStartTime())
                .endTime(calendarEventEntity.getEndTime())
                .user(user)
                .courseId(calendarEventEntity.getCourseId())
                .contestId(calendarEventEntity.getContestId())
                .component(calendarEventEntity.getComponent())
                .isStartTimeNotified(calendarEventEntity.getIsStartTimeNotified())
                .isEndTimeNotified(calendarEventEntity.getIsEndTimeNotified())
                .notificationNotifyTime(calendarEventEntity.getNotificationNotifyTime())
                .createdAt(calendarEventEntity.getCreatedAt())
                .build();
    }

    public CalendarEventEntity calendarEventToCalendarEventEntity(CalendarEvent calendarEvent) {
        UserEntity userEntity = userDataAccessMapper.userToUserEntity(calendarEvent.getUser());
        return CalendarEventEntity.builder()
                .id(calendarEvent.getId().getValue())
                .name(calendarEvent.getName())
                .description(calendarEvent.getDescription())
                .eventType(calendarEvent.getEventType())
                .startTime(calendarEvent.getStartTime())
                .endTime(calendarEvent.getEndTime())
                .user(userEntity)
                .courseId(calendarEvent.getCourseId())
                .contestId(calendarEvent.getContestId())
                .component(calendarEvent.getComponent())
                .isStartTimeNotified(calendarEvent.getStartTimeNotified())
                .isEndTimeNotified(calendarEvent.getEndTimeNotified())
                .notificationNotifyTime(calendarEvent.getNotificationNotifyTime())
                .createdAt(calendarEvent.getCreatedAt())
                .build();
    }
}
