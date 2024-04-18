package com.backend.programming.learning.system.core.service.dataaccess.calendarevent.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.calendarevent.mapper.CalendarEventDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.calendarevent.repository.CalendarEventJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.mapper.CertificateCourseDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository.CertificateCourseJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.mapper.CertificateCourseUserDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.repository.CertificateCourseUserJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.review.mapper.ReviewDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.review.repository.ReviewJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.topic.entity.TopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.topic.mapper.TopicDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.user.mapper.UserDataAccessMapper;
import com.backend.programming.learning.system.core.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CalendarEventRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.CertificateCourseRepository;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

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
    public CalendarEvent saveCalendarEvent(CalendarEvent calendarEvent) {
        return calendarEventDataAccessMapper.calendarEventEntityToCalendarEvent(calendarEventJpaRepository
                .save(calendarEventDataAccessMapper
                        .calendarEventToCalendarEventEntity(calendarEvent)));
    }
}
