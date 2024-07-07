package com.backend.programming.learning.system.auth.service.application.rest.calendarevent;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.calendarevent.CreateCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.calendarevent.DeleteCalendarEventResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllCalendarEventsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.calendarevent.QueryAllToDoCalendarEventsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.calendarevent.UpdateCalendarEventCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.calendarevent.UpdateCalendarEventResponse;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
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

    @PutMapping("/{id}")
    @Operation(summary = "Update calendar event.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateCalendarEventResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateCalendarEventResponse> updateCalendarEvent(
            @PathVariable UUID id,
            @RequestBody UpdateCalendarEventCommand updateCalendarEventCommand) {
        log.info("Updating calendar event: {}", updateCalendarEventCommand);
        UpdateCalendarEventResponse updateCalendarEventResponse =
                calendarEventApplicationService.updateCalendarEventResponse(id, updateCalendarEventCommand);
        log.info("Calendar event created: {}", updateCalendarEventResponse);

        return ResponseEntity.ok(updateCalendarEventResponse);
    }

    @PostMapping("/query/my-calendar-events")
    @Operation(summary = "Get all calendar events of an user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCalendarEventsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllCalendarEventsResponse> getAllCalendarEvents(
           @RequestBody QueryAllCalendarEventsCommand queryAllCalendarEventsCommand) {
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
            Jwt token = jwtAuthenticationToken.getToken();
            email = token.getClaim("preferred_username");
        }

        QueryAllCalendarEventsResponse queryAllCalendarEventsResponse =
                calendarEventApplicationService.queryAllCalendarEventsResponse(QueryAllCalendarEventsCommand
                        .builder()
                        .courseId(queryAllCalendarEventsCommand.getCourseId())
                        .fromTime(queryAllCalendarEventsCommand.getFromTime())
                        .toTime(queryAllCalendarEventsCommand.getToTime())
                        .email(email)
                        .build());
        log.info("Returning all calendar events: {}", queryAllCalendarEventsResponse);
        return ResponseEntity.ok(queryAllCalendarEventsResponse);
    }

    @GetMapping("/query/to-do-calendar-events")
    @Operation(summary = "Get all todo calendar events.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllCalendarEventsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllCalendarEventsResponse> getAllToDoCalendarEvents(
            @RequestParam(required = true) UUID courseId
    ) {
        QueryAllCalendarEventsResponse queryAllCalendarEventsResponse =
                calendarEventApplicationService.queryAllToDoCalendarEventsResponse(QueryAllToDoCalendarEventsCommand
                        .builder()
                        .courseId(courseId)
                        .build());
        log.info("Returning all my to do calendar events: {}", queryAllCalendarEventsResponse);
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
