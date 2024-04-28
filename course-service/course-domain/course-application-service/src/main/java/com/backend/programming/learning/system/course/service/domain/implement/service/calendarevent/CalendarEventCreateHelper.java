package com.backend.programming.learning.system.course.service.domain.implement.calendarevent;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.entity.CalendarEvent;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.course.service.domain.mapper.calendarevent.CalendarEventDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CalendarEventRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
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

    public CalendarEventCreateHelper(CourseDomainService courseDomainService,
                                     CalendarEventRepository calendarEventRepository,
                                     UserRepository userRepository,
                                     CalendarEventDataMapper calendarEventDataMapper) {
        this.courseDomainService = courseDomainService;
        this.calendarEventRepository = calendarEventRepository;
        this.userRepository = userRepository;
        this.calendarEventDataMapper = calendarEventDataMapper;
    }

    @Transactional
    public CalendarEvent persistCalendarEvent(CreateCalendarEventCommand createCalendarEventCommand) {
        checkUser(createCalendarEventCommand.getUserId());

        CalendarEvent calendarEvent = calendarEventDataMapper
                .createCalendarEventCommandToCalendarEvent(createCalendarEventCommand);
        courseDomainService.createCalendarEvent(calendarEvent);
        CalendarEvent calendarEventResult = saveCalendarEvent(calendarEvent);

        log.info("Calendar event created with id: {}", calendarEventResult.getId().getValue());
        return calendarEventResult;
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





















