package com.backend.programming.learning.system.core.service.domain.implement.calendarevent;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.review.CreateReviewCommand;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.exception.CertificateCourseNotFoundException;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.calendarevent.CalendarEventDataMapper;
import com.backend.programming.learning.system.core.service.domain.mapper.review.ReviewDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.valueobject.CertificateCourseId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CalendarEventCreateHelper {
    private final CoreDomainService coreDomainService;
    private final CalendarEventRepository calendarEventRepository;
    private final UserRepository userRepository;
    private final CalendarEventDataMapper calendarEventDataMapper;

    public CalendarEventCreateHelper(CoreDomainService coreDomainService,
                                     CalendarEventRepository calendarEventRepository,
                                     UserRepository userRepository,
                                     CalendarEventDataMapper calendarEventDataMapper) {
        this.coreDomainService = coreDomainService;
        this.calendarEventRepository = calendarEventRepository;
        this.userRepository = userRepository;
        this.calendarEventDataMapper = calendarEventDataMapper;
    }

    @Transactional
    public CalendarEvent persistCalendarEvent(CreateCalendarEventCommand createCalendarEventCommand) {
        checkUser(createCalendarEventCommand.getUserId());

        CalendarEvent calendarEvent = calendarEventDataMapper
                .createCalendarEventCommandToCalendarEvent(createCalendarEventCommand);
        coreDomainService.createCalendarEvent(calendarEvent);
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

            throw new CoreDomainException("Could not save calendar event");
        }
        log.info("Calendar event saved with id: {}", savedCalendarEvent.getId().getValue());
        return savedCalendarEvent;
    }
}





















