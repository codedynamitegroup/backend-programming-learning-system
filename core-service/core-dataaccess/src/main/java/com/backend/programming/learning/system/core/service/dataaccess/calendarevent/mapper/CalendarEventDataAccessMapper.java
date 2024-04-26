package com.backend.programming.learning.system.core.service.dataaccess.calendarevent.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.calendarevent.entity.CalendarEventEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.mapper.TopicDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.entity.Topic;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.valueobject.CalendarEventId;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
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
                .component(calendarEventEntity.getComponent())
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
                .component(calendarEvent.getComponent())
                .createdAt(calendarEvent.getCreatedAt())
                .build();
    }
}
