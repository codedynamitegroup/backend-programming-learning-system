package com.backend.programming.learning.system.auth.service.application.rest.calendarevent;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.calendarevent.CalendarEventApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    @Operation(summary = "Create calendar event.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateCalendarEventResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateCalendarEventResponse> createCalendarEvent(
            @RequestBody CreateCalendarEventCommand createCalendarEventCommand) {
        log.info("Creating calendar event: {}", createCalendarEventCommand);
        CreateCalendarEventResponse createCalendarEventResponse =
                calendarEventApplicationService.createCalendarEventResponse(createCalendarEventCommand);
        log.info("Calendar event created: {}", createCalendarEventResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(createCalendarEventResponse);
    }

    @GetMapping
    @Operation(summary = "Get all calendar events.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCalendarEventsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
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
    @Operation(summary = "Delete calendar event by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteCalendarEventResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
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
