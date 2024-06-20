package com.backend.programming.learning.system.auth.service.application.rest.submission_grade;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment.CreateSubmissionAssignmentResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade.CreateSubmissionGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_grade.CreateSubmissionGradeResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_grade.UpdateSubmissionGradeCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.submission_grade.UpdateSubmissionGradeResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.submission_grade.SubmissionGradeApplicationService;
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
@RequestMapping(value = "/course/submission-grade", produces = "application/vnd.api.v1+json")
public class SubmissionGradeController {
    private final SubmissionGradeApplicationService submissionGradeApplicationService;

    @PostMapping
    @Operation(summary = "Create submission grade.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Success.", content = {
                @Content(mediaType = "application/vnd.api.v1+json",
                        schema = @Schema(implementation = CreateSubmissionGradeResponse.class))
        }),
        @ApiResponse(responseCode = "400", description = "Not found."),
        @ApiResponse(responseCode = "500", description = "Unexpected error.")})
public ResponseEntity<CreateSubmissionGradeResponse> createSubmissionGrade(@RequestBody CreateSubmissionGradeCommand createSubmissionGradeCommand) {
        log.info("Create submission grade request received");
        CreateSubmissionGradeResponse createSubmissionGradeResponse = submissionGradeApplicationService.createSubmissionGrade(createSubmissionGradeCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createSubmissionGradeResponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update submission grade.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success.", content = {
                @Content(mediaType = "application/vnd.api.v1+json",
                        schema = @Schema(implementation = UpdateSubmissionGradeResponse.class))
        }),
        @ApiResponse(responseCode = "400", description = "Not found."),
        @ApiResponse(responseCode = "500", description = "Unexpected error.")})

    public ResponseEntity<UpdateSubmissionGradeResponse> updateSubmissionGrade(@RequestBody UpdateSubmissionGradeCommand updateSubmissionGradeCommand, @PathVariable("id") UUID id) {
        log.info("Update submission grade request received");
        UpdateSubmissionGradeResponse updateSubmissionGradeResponse = submissionGradeApplicationService.updateSubmissionGrade(updateSubmissionGradeCommand, id);
        return ResponseEntity.status(HttpStatus.OK).body(updateSubmissionGradeResponse);
    }
}
