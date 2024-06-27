package com.backend.programming.learning.system.course.service.domain.implement.service.calendarevent;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.calendarevent.CalendarEventDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.NotificationEventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CalendarEventCreateHelper {
    private final CourseDomainService courseDomainService;
    private final CalendarEventRepository calendarEventRepository;
    private final UserRepository userRepository;
    private final CalendarEventDataMapper calendarEventDataMapper;
    private final CourseRepository courseRepository;

    public CalendarEventCreateHelper(CourseDomainService courseDomainService,
                                     CalendarEventRepository calendarEventRepository,
                                     UserRepository userRepository,
                                     CalendarEventDataMapper calendarEventDataMapper,
                                     CourseRepository courseRepository) {
        this.courseDomainService = courseDomainService;
        this.calendarEventRepository = calendarEventRepository;
        this.userRepository = userRepository;
        this.calendarEventDataMapper = calendarEventDataMapper;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public CalendarEvent persistCalendarEvent(CreateCalendarEventCommand createCalendarEventCommand) {
        if (createCalendarEventCommand.getEventType().equals(NotificationEventType.COURSE.name())) {
            if (createCalendarEventCommand.getCourseId() == null) {
                log.warn("Course id is required for course event");
                throw new CourseDomainException("Course id is required for course event");
            }
            checkCourse(createCalendarEventCommand.getCourseId());
        } else if (createCalendarEventCommand.getEventType().equals(NotificationEventType.USER.name())) {
            if (createCalendarEventCommand.getUserId() == null) {
                log.warn("User id is required for user event");
                throw new CourseDomainException("User id is required for user event");
            }
            checkUser(createCalendarEventCommand.getUserId());
        } else {
            log.warn("Invalid event type: {}", createCalendarEventCommand.getEventType());
            throw new CourseDomainException("Invalid event type: " + createCalendarEventCommand.getEventType());
        }

        CalendarEvent calendarEvent = calendarEventDataMapper
                .createCalendarEventCommandToCalendarEvent(createCalendarEventCommand);
        courseDomainService.createCalendarEvent(calendarEvent);
        CalendarEvent calendarEventResult = saveCalendarEvent(calendarEvent);

        log.info("Calendar event created with id: {}", calendarEventResult.getId().getValue());
        return calendarEventResult;
    }

    private void checkCourse(UUID courseId) {
        Optional<Course> course = courseRepository.findCourseById(courseId);
        if (course.isEmpty()) {
            log.warn("Course with id: {} not found", courseId);
            throw new CourseDomainException("Could not find course with id: " + courseId);
        }
    }

    private void checkUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
    }

    private CalendarEvent saveCalendarEvent(CalendarEvent calendarEvent) {
        CalendarEvent savedCalendarEvent = calendarEventRepository
                .saveCalendarEvent(calendarEvent);

        if (savedCalendarEvent == null) {
            log.error("Could not save calendar event");
            throw new CourseDomainException("Could not save calendar event");
        }
        log.info("Calendar event saved with id: {}", savedCalendarEvent.getId().getValue());
        return savedCalendarEvent;
    }
}





















