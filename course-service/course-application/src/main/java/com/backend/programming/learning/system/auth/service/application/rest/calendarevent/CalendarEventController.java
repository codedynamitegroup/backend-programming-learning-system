package com.backend.programming.learning.system.auth.service.application.rest.calendarevent;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.calendarevent.CalendarEventApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/course/calendar-events", produces = "application/vnd.api.v1+json")
public class CalendarEventController {
    private final CalendarEventApplicationService calendarEventApplicationService;

    public CalendarEventController(CalendarEventApplicationService calendarEventApplicationService) {
        this.calendarEventApplicationService = calendarEventApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCalendarEventResponse> createCalendarEvent(
            @RequestBody CreateCalendarEventCommand createCalendarEventCommand) {
        log.info("Creating calendar event: {}", createCalendarEventCommand);
        CreateCalendarEventResponse createCalendarEventResponse =
                calendarEventApplicationService.createCalendarEventResponse(createCalendarEventCommand);
        log.info("Calendar event created: {}", createCalendarEventResponse);

        return ResponseEntity.ok(createCalendarEventResponse);
    }

    @GetMapping
    public ResponseEntity<QueryAllCalendarEventsResponse> getAllCalendarEvents(
            @RequestParam ZonedDateTime fromTime,
            @RequestParam ZonedDateTime toTime) {
        QueryAllCalendarEventsResponse queryAllCalendarEventsResponse =
                calendarEventApplicationService.queryAllCalendarEventsResponse(QueryAllCalendarEventsCommand
                        .builder()
                        .fromTime(fromTime)
                        .toTime(toTime)
                        .build());
        log.info("Returning all calendar events: {}", queryAllCalendarEventsResponse);
        return ResponseEntity.ok(queryAllCalendarEventsResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCalendarEventResponse> deleteCalendarEvent(@PathVariable UUID id) {
        DeleteCalendarEventResponse deleteCalendarEventResponse =
                calendarEventApplicationService.deleteCalendarEventResponse(DeleteCalendarEventCommand
                        .builder()
                        .calendarEventId(id)
                        .build());
        log.info("Calendar event deleted: {}", deleteCalendarEventResponse);
        return ResponseEntity.ok(deleteCalendarEventResponse);
    }

}
