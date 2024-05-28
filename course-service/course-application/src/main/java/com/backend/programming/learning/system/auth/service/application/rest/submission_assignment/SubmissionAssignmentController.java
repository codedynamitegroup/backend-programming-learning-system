package com.backend.programming.learning.system.auth.service.application.rest.submission_assignment;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment.DeleteSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QueryAllSubmissionnAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QuerySubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.submission_assignment.QuerySubmissionAssignmentUserCommand;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.submission_assignment.SubmissionAssignmentResponseEntity;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment.UpdateSubmissionAssignmentCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment.UpdateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment.SubmissionAssignmentApplicationService;
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
@RequestMapping(value = "/course/submission-assignment", produces = "application/vnd.api.v1+json")
public class SubmissionAssignmentController {
    private final SubmissionAssignmentApplicationService submissionAssignmentApplicationService;

    @PostMapping
    @Operation(summary = "Create submission assignment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateSubmissionAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateSubmissionAssignmentResponse> createSubmissionAssignment(
            @RequestBody CreateSubmissionAssignmentCommand createSubmissionAssignmentCommand
    ) {
        log.info("Creating submission assignment");
        CreateSubmissionAssignmentResponse response = submissionAssignmentApplicationService.createSubmissionAssignment(createSubmissionAssignmentCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{submissionId}")
    @Operation(summary = "Query submission assignment by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = SubmissionAssignmentResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<SubmissionAssignmentResponseEntity> querySubmissionAssignmentById(
            @PathVariable UUID submissionId
    ) {
        log.info("Querying submission assignment by id");
        SubmissionAssignmentResponseEntity response = submissionAssignmentApplicationService
                .querySubmissionAssignmentById(new QuerySubmissionAssignmentCommand(submissionId));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Query all submission assignment by assignment id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = QueryAllSubmissionAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<QueryAllSubmissionAssignmentResponse> queryAllByAssignmentId(
            @RequestParam UUID assignmentId
    ) {
        log.info("Querying all submission assignment by assignment id");
        QueryAllSubmissionAssignmentResponse response = submissionAssignmentApplicationService
                .queryAllByAssignmentId(new QueryAllSubmissionnAssignmentCommand(assignmentId));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{submissionAssignmentId}")
    @Operation(summary = "Delete submission assignment by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteSubmissionAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteSubmissionAssignmentResponse> deleteSubmissionAssignmentById(
            @PathVariable UUID submissionAssignmentId
    ) {
        log.info("Deleting submission assignment by id");
       DeleteSubmissionAssignmentResponse response = submissionAssignmentApplicationService
               .deleteSubmissionAssignmentById(DeleteSubmissionAssignmentCommand.builder()
               .submissionAssignmentId(submissionAssignmentId)
               .build());

        return ResponseEntity.ok(response);

    }

    @PutMapping("/{submissionAssignmentId}")
    @Operation(summary = "Update submission assignment by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateSubmissionAssignmentResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateSubmissionAssignmentResponse> updateSubmissionAssignmentById(
            @PathVariable UUID submissionAssignmentId,
            @RequestBody UpdateSubmissionAssignmentCommand updateSubmissionAssignmentCommand
    ) {
        log.info("Updating submission assignment by id");
        UpdateSubmissionAssignmentResponse response = submissionAssignmentApplicationService
                .updateSubmissionAssignmentById(updateSubmissionAssignmentCommand.builder()
                        .isGraded(updateSubmissionAssignmentCommand.getIsGraded())
                        .submissionAssignmentId(submissionAssignmentId)
                        .grade(updateSubmissionAssignmentCommand.getGrade())
                        .content(updateSubmissionAssignmentCommand.getContent())
                        .timeSubmit(updateSubmissionAssignmentCommand.getTimeSubmit())
                        .build());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user")
    @Operation(summary = "Query submission assignment by assignment id and user id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = SubmissionAssignmentResponseEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<SubmissionAssignmentResponseEntity> queryByAssignmentIdAndUserId(
            @RequestParam UUID assignmentId,
            @RequestParam UUID userId
    ) {
        log.info("Querying submission assignment by assignment id and user id");
        SubmissionAssignmentResponseEntity response = submissionAssignmentApplicationService
                .queryByAssignmentIdAndUserId(new QuerySubmissionAssignmentUserCommand(assignmentId, userId));
        return ResponseEntity.ok(response);
    }

}
