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
        User userTo = userDataAccessMapper.userEntityToUser(calendarEventEntity.getUserTo());
        return CalendarEvent.builder()
                .id(new CalendarEventId(calendarEventEntity.getId()))
                .name(calendarEventEntity.getName())
                .description(calendarEventEntity.getDescription())
                .eventType(calendarEventEntity.getEventType())
                .startTime(calendarEventEntity.getStartTime())
                .endTime(calendarEventEntity.getEndTime())
                .userTo(userTo)
                .createdAt(calendarEventEntity.getCreatedAt())
                .build();
    }

    public CalendarEventEntity calendarEventToCalendarEventEntity(CalendarEvent calendarEvent) {
        UserEntity userTo = userDataAccessMapper.userToUserEntity(calendarEvent.getUserTo());
        return CalendarEventEntity.builder()
                .id(calendarEvent.getId().getValue())
                .name(calendarEvent.getName())
                .description(calendarEvent.getDescription())
                .eventType(calendarEvent.getEventType())
                .startTime(calendarEvent.getStartTime())
                .endTime(calendarEvent.getEndTime())
                .userTo(userTo)
                .createdAt(calendarEvent.getCreatedAt())
                .build();
    }
}
