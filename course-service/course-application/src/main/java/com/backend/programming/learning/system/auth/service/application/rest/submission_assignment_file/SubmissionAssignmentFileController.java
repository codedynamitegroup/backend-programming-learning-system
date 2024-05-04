package com.backend.programming.learning.system.auth.service.application.rest.submission_assignment_file;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_file.CreateSubmissionAssignmentFileResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.submission_assignment_onlinetext.CreateSubmissionAssignmentOnlineTextResponse;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/assignment/submission_assignment_file", produces = "application/vnd.api.v1+json")
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
}
