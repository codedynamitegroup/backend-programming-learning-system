package com.backend.programming.learning.system.course.service.domain.implement.service.calendarevent;

import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllToDoCalendarEventsCommand;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.CourseUser;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseUserRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CalendarEventQueryHelper {
    private final CalendarEventRepository calendarEventRepository;
    private final UserRepository userRepository;
    private final CourseUserRepository courseUserRepository;
    private final CourseRepository courseRepository;

    public CalendarEventQueryHelper(CalendarEventRepository calendarEventRepository,
                                    UserRepository userRepository,
                                    CourseUserRepository courseUserRepository,
                                    CourseRepository courseRepository) {
        this.calendarEventRepository = calendarEventRepository;
        this.userRepository = userRepository;
        this.courseUserRepository = courseUserRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional(readOnly = true)
    public List<CalendarEvent> findAllCalendarEvents(
            QueryAllCalendarEventsCommand queryAllCalendarEventsCommand
    ) {
        User user = getUserByEmail(queryAllCalendarEventsCommand.getEmail());
        List<UUID> courseIdList = new ArrayList<>();
        if (queryAllCalendarEventsCommand.getCourseId() != null){
            courseIdList.add(queryAllCalendarEventsCommand.getCourseId());
        } else {
            Page<CourseUser> courseUserPage = getAllCoursesByUserId(user.getId().getValue());
            courseUserPage.forEach(courseUser -> courseIdList.add(courseUser.getCourse().getId().getValue()));
        }
        if (courseIdList.isEmpty()){
            log.warn("No course found for user: {}", user.getEmail());
            return new ArrayList<>();
        }
        return calendarEventRepository.findAll(
                courseIdList,
                queryAllCalendarEventsCommand.getFromTime(),
                queryAllCalendarEventsCommand.getToTime(),
                user.getId().getValue());
    }

    @Transactional(readOnly = true)
    public List<CalendarEvent> findAllToDoCalendarEvents(
            QueryAllToDoCalendarEventsCommand queryAllToDoCalendarEventsCommand
    ) {
        checkCourseById(queryAllToDoCalendarEventsCommand.getCourseId());
        return calendarEventRepository.findAllByCourseId(
                queryAllToDoCalendarEventsCommand.getCourseId()
        );
    }

    @Transactional(readOnly = true)
    public List<CalendarEvent> findAllCalendarEventsByExamId(UUID examId) {
        return calendarEventRepository.findAllByExamId(examId);
    }

    @Transactional(readOnly = true)
    public List<CalendarEvent> findAllCalendarEventsByAssignmentId(UUID assignmentId) {
        return calendarEventRepository.findAllByAssignmentId(assignmentId);
    }

    private Page<CourseUser> getAllCoursesByUserId(UUID userId) {
        return courseUserRepository.findAllCourseByUserId(
                userId, 0, 9999999, "", null);
    }

    private void checkCourseById(UUID courseId) {
        courseRepository.findById(courseId);
    }

    private User getUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email: {} not found", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
    }

}





















