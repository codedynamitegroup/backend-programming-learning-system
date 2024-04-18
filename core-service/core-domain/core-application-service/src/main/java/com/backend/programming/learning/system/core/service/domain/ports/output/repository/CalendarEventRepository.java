package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.core.service.domain.entity.CertificateCourse;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface CalendarEventRepository {

    CalendarEvent saveCalendarEvent(CalendarEvent calendarEvent);
}
