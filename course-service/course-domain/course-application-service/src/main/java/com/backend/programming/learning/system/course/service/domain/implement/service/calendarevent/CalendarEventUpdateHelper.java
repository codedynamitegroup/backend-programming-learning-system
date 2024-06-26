package com.backend.programming.learning.system.course.service.domain.implement.service.calendarevent;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.calendarevent.UpdateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.exception.CalendarEventNotFoundException;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.exception.CourseNotFoundException;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.calendarevent.CalendarEventDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.*;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CalendarEventUpdateHelper {
    private final CalendarEventRepository calendarEventRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public CalendarEventUpdateHelper(CalendarEventRepository calendarEventRepository,
                                     UserRepository userRepository,
                                     CourseRepository courseRepository) {
        this.calendarEventRepository = calendarEventRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public CalendarEvent persistCalendarEvent(
                UUID calendarEventId, UpdateCalendarEventCommand updateCalendarEventCommand) {
        CalendarEvent calendarEvent = getCalendarEvent(calendarEventId);

        if (updateCalendarEventCommand.getName() != null) {
            calendarEvent.setName(updateCalendarEventCommand.getName());
        }

        if (updateCalendarEventCommand.getDescription() != null) {
            calendarEvent.setDescription(updateCalendarEventCommand.getDescription());
        }

        if (updateCalendarEventCommand.getEventType() != null) {
            calendarEvent.setEventType(NotificationEventType.valueOf(updateCalendarEventCommand.getEventType()));
        }

        if (updateCalendarEventCommand.getStartTime() != null) {
            calendarEvent.setStartTime(updateCalendarEventCommand.getStartTime());
        }

        if (updateCalendarEventCommand.getEndTime() != null) {
            calendarEvent.setEndTime(updateCalendarEventCommand.getEndTime());
        }

        if (updateCalendarEventCommand.getUserId() != null) {
            checkUser(updateCalendarEventCommand.getUserId());
            calendarEvent.setUser(
                    User.builder()
                            .id(new UserId(updateCalendarEventCommand.getUserId()))
                            .build()
            );
        }

        if (updateCalendarEventCommand.getCourseId() != null) {
            checkCourse(updateCalendarEventCommand.getCourseId());
            calendarEvent.setCourse(Course.builder()
                    .id(new CourseId(updateCalendarEventCommand.getCourseId()))
                    .build());
        }

        if (updateCalendarEventCommand.getContestId() != null) {
            calendarEvent.setContestId(updateCalendarEventCommand.getContestId());
        }

        if (updateCalendarEventCommand.getExamId() != null) {
            calendarEvent.setExam(
                    Exam.builder()
                            .id(new ExamId(updateCalendarEventCommand.getExamId()))
                            .build()
            );
        }

        if (updateCalendarEventCommand.getAssignmentId() != null) {
            calendarEvent.setAssignment(
                    Assignment.builder()
                            .id(new AssignmentId(updateCalendarEventCommand.getAssignmentId()))
                            .build()
            );
        }

        if (updateCalendarEventCommand.getComponent() != null) {
           calendarEvent.setComponent(NotificationComponentType.valueOf(updateCalendarEventCommand.getComponent()));
        }

        CalendarEvent savedCalendarEvent = saveCalendarEvent(calendarEvent);
        log.info("Calendar event updated with id: {}", savedCalendarEvent.getId().getValue());
        return savedCalendarEvent;
    }

    private CalendarEvent getCalendarEvent(UUID calendarEventId) {
        Optional<CalendarEvent> calendarEvent = calendarEventRepository.findById(calendarEventId);
        if (calendarEvent.isEmpty()) {
            log.warn("Calendar event with id: {} not found", calendarEventId);
            throw new CalendarEventNotFoundException("Could not find calendar event with id: " + calendarEventId);
        }
        return calendarEvent.get();
    }

    private void checkCourse(UUID courseId) {
        Optional<Course> course = courseRepository.findCourseById(courseId);
        if (course.isEmpty()) {
            log.warn("Course with id: {} not found", courseId);
            throw new CourseNotFoundException("Could not find course with id: " + courseId);
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





















