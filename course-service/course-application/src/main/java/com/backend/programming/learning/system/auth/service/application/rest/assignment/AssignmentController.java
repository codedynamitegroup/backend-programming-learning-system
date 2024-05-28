package com.backend.programming.learning.system.auth.service.application.rest.assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.assignment.CreateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.assignment.DeleteAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAllAssignmentsCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAllAssignmentsResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.assignment.QueryAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment.UpdateAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.assignment.UpdateAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.assignment.AssignmentApplicationService;
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

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/assignment", produces = "application/vnd.api.v1+json")
public class AssignmentController {
    private final AssignmentApplicationService assignmentApplicationService;

    @PostMapping
    @Operation(summary = "Create assignment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateAssignmentResponse> createAssignment(
            @RequestBody CreateAssignmentCommand createAssignmentCommand
    ) {
        log.info("Creating assignment");
        CreateAssignmentResponse response = assignmentApplicationService.createAssignment(createAssignmentCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Get all assignments.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllAssignmentsResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllAssignmentsResponse> getAllAssignments(@RequestParam UUID courseId) {
        log.info("Getting list assignments");
        QueryAllAssignmentsResponse response = assignmentApplicationService.queryAllAssignments(new QueryAllAssignmentsCommand(courseId));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get assignment by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAssignmentResponse> findBy(@PathVariable UUID id) {
        log.info("Getting assignment with id: {}", id);
        QueryAssignmentResponse response = assignmentApplicationService.queryAssignment(new QueryAssignmentCommand(id));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update assignment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateAssignmentResponse> updateAssignment(
            @PathVariable UUID id,
            @RequestBody UpdateAssignmentCommand updateAssignmentCommand
    )
    {
        log.info("Updating assignment with id: {}", id);
        UpdateAssignmentResponse response = assignmentApplicationService
                .updateAssignment(UpdateAssignmentCommand
                        .builder()
                        .assignmentId(id)
                        .title(updateAssignmentCommand.getTitle())
                        .intro(updateAssignmentCommand.getIntro())
                        .score(updateAssignmentCommand.getScore())
                        .maxScore(updateAssignmentCommand.getMaxScore())
                        .timeClose(updateAssignmentCommand.getTimeClose())
                        .timeLimit(updateAssignmentCommand.getTimeLimit())
                        .type(updateAssignmentCommand.getType())
                        .visible(updateAssignmentCommand.getVisible())
                        .build());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete assignment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteAssignmentResponse> deleteAssignment(@PathVariable UUID id) {
        log.info("Deleting assignment with id: {}", id);
        DeleteAssignmentResponse response= assignmentApplicationService
                .deleteAssignment(DeleteAssignmentCommand
                        .builder()
                        .assignmentId(id)
                        .build());
        return ResponseEntity.ok(response);
    }

}
