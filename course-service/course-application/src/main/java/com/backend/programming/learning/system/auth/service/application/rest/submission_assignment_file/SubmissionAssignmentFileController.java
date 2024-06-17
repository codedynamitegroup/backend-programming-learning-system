package com.backend.programming.learning.system.auth.service.application.rest.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_file.DeleteSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.submission_assignment_file.DeleteSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment_file.UpdateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_assignment_file.UpdateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_assignment_file.SubmissionAssignmentFileApplicationService;
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
@RequestMapping(value = "/course/submission-assignment-file", produces = "application/vnd.api.v1+json")
public class SubmissionAssignmentFileController {
    private final SubmissionAssignmentFileApplicationService submissionAssignmentFileApplicationService;

    @PostMapping
    @Operation(summary = "Create submission assignment file.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = CreateSubmissionAssignmentFileResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<CreateSubmissionAssignmentFileResponse> createSubmissionAssignmentFile(@RequestBody CreateSubmissionAssignmentFileCommand createSubmissionAssignmentFileCommand) {
        log.info("Creating submission assignment file");
        CreateSubmissionAssignmentFileResponse response = submissionAssignmentFileApplicationService
                .createSubmissionAssignmentFile(createSubmissionAssignmentFileCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update submission assignment file.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = UpdateSubmissionAssignmentFileResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<UpdateSubmissionAssignmentFileResponse> updateSubmissionAssignmentFile
            (
            @RequestBody UpdateSubmissionAssignmentFileCommand updateSubmissionAssignmentFileCommand,
            @PathVariable UUID id) {
        log.info("Updating submission assignment file");
        UpdateSubmissionAssignmentFileResponse response = submissionAssignmentFileApplicationService
                .updateSubmissionAssignmentFile(updateSubmissionAssignmentFileCommand, id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete submission assignment file.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/vnd.api.v1+json",
                            schema = @Schema(implementation = DeleteSubmissionAssignmentFileResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<DeleteSubmissionAssignmentFileResponse> deleteSubmissionAssignmentFile(@PathVariable UUID id) {
        log.info("Deleting submission assignment file");
        DeleteSubmissionAssignmentFileResponse response = submissionAssignmentFileApplicationService
                .deleteSubmissionAssignmentFile(new DeleteSubmissionAssignmentFileCommand(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
